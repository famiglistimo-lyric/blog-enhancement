package com.yi.enhancement.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.aliyun.oss.common.utils.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.constant.enums.DeletedEnum;
import com.yi.enhancement.constant.enums.StatusEnum;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.exception.ExceptionCodeEnum;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.ArticleTagRelationDTO;
import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.mapper.ArticleMapper;
import com.yi.enhancement.model.entity.ArticleTagRelation;
import com.yi.enhancement.model.entity.Tag;
import com.yi.enhancement.model.vo.ArticleVo;
import com.yi.enhancement.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.enhancement.service.IArticleTagRelationService;
import com.yi.enhancement.service.ITagService;
import com.yi.enhancement.service.IUserService;
import com.yi.enhancement.util.MarkdownUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    private final ITagService tagService;

    private final IArticleTagRelationService articleTagRelationService;

    public ArticleServiceImpl(IArticleTagRelationService articleTagRelationService,
                              ITagService tagService) {
        this.articleTagRelationService = articleTagRelationService;
        this.tagService = tagService;
    }

    @Override
    public Article getAndConvert(Integer id) throws CustomException {
        Article article = this.baseMapper.selectById(id);
        if (article == null) {
            throw new CustomException(ExceptionCodeEnum.BLOG_NOT_EXIST_EXCEPTION.getMessage());
        }
        Integer views = article.getViews();
        views = views + 1;
        article.setViews(views);
        this.baseMapper.updateById(article);
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        String content = articleVo.getContent();
        articleVo.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        if (articleVo.getStamp()) {
            articleVo.setStampString("原创");
        } else {
            articleVo.setStampString("转载");
        }
        return articleVo;
    }

    @Override
    public IPage<ArticleDTO> pageArticle(String title, Integer status, Integer categoryId, Integer tagId, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ArticleDTO> pageCondition = new Page<>(page, pageSize);
        List<Integer> articleIdList = null;
        if (tagId != null) {
            articleIdList = articleTagRelationService.listArticleId(tagId);
        }
        IPage<ArticleDTO> articleIPage = this.baseMapper.pageArticleDTO(pageCondition, title, status, categoryId, articleIdList);
        // key:文章id;value:文章的tagList
        Map<Integer, List<Tag>> articleTagListMap = new HashMap<>(16);
        List<ArticleDTO> records = articleIPage.getRecords();
        if (CollUtil.isEmpty(records)) {
            return articleIPage;
        }
        for (ArticleDTO record : records) {
            articleTagListMap.put(record.getId(), new ArrayList<>());
        }
        List<Integer> articleIds = records.stream().map(Article::getId).collect(Collectors.toList());
        List<ArticleTagRelationDTO> articleTagRelationDTOList = articleTagRelationService.listArticleTagRelation(articleIds);
        for (ArticleTagRelationDTO articleTagRelationDTO : articleTagRelationDTOList) {
            Integer articleId = articleTagRelationDTO.getArticleId();
            Tag tag = new Tag();
            tag.setId(articleTagRelationDTO.getTagId());
            tag.setName(articleTagRelationDTO.getTagName());
            articleTagListMap.get(articleId).add(tag);
        }
        for (ArticleDTO record : records) {
            Integer id = record.getId();
            record.setTagList(articleTagListMap.get(id));
        }
        return articleIPage;
    }

    @Override
    public IPage<ArticleDTO> pageArticleWeb(Integer categoryId, Integer tagId, String queryCondition, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ArticleDTO> pageCondition = new Page<>(page, pageSize);
        return this.baseMapper.pageArticleDTOWeb(pageCondition, StatusEnum.PUBLIC.getCode());
    }

    @Override
    public Map<String, List<ArticleVo>> listArticleVo(Integer categoryId, Integer tagId, String queryCondition) {
        HashMap<String, List<ArticleVo>> articleVoMap = new HashMap<>();
        List<Integer> articleIdList = null;
        if (tagId != null) {
            articleIdList = articleTagRelationService.listArticleId(tagId);
        }
        List<ArticleVo> articleVoList = this.baseMapper.listArticleVo(categoryId, articleIdList, queryCondition, StatusEnum.PUBLIC.getCode());
        for (ArticleVo articleVo : articleVoList) {
            Date createTime = articleVo.getCreateTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            String articleYear = formatter.format(createTime);
            if (CollectionUtils.isEmpty(articleVoMap.get(articleYear))) {
                articleVoMap.put(articleYear, new ArrayList<>());
            }
            List<ArticleVo> articleVos = articleVoMap.get(articleYear);
            articleVos.add(articleVo);
        }
        return articleVoMap;
    }

    @Override
    public void deleteArticle(Integer articleId) {
        QueryWrapper<Article> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("id", articleId);
        this.remove(queryWrapper1);
        QueryWrapper<ArticleTagRelation> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("article_id", articleId);
        articleTagRelationService.remove(queryWrapper2);
    }

    @Override
    public ArticleDTO getArticle(Integer id) {
        return this.baseMapper.getArticle(id);
    }

    @Override
    public ArticleDTO getArticleDetail(Integer id) {
        return this.baseMapper.getArticleDetail(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveArticle(ArticleDTO articleDTO) throws CustomException {
        Article article = new Article();
        BeanUtils.copyProperties(articleDTO, article);
        try {
            article.setUpdateTime(new Date());
            this.saveOrUpdate(article);
        } catch (DuplicateKeyException e) {
            throw new CustomException(ExceptionCodeEnum.TITLE_EXISTED_EXCEPTION.getMessage());
        }
        List<Tag> tagList = articleDTO.getTagList();
        // 将新标签插入数据库
        List<Tag> willSaveTagList = tagList.stream().filter((item) -> item.getId() == null).collect(Collectors.toList());
        tagService.saveBatch(willSaveTagList);
        List<ArticleTagRelation> willInsertArticleTagRelationList = new ArrayList<>();
        for (Tag tag : tagList) {
            ArticleTagRelation articleTagRelation = new ArticleTagRelation();
            articleTagRelation.setTagId(tag.getId());
            articleTagRelation.setArticleId(article.getId());
//            articleTagRelation.setDeleted(DeletedEnum.UNDELETED.getCode());
//            if(!article.getStatus()){
//                articleTagRelation.setDeleted(DeletedEnum.DELETED.getCode());
//            }
            willInsertArticleTagRelationList.add(articleTagRelation);
        }
        articleTagRelationService.deleteReally(article.getId());
        articleTagRelationService.saveBatch(willInsertArticleTagRelationList);
        return true;
    }


}

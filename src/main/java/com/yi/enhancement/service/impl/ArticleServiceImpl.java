package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.exception.ExceptionCodeEnum;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.dto.ArticleTagRelationDTO;
import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.mapper.ArticleMapper;
import com.yi.enhancement.model.entity.ArticleTagRelation;
import com.yi.enhancement.model.entity.Tag;
import com.yi.enhancement.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.enhancement.service.IArticleTagRelationService;
import com.yi.enhancement.service.ITagService;
import com.yi.enhancement.service.IUserService;
import com.yi.enhancement.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private final IUserService userService;

    private final ITagService tagService;

    private final IArticleTagRelationService articleTagRelationService;

    public ArticleServiceImpl(IUserService userService,
                              IArticleTagRelationService articleTagRelationService,
                              ITagService tagService) {
        this.articleTagRelationService = articleTagRelationService;
        this.userService = userService;
        this.tagService = tagService;
    }

    @Override
    public Article getAndConvert(Long id) throws CustomException {
        Article article = this.baseMapper.selectById(id);
        if (article == null) {
            throw new CustomException(ExceptionCodeEnum.BLOG_NOT_EXIST_EXCEPTION.getMessage());
        }
        Integer views = article.getViews();
        views = views + 1;
        article.setViews(views);
        this.baseMapper.updateById(article);
        Article articleVo = new Article();
        BeanUtils.copyProperties(article, articleVo);
        String content = articleVo.getContent();
        articleVo.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return articleVo;
    }

    @Override
    public IPage<ArticleDTO> pageArticle(String title, Integer status, Long categoryId, Long tagId, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ArticleDTO> pageCondition = new Page<>(page, pageSize);
        List<Long> articleIdList = null;
        if (tagId != null) {
            articleIdList = articleTagRelationService.listArticleId(tagId);
        }
        IPage<ArticleDTO> articleIPage = this.baseMapper.pageArticleDTO(pageCondition, title, status, categoryId, articleIdList);
        // key:文章id;value:文章的tagList
        Map<Long, List<Tag>> articleTagListMap = new HashMap<>(16);
        List<ArticleDTO> records = articleIPage.getRecords();
        for (ArticleDTO record : records) {
            articleTagListMap.put(record.getId(), new ArrayList<>());
        }
        List<Long> articleIds = records.stream().map(Article::getId).collect(Collectors.toList());
        List<ArticleTagRelationDTO> articleTagRelationDTOList = articleTagRelationService.listArticleTagRelation(articleIds);
        for (ArticleTagRelationDTO articleTagRelationDTO : articleTagRelationDTOList) {
            Long articleId = articleTagRelationDTO.getArticleId();
            Tag tag = new Tag();
            tag.setId(articleTagRelationDTO.getTagId());
            tag.setName(articleTagRelationDTO.getTagName());
            articleTagListMap.get(articleId).add(tag);
        }
        for (ArticleDTO record : records) {
            Long id = record.getId();
            record.setTagList(articleTagListMap.get(id));
        }
        return articleIPage;
    }

    @Override
    public IPage<ArticleDTO> pageArticleWeb(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ArticleDTO> pageCondition = new Page<>(page, pageSize);
        return this.baseMapper.pageArticleDTOWeb(pageCondition);
    }

    @Override
    public ArticleDTO getArticle(Long id) {
        return this.baseMapper.getArticle(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveArticle(ArticleDTO articleDTO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDTO, article);
        this.saveOrUpdate(article);
        List<Tag> tagList = articleDTO.getTagList();
        // 将新标签插入数据库
        List<Tag> willInsertTagList = tagList.stream().filter((item) -> item.getId() == null).collect(Collectors.toList());
        tagService.saveBatch(willInsertTagList);
        List<ArticleTagRelation> willInsertArticleTagRelationList = new ArrayList<>();
        for (Tag tag : tagList) {
            ArticleTagRelation articleTagRelation = new ArticleTagRelation();
            articleTagRelation.setTagId(tag.getId());
            articleTagRelation.setArticleId(article.getId());
            willInsertArticleTagRelationList.add(articleTagRelation);
        }
        QueryWrapper<ArticleTagRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id",article.getId());
        articleTagRelationService.remove(queryWrapper);
        articleTagRelationService.saveBatch(willInsertArticleTagRelationList);
        return true;
    }
}

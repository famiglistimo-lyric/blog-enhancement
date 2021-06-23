package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.exception.IndexNotFoundException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.mapper.ArticleMapper;
import com.yi.enhancement.model.entity.Tag;
import com.yi.enhancement.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.enhancement.service.IArticleTagRelationService;
import com.yi.enhancement.service.ITagService;
import com.yi.enhancement.service.IUserService;
import com.yi.enhancement.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final IArticleTagRelationService articleTagRelationService;

    public ArticleServiceImpl(IUserService userService,
                              IArticleTagRelationService articleTagRelationService) {
        this.articleTagRelationService = articleTagRelationService;
        this.userService = userService;
    }

    @Override
    public Article getAndConvert(Long id) {
        Article article = this.baseMapper.selectById(id);
        if (article == null) {
            throw new IndexNotFoundException("该博客不存在");
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
    public IPage<ArticleDTO> pageArticle(String title, Integer status, Integer categoryId, Integer tagId, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ArticleDTO> pageCondition = new Page<>(page, pageSize);
        List<Long> articleIdList = null;
        if(tagId != null){
            articleIdList = articleTagRelationService.listArticleId(tagId);
        }
        return this.baseMapper.pageArticleDTO(pageCondition, title, status, categoryId, articleIdList);
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
}

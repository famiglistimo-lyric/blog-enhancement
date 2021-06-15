package com.yi.enhancement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.exception.IndexNotFoundException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.mapper.ArticleMapper;
import com.yi.enhancement.model.entity.User;
import com.yi.enhancement.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.enhancement.service.ICategoryService;
import com.yi.enhancement.service.ITagService;
import com.yi.enhancement.service.IUserService;
import com.yi.enhancement.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

    public ArticleServiceImpl(IUserService userService){
        this.userService = userService;
    }

    @Override
    public IPage<ArticleDTO> pageArticleDTO(int currentPage, int size) {
        Page<ArticleDTO> pageCondition = new Page<>(currentPage, size);
        return this.baseMapper.pageArticleDTO(pageCondition);
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
}

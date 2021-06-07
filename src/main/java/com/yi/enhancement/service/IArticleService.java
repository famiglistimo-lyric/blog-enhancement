package com.yi.enhancement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface IArticleService extends IService<Article> {

    /**
     * 文章分页
     * @param currentPage:当前页
     * @param size:每页数据量
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleDTO(int currentPage, int size);
}

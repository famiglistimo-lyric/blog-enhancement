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
     * 根据id查到文章内容,并转换为markdown形式
     * @param id 文章id
     * @return 文章内容
     */
    Object getAndConvert(Long id);

    /**
     * 文章分页
     * @param title 查询条件:标题
     * @param page 当前页
     * @param pageSize 每页数据量
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticle(String title, Integer page, Integer pageSize);
}

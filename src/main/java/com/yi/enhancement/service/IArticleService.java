package com.yi.enhancement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException;
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
     *
     * @param id 文章id
     * @return 文章内容
     */
    Object getAndConvert(Long id) throws CustomException;

    /**
     * 文章分页
     * @param title 查询条件:标题
     * @param status 查询条件:状态
     * @param categoryId 查询条件:分类Id
     * @param tagId 查询条件:标签Id
     * @param page 当前页
     * @param pageSize 每页数据量
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticle(String title, Integer status, Integer categoryId, Integer tagId, Integer page, Integer pageSize);

    /**
     * 文章分页
     * @param page     当前页
     * @param pageSize 每页数据量
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleWeb(Integer page, Integer pageSize);

    /**
     * 根据文章id获得文章详情
     * @param id 文章id
     * @return 文章详情
     */
    ArticleDTO getArticle(Long id);

    /**
     * 保存文章的相关信息
     * @param articleDTO 文章DTO
     * @return 是否成功
     */
    boolean saveArticle(ArticleDTO articleDTO);
}

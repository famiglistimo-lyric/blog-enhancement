package com.yi.enhancement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.enhancement.model.vo.ArticleVo;

import java.util.List;
import java.util.Map;

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
     * @throws CustomException 异常
     */
    Article getAndConvert(Long id) throws CustomException;

    /**
     * 文章分页
     *
     * @param title      查询条件:标题
     * @param status     查询条件:状态
     * @param categoryId 查询条件:分类Id
     * @param tagId      查询条件:标签Id
     * @param page       当前页
     * @param pageSize   每页数据量
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticle(String title, Integer status, Long categoryId, Long tagId, Integer page, Integer pageSize);

    /**
     * 主页的文章分页
     *
     * @param categoryId     文章分类id
     * @param tagId          文章标签id
     * @param queryCondition 搜索条件
     * @param page           当前页
     * @param pageSize       每页数据量
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleWeb(Long categoryId, Long tagId, String queryCondition, Integer page, Integer pageSize);

    /**
     * 根据文章id获得文章详情(不获取内容)
     *
     * @param id 文章id
     * @return 文章详情
     */
    ArticleDTO getArticle(Long id);

    /**
     * 根据文章id获得文章详情
     *
     * @param id 文章id
     * @return 文章详情
     */
    ArticleDTO getArticleDetail(Long id);

    /**
     * 保存文章的相关信息
     *
     * @param articleDTO 文章DTO
     * @return 是否成功
     * @throws CustomException 异常
     */
    boolean saveArticle(ArticleDTO articleDTO) throws CustomException;

    /**
     * 主页的文章列表
     *
     * @param categoryId     文章分类id
     * @param tagId          文章标签id
     * @param queryCondition 搜索条件
     * @return 文章列表
     */
    Map<String, List<ArticleVo>> listArticleVo(Long categoryId, Long tagId, String queryCondition);

    /**
     * 删除文章
     *
     * @param articleId 文章id
     */
    void deleteArticle(Long articleId);
}

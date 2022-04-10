package com.yi.enhancement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.enhancement.model.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 文章分页
     *
     * @param pageCondition 分页条件
     * @param title         查询条件:标题
     * @param status        查询条件:状态
     * @param categoryId    查询条件:分类
     * @param articleIdList 查询条件:根据标签筛选出来的文章id
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleDTO(Page<ArticleDTO> pageCondition, String title, Integer status, Integer categoryId,
                                     @Param("articleIdList") List<Integer> articleIdList);

    /**
     * 文章分页
     *
     * @param pageCondition 分页条件
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleDTOWeb(Page<ArticleDTO> pageCondition, @Param("status") Integer status);

    /**
     * 根据文章id获取文章详情(不获取内容)
     *
     * @param articleId 文章id
     * @return 文章详情
     */
    ArticleDTO getArticle(Integer articleId);

    /**
     * 根据文章id获取文章详情
     *
     * @param articleId 文章id
     * @return 文章详情
     */
    ArticleDTO getArticleDetail(Integer articleId);

    /**
     * 主页的文章列表
     *
     * @param categoryId     文章分类id
     * @param articleIdList  文章idList
     * @param queryCondition 搜索条件
     * @return 文章列表
     */
    List<ArticleVo> listArticleVo(Integer categoryId, @Param("articleIdList") List<Integer> articleIdList, String queryCondition, @Param("status") Integer status);


}

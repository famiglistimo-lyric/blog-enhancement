package com.yi.enhancement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 文章分页
     * @param pageCondition 分页条件
     * @param title         查询条件:标题
     * @param status        查询条件:状态
     * @param categoryId    查询条件:分类
     * @param articleIdList 查询条件:根据标签筛选出来的文章id
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleDTO(Page<ArticleDTO> pageCondition, String title, Integer status, Long categoryId,
                                     @Param("articleIdList") List<Long> articleIdList);

    /**
     * 文章分页
     * @param pageCondition 分页条件
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleDTOWeb(Page<ArticleDTO> pageCondition);

    /**
     * 根据文章id获取文章详情
     * @param articleId 文章id
     * @return 文章详情
     */
    ArticleDTO getArticle(Long articleId);
}

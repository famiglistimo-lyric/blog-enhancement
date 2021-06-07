package com.yi.enhancement.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yi.enhancement.model.dto.ArticleDTO;
import com.yi.enhancement.model.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 文章分页
     * @param pageCondition :分页条件
     * @return 文章列表
     */
    IPage<ArticleDTO> pageArticleDTO(Page<ArticleDTO> pageCondition);
}

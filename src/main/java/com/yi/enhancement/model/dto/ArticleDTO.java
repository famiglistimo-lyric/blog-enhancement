package com.yi.enhancement.model.dto;

import com.yi.enhancement.model.entity.Article;
import com.yi.enhancement.model.entity.Category;
import com.yi.enhancement.model.entity.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author: lyric
 * @date: 2021/6/2 14:42
 * @description: 文章DTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleDTO extends Article {
    /**
     * 文章标签列表
     */
    private List<Tag> tagList;
    /**
     * 文章分类
     */
    private Category category;
    /**
     * 评论量
     */
    private Integer commentCounts;
}

package com.yi.enhancement.model.vo;

import com.yi.enhancement.model.entity.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: lyric
 * @date: 2021/7/24 18:15
 * @description: 文章分类Vo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryVo extends Category {

    /**
     * 是否属于当前文章
     */
    private boolean hit;

    /**
     * 文章数
     */
    private Integer articleCounts;
}

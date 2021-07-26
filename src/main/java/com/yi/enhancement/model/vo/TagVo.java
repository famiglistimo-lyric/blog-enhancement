package com.yi.enhancement.model.vo;

import com.yi.enhancement.model.entity.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: lyric
 * @date: 2021/7/24 20:30
 * @description: 文章标签Vo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TagVo extends Tag {

    /**
     * 是否属于当前文章
     */
    private boolean hit;

    /**
     * 文章数
     */
    private Integer articleCounts;
}

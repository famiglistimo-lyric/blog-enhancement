package com.yi.enhancement.model.dto;

import com.yi.enhancement.model.entity.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: lyric
 * @date: 2021/6/2 16:30
 * @description: 文章标签DTO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TagDTO extends Tag {
    /**
     * 文章数
     */
    private Integer articleCounts;
}

package com.yi.enhancement.model.dto;

import com.yi.enhancement.model.entity.ArticleTagRelation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: lyric
 * @date: 2021/6/24 13:52
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleTagRelationDTO extends ArticleTagRelation {
    private String tagName;
}

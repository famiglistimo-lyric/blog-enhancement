package com.yi.enhancement.model.vo;

import com.yi.enhancement.model.entity.Article;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: lyric
 * @date: 2021/7/4 12:32
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleVo extends Article {
    /**
     * 原创:1;转载:0
     */
    String stampString;
}

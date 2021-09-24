package com.yi.enhancement.model.dashboard;

import lombok.Data;

/**
 * @author: lyric
 * @date: 2021/9/19 12:56
 * @description: 评论数据
 */
@Data
public class CommentCardData {
    /**
     * 总评论数
     */
    private Integer totalComments;
    /**
     * 周同比
     */
    private String weekGrowth;
    /**
     * 日同比
     */
    private String dayGrowth;
    /**
     * 周同比增长
     */
    private Integer dayComments;
}

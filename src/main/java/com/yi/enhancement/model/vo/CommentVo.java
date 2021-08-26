package com.yi.enhancement.model.vo;

import com.yi.enhancement.model.entity.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author: lyric
 * @date: 2021/8/12 19:31
 * @description: 评论Vo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommentVo extends Comment {

    /**
     * 评论的子评论
     */
    private List<CommentVo> childrenComments;

    /**
     * 评论的父级评论
     */
    private CommentVo parentComment;

    /**
     * 评论展示的时间字段
     */
    private String commentDate;
}

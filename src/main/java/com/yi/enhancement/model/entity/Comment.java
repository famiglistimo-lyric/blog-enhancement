package com.yi.enhancement.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lwj
 * @since 2021-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否是管理员评论
     */
    private Boolean managerComment;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 父级的评论id
     */
    private Long parentCommentId;

    /**
     * ip地址+时间
     */
    private String ipAndTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}

package com.yi.enhancement.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章首图
     */
    private String firstPicture;

    /**
     * 原创:1;转载:0
     */
    private Boolean stamp;

    /**
     * 可以评论:1;不可评论:0
     */
    private Boolean comments;

    /**
     * 可以转载:1;不可转载:0
     */
    private Boolean original;

    /**
     * 发布:1;草稿:0
     */
    private Boolean published;

    /**
     * 推荐:1;不推荐:0
     */
    private Boolean recommend;

    /**
     * 可赞赏:1;不可赞赏:0
     */
    private Boolean appreciate;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属分类id
     */
    private Long categoryId;

    /**
     * 所属用户id
     */
    private Long userId;


}

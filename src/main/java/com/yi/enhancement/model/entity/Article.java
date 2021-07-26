package com.yi.enhancement.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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

    @TableId(type = IdType.ASSIGN_ID)
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
     * 文章状态:发布:1;草稿:0
     */
    private Boolean status;

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
    @TableField(value = "views", fill = FieldFill.INSERT)
    private Integer views;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 所属分类id
     */
    private Long categoryId;

    /**
     * 所属用户id
     */
    private Long userId;

    /**
     * 逻辑删除:1:已删除;0:未删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;

}

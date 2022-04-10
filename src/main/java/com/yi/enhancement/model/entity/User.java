package com.yi.enhancement.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 登录账号
     */
    private String loginAccount;

    /**
     * 用户密码
     */
    private String password;

    /**
     * qq账号
     */
    private String qq;

    /**
     * 邮箱账号
     */
    private String email;

    /**
     * 微信账号
     */
    private String wechat;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 首页图片地址
     */
    private String banner;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 个性签名
     */
    private String userSignature;

    /**
     * 浏览次数
     */
    private Integer views;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除:1:已删除;0:未删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;


}

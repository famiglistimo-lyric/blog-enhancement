package com.yi.enhancement.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

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

    @TableId
    private Long id;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private StringBuilder provinceAndCity;

    public StringBuilder getProvinceAndCity() {
        StringBuilder provinceAndCity = new StringBuilder();
        provinceAndCity.append(this.province);
        provinceAndCity.append(" ");
        provinceAndCity.append(this.city);
        return provinceAndCity;
    }


}

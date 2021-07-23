package com.yi.enhancement.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 技术支持表
 * </p>
 *
 * @author lwj
 * @since 2021-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TechnicalSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 技术支持者的个人网站地址
     */
    private String technicalSupportWebsite;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 职业
     */
    private String profession;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date updateTime;

    /**
     * 逻辑删除:1:已删除;0:未删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;


}

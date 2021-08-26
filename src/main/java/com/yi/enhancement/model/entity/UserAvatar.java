package com.yi.enhancement.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwj
 * @since 2021-08-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAvatar implements Serializable {

    private static final long serialVersionUID = 1L;

    private String avatar;

    private String userKey;

    private Date createTime;

    private Date updateTime;


}

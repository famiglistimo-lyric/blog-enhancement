package com.yi.enhancement.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String content;

    private String firstPicture;

    private String stamp;

    private Boolean comments;

    private Boolean original;

    private Boolean published;

    private Boolean recommend;

    private Boolean appreciate;

    private Integer views;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long blogTypeId;

    private Long userId;


}

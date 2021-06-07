package com.yi.enhancement.model.entity;

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
public class ArticleTagRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    private Long blogId;

    /**
     * 文章标签id
     */
    private Long tagId;


}

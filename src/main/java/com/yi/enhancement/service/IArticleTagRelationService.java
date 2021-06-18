package com.yi.enhancement.service;

import com.yi.enhancement.model.entity.ArticleTagRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface IArticleTagRelationService extends IService<ArticleTagRelation> {

    /**
     * 根据标签Id得到属于该标签的所有文章Id
     * @param tagId 标签Id
     * @return 所有文章Id
     */
    List<Long> listArticleId(Integer tagId);
}

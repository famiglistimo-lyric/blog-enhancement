package com.yi.enhancement.service;

import com.yi.enhancement.model.dto.ArticleTagRelationDTO;
import com.yi.enhancement.model.entity.ArticleTagRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface IArticleTagRelationService extends IService<ArticleTagRelation> {

    /**
     * 根据标签Id得到属于该标签的所有文章Id
     *
     * @param tagId 标签Id
     * @return 所有文章Id
     */
    List<Integer> listArticleId(Integer tagId);

    /**
     * 根据文章Id查出所有的文章标签
     *
     * @param articleIds 文章id
     * @return 文章和标签的关系DTO
     */
    List<ArticleTagRelationDTO> listArticleTagRelation(List<Integer> articleIds);


    /**
     * 根据文章Id查出所有的文章标签
     *
     * @param articleId 文章id
     * @param deleted   删除标志
     * @return 文章和标签的关系
     */
    List<ArticleTagRelation> listArticleTagRelationByArticleId(Integer articleId, Integer deleted);

    /**
     * 根据文章id删除文章标签
     *
     * @param articleId 文章id
     */
    void deleteReally(Integer articleId);
}

package com.yi.enhancement.mapper;

import com.yi.enhancement.model.dto.ArticleTagRelationDTO;
import com.yi.enhancement.model.entity.ArticleTagRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.enhancement.model.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 文章-标签关系表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Mapper
@Repository
public interface ArticleTagRelationMapper extends BaseMapper<ArticleTagRelation> {

    /**
     * 根据标签Id得到属于该标签的所有文章Id
     *
     * @param tagId 标签Id
     * @return 所有文章Id
     */
    List<Long> listArticleId(Long tagId);

    /**
     * 根据文章id获取该文章的所有标签
     *
     * @param articleId 文章id
     * @return tag列表
     */
    List<Tag> listTagByArticleId(Long articleId);

    /**
     * 根据文章Id查出所有的文章标签
     *
     * @param articleIds 文章id
     * @return 文章和标签的关系DTO
     */
    List<ArticleTagRelationDTO> listArticleTagRelation(@Param("articleIds") List<Long> articleIds);

    /**
     * 根绝文章Id查出所有的文章标签
     *
     * @param articleId 文章id
     * @return 文章和标签的关系
     */
    List<ArticleTagRelation> listArticleTagRelationByArticleId(@Param("articleId") Long articleId, @Param("deleted") Integer deleted);

    /**
     * 根据文章id删除文章标签
     *
     * @param articleId 文章id
     */
    void deleteReally(@Param("articleId") Long articleId);
}

package com.yi.enhancement.mapper;

import com.yi.enhancement.model.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yi.enhancement.model.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-20
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 查询该文章下的所有评论
     * @param articleId 文章id
     * @return 该文章的所有评论
     */
    List<CommentVo> listCommentByArticleId(Long articleId);
}

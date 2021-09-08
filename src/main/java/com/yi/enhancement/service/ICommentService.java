package com.yi.enhancement.service;

import com.yi.enhancement.model.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.enhancement.model.vo.CommentVo;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-20
 */
public interface ICommentService extends IService<Comment> {

    /**
     * 查询文章下的所有评论
     *
     * @param articleId 文章id
     * @return 评论列表
     */
    List<CommentVo> listByArticleId(Long articleId);

    /**
     * 保存评论
     *
     * @param comment 评论
     */
    void saveComment(Comment comment);

    /**
     * 校验评论的参数
     * @param comment 评论
     * @return 校验结果
     */
    String judgeParams(Comment comment);
}

package com.yi.enhancement.service;

import com.yi.enhancement.model.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yi.enhancement.model.vo.CommentVo;

import javax.servlet.http.HttpServletRequest;
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
     *
     * @param comment 评论
     * @param request 请求参数
     */
    void saveComment(Comment comment, HttpServletRequest request);

    /**
     * 校验评论的参数
     *
     * @param comment 评论
     * @return 校验结果
     */
    String judgeParams(Comment comment);

    /**
     * 根据请求信息,获取浏览器+浏览器版本信息+操作系统的信息
     *
     * @param request 请求
     * @param comment 评论
     * @return 评论
     */
    Comment getExtra(HttpServletRequest request, Comment comment);
}

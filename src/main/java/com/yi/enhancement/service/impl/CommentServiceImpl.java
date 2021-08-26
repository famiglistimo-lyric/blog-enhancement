package com.yi.enhancement.service.impl;

import com.aliyun.oss.common.utils.DateUtil;
import com.yi.enhancement.model.entity.Comment;
import com.yi.enhancement.mapper.CommentMapper;
import com.yi.enhancement.model.vo.CommentVo;
import com.yi.enhancement.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.enhancement.util.CommentDateUtil;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Override
    public List<CommentVo> listByArticleId(Long articleId) {
        // 查出该文章下的所有评论
        List<CommentVo> allComment = this.baseMapper.listCommentByArticleId(articleId);
        return allComment.stream()
                .peek((element) -> element.setCommentDate(CommentDateUtil.formatCommentDate(System.currentTimeMillis(),element.getCreateTime())))
                .filter((element) -> element.getParentCommentId() == 0)
                .peek((element) -> {
                    List<CommentVo> list = new ArrayList<>();
                    getChildrenComments(element, allComment, list);
                    element.setChildrenComments(list);
                }).collect(Collectors.toList());
    }

    private List<CommentVo> getChildrenComments(CommentVo currentComment, List<CommentVo> allComment, List<CommentVo> list) {
        return allComment.stream()
                .filter((element) -> element.getParentCommentId().equals(currentComment.getId()))
                .peek((element) -> {
                    element.setParentComment(currentComment);
                    list.add(element);
                    element.setChildrenComments(getChildrenComments(element, allComment, list));
                }).collect(Collectors.toList());
    }

    @Override
    public void saveComment(Comment comment) {
        Long parentCommentId = comment.getParentCommentId();
        // 不等于-1，说明有父级
        if (parentCommentId != -1) {
            comment.setParentCommentId(parentCommentId);
        } else {
            comment.setParentCommentId(0L);
        }
        this.baseMapper.insert(comment);
    }
}

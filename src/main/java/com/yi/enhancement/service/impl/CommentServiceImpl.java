package com.yi.enhancement.service.impl;

import cn.hutool.core.util.StrUtil;
import com.yi.enhancement.constant.Constant;
import com.yi.enhancement.model.entity.Comment;
import com.yi.enhancement.mapper.CommentMapper;
import com.yi.enhancement.model.vo.CommentVo;
import com.yi.enhancement.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yi.enhancement.util.CommentDateUtil;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
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
                .peek((element) -> element.setCommentDate(CommentDateUtil.formatCommentDate(System.currentTimeMillis(), element.getCreateTime())))
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

    @Override
    public String judgeParams(Comment comment) {
        StringBuilder errorMessage = new StringBuilder();
        String nickname = comment.getNickname();
        if (StringUtils.isEmpty(nickname)) {
            errorMessage.append(Constant.NICKNAME_NOT_NULL);
        }
        String email = comment.getEmail();
        if (StringUtils.isEmpty(email)) {
            errorMessage.append(Constant.EMAIL_NOT_NULL);
        }
        String content = comment.getContent();
        if (StringUtils.isEmpty(content)) {
            errorMessage.append(Constant.CONTENT_NOT_NULL);
        }
        if (StrUtil.isNotEmpty(content) && content.length() > Constant.COMMENT_CONTENT_LENGTH_MAX) {
            errorMessage.append(Constant.LENGTH_TOO_LONG);
        }
        return errorMessage.toString();
    }
}

package com.yi.enhancement.service.impl;

import com.yi.enhancement.model.entity.Comment;
import com.yi.enhancement.mapper.CommentMapper;
import com.yi.enhancement.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

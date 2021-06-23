package com.yi.enhancement.mapper;

import com.yi.enhancement.model.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-20
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}

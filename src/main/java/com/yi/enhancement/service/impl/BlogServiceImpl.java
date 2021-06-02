package com.yi.enhancement.service.impl;

import com.yi.enhancement.model.entity.Blog;
import com.yi.enhancement.mapper.BlogMapper;
import com.yi.enhancement.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

}

package com.yi.enhancement.service.impl;

import com.yi.enhancement.model.entity.User;
import com.yi.enhancement.mapper.UserMapper;
import com.yi.enhancement.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 用户表	 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public synchronized User updateViews(Long userId) {
        User user = this.baseMapper.selectById(userId);
        Integer views = user.getViews();
        views = views + 1;
        user.setViews(views);
        this.baseMapper.updateById(user);
        return user;
    }
}

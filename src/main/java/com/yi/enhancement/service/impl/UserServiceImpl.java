package com.yi.enhancement.service.impl;

import com.yi.enhancement.model.dto.UserDTO;
import com.yi.enhancement.model.entity.User;
import com.yi.enhancement.mapper.UserMapper;
import com.yi.enhancement.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public synchronized User updateViews(Integer userId) {
        UserDTO user = this.getUser(userId);
        Integer views = user.getViews();
        views = views + 1;
        user.setViews(views);
        this.baseMapper.updateById(user);
        return user;
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        this.saveOrUpdate(user);
        return true;
    }

    @Override
    public UserDTO getUser(Integer id) {
       return this.baseMapper.getUser(id);
    }
}

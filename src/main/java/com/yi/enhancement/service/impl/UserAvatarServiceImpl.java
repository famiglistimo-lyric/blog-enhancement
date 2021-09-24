package com.yi.enhancement.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yi.enhancement.exception.CustomException.CustomException;
import com.yi.enhancement.model.entity.UserAvatar;
import com.yi.enhancement.mapper.UserAvatarMapper;
import com.yi.enhancement.service.AvatarGenerate;
import com.yi.enhancement.service.IArticleTagRelationService;
import com.yi.enhancement.service.IUserAvatarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwj
 * @since 2021-08-25
 */
@Service
public class UserAvatarServiceImpl extends ServiceImpl<UserAvatarMapper, UserAvatar> implements IUserAvatarService {

    private final AvatarGenerate avatarGenerate;

    public UserAvatarServiceImpl(AvatarGenerate avatarGenerate) {
        this.avatarGenerate = avatarGenerate;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getByUserKey(String userKey) {
        UserAvatar userAvatar = this.getUserAvatar(userKey);
        if (userAvatar == null) {
            // 如果没有在数据库中保存,则随机生成,并保存到数据库
            return this.generateAvatarThenSave(userKey);
        }
        return userAvatar.getAvatar();
    }

    private String generateAvatarThenSave(String userKey) {
        String avatar = avatarGenerate.getAvatar();
        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setUserKey(userKey);
        userAvatar.setAvatar(avatar);
        userAvatar.setUpdateTime(DateUtil.date());
        this.baseMapper.insert(userAvatar);
        return userAvatar.getAvatar();
    }

    private UserAvatar getUserAvatar(String userKey) {
        QueryWrapper<UserAvatar> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_key", userKey);
        return this.baseMapper.selectOne(queryWrapper);
    }

}

package com.yi.enhancement.service;

import com.yi.enhancement.model.entity.UserAvatar;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-08-25
 */
public interface IUserAvatarService extends IService<UserAvatar> {

    /**
     * 根据userKey获得头像
     *
     * @param userKey userKey
     * @return 头像地址
     */
    String getByUserKey(String userKey);
}

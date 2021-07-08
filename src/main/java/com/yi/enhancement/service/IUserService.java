package com.yi.enhancement.service;

import com.yi.enhancement.model.dto.UserDTO;
import com.yi.enhancement.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表	 服务类
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
public interface IUserService extends IService<User> {

    /**
     * 更新主页浏览次数
     *
     * @param userId 用户id
     * @return 用户信息
     */
    User updateViews(Long userId);

    /**
     * 保存用户信息
     *
     * @param userDTO 用户DTO
     * @return 是否成功
     */
    boolean saveUser(UserDTO userDTO);

    /**
     * 查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    UserDTO getUser(Long id);
}

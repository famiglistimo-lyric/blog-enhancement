package com.yi.enhancement.mapper;

import com.yi.enhancement.model.dto.UserDTO;
import com.yi.enhancement.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lwj
 * @since 2021-06-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    UserDTO getUser(Long id);
}

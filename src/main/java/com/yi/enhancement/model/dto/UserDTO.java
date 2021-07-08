package com.yi.enhancement.model.dto;

import com.yi.enhancement.model.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: lyric
 * @date: 2021/7/8 12:50
 * @description: 用户信息DTO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends User {
    /**
     * 地理位置
     */
    private Geographic geographic;

    @Data
    public static class Geographic{
        private String province;
        private String city;
    }
}

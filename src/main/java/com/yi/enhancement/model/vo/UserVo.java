package com.yi.enhancement.model.vo;

/**
 * @author: lyric
 * @date: 2021/8/11 22:06
 * @description: 区分不同的用户类型
 */
public class UserVo {
    /**
     * 如果是登录用户,则设置userId
     */
    private Long userId;

    /**
     * 如果是游客，则设置userKey
     */
    private String userKey;

    private boolean tempUser = false;

    private String avatar;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public boolean isTempUser() {
        return tempUser;
    }

    public void setTempUser(boolean tempUser) {
        this.tempUser = tempUser;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

package com.yi.enhancement.exception;

/**
 * @author: lyric
 * @date: 2021/6/26 15:51
 * @description: 异常枚举
 */
public enum ExceptionCodeEnum {

    /**
     * 系统未知异常
     */
    UNKNOWN_EXCEPTION(10000,"系统未知异常"),

    /**
     * 博客不存在
     */
    BLOG_NOT_EXIST_EXCEPTION(10001,"博客不存在"),

    /**
     * 分类名已存在
     */
    CATEGORY_EXISTED_EXCEPTION(10002,"分类名已存在");

    private final int code;
    private final String message;

    ExceptionCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

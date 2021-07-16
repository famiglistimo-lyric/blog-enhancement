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
    UNKNOWN_EXCEPTION(9000,"系统未知异常"),

    /**
     * 数据重复
     */
    EXISTED_EXCEPTION(9001,"数据重复"),

    /**
     * 博客不存在
     */
    BLOG_NOT_EXIST_EXCEPTION(10000,"博客不存在"),

    /**
     * 分类名已存在
     */
    CATEGORY_EXISTED_EXCEPTION(10001,"分类名已存在"),

    /**
     * 标签名已存在
     */
    TAG_EXISTED_EXCEPTION(10002,"标签名已存在"),

    /**
     * 标题名已存在
     */
    TITLE_EXISTED_EXCEPTION(10003,"标题名已存在");

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

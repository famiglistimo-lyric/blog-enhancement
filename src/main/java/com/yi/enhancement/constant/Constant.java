package com.yi.enhancement.constant;

/**
 * @author: lyric
 * @date: 2021/6/26 16:17
 * @description: 全局常量
 */
public class Constant {

    public static int COMMENT_CONTENT_LENGTH_MAX = 255;
    public static int COMMENT_NICKNAME_LENGTH_MAX = 20;
    public static int COMMENT_WEBSITE_LENGTH_MAX = 255;

    public static String HANDLE_SUCCESS = "操作成功";
    public static String HANDLE_FAIL = "操作失败";
    public static String POLICY_FAIL = "获取签名失败";
    public static String NICKNAME_NOT_NULL = "昵称不可为空。";
    public static String EMAIL_ERROR = "邮箱格式不正确。";
    public static String CONTENT_NOT_NULL = "评论内容不可为空。";
    public static String CONTENT_LENGTH_TOO_LONG = "评论内容不可超过" + COMMENT_CONTENT_LENGTH_MAX + "个字符。";
    public static String NICKNAME_LENGTH_TOO_LONG = "昵称不可超过" + COMMENT_NICKNAME_LENGTH_MAX + "个字符。";
    public static String WEBSITE_LENGTH_TOO_LONG = "网址不可超过" + COMMENT_WEBSITE_LENGTH_MAX + "个字符。";
    public static String URL_ERROR = "不是正确的网址。";

}

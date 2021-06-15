package com.yi.enhancement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 和业务相关的类，就是说找不到首页的时候的跳转404页面
 * 1、@ResponseStatus(HttpStatus.NOT_FOUND):表示响应的状态码是404，就会返回到404页面
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IndexNotFoundException extends RuntimeException{

    public IndexNotFoundException() {
    }

    public IndexNotFoundException(String message) {
        super(message);
    }

    public IndexNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

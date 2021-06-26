package com.yi.enhancement.exception;

import com.yi.enhancement.model.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: lyric
 * @date: 2021/6/26 14:14
 * @description: 全局异常捕获类
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.yi.enhancement.controller")
public class ExceptionControllerAdvice {

    /**
     * 自定义异常
     */
    @ExceptionHandler(value = CustomException.class)
    public JsonResult handleArticleExistException(CustomException e) {
        log.error(e.getMessage());
        return null;
    }

    /**
     * 全局异常
     */
    @ExceptionHandler(value = Exception.class)
    public JsonResult handleException(Exception e) {
        log.error(e.getMessage());
        return null;
    }
}

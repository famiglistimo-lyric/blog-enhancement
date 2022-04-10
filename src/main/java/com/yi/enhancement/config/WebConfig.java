package com.yi.enhancement.config;

import com.yi.enhancement.interceptor.EnterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: lyric
 * @date: 2021/6/30 10:04
 * @description: 防止返回时Long类型精度丢失
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 把网加进去
        registry.addInterceptor(new EnterInterceptor())
                .addPathPatterns("/**");
    }
}

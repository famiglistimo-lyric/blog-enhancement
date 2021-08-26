package com.yi.enhancement.interceptor;

import com.yi.enhancement.constant.UserConstant;
import com.yi.enhancement.model.vo.UserVo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: lwj
 * @DateTime: 2021/3/28 1:44
 * @Description: 该拦截器是做的评论头像的功能
 */
public class EnterInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserVo> threadLocal = new ThreadLocal<>();

    /**
     * 目标方法执行之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        UserVo userVo = new UserVo();
        // todo
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals(UserConstant.TEMP_USER_COOKIE_NAME)) {
                    userVo.setUserKey(cookie.getValue());
                    userVo.setTempUser(true);
                    break;
                }
            }
        }
        //如果没有临时用户一定分配一个临时用户
        if(userVo.getUserKey() == null || userVo.getUserKey().isEmpty()){
            String uuid = UUID.randomUUID().toString();
            userVo.setUserKey(uuid);
        }
        threadLocal.set(userVo);
        return true;
    }

    /**
     * 业务执行之后；分配临时用户，让浏览器保存
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {
        UserVo userVo = threadLocal.get();

        // 如果用户没登录一定保存一个临时用户
        if (!userVo.isTempUser()) {
            // 持续的延长临时用户的过期时间
            Cookie cookie = new Cookie(UserConstant.TEMP_USER_COOKIE_NAME, userVo.getUserKey());
            cookie.setMaxAge(UserConstant.TEMP_USER_COOKIE_TIMEOUT);
            response.addCookie(cookie);
        }
    }
}

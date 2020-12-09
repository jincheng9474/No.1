package com.atguigu.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstHandlerInceptor implements HandlerInterceptor {
    /**
     * preHandle() 是在目标方法（Contrlller#xxx()业务方法）前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 前置操作。
        System.out.println(" First preHandle() ");
        // 返回false，阻止Controller#xxx() 执行 <br/>
        // 返回true，允许Controlller#xxx()执行<br/>?
        return true;
    }

    /**
     * 在Controller#xxx()方法之后执行
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(" First postHandle() ");
    }

    /**
     * 是在页面渲染完成之后（ 客户端浏览器显示的内容执行完之后 ）
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(" First afterCompletion() ");
    }
}

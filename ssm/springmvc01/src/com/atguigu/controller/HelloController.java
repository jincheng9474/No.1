package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    /**
     * @RequestMapping(value = "/hello") <br/>
     * @RequestMapping 注解是给当前业务方法配置一个唯一的访问地址。<br/>
     * value = "/hello" 表示访问的地址<br/>
     * / 斜杠表示 http://ip:port/工程路径/ 映射到代码的web目录<br/>
     * /hello 表示地址为： http://ip:port/工程路径/hello <br/>
     */
    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println(" SpringMVC hello()  ");
        /**
         * 返回值，就是跳转的地址（路径）<br/>
         * SpringMVC底层默认使用请求转发来进行页面跳转<br/>
         */
        return "ok";
    }

}

package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
    /**
     * @RequestMapping(value = "/fun1") 要求请求地址必须是： http://ip:port/工程路径/fun1,差一个字母都不允许访问
     */
    @RequestMapping(value = "/fun1")
    public String fun1() {
        System.out.println("fun1 ");
        return "ok";
    }

    /**
     * @RequestMapping(value = "/fun?") <br/>
     * ?问号，表示任意一个字符.
     */
    @RequestMapping(value = "/fun?")
    public String fun2() {
        System.out.println("fun2 ");
        return "ok";
    }

    /**
     * @RequestMapping(value = "/fun*") <br/>
     * *星，表示任意个字符.
     */
    @RequestMapping(value = "/fun*")
    public String fun3() {
        System.out.println("fun3 ");
        return "ok";
    }

    /**
     * @RequestMapping(value = "/?/fun") <br/>
     * 以上的问号，表示匹配一个字符的一层目录
     */
    @RequestMapping(value = "/?/fun")
    public String fun4() {
        System.out.println("fun4 ");
        return "ok";
    }

    /**
     * @RequestMapping(value = "/ * /fun") <br/>
     * 以上的星号，表示任意字符的一层目录
     */
    @RequestMapping(value = "/*/fun")
    public String fun5() {
        System.out.println("fun5 ");
        return "ok";
    }

    /**
     * @RequestMapping(value = "/ ** /fun") <br/>
     * 以上的星星号，表示匹配任意字符的任意层目录
     */
    @RequestMapping(value = "/**/fun")
    public String fun6() {
        System.out.println("fun6 ");
        return "ok";
    }

}

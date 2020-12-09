package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {
    /**
     * 在Controller方法中获取原生的api，做为参数
     */
    @RequestMapping(value = "/param1")
    public String param1(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        System.out.println(request.getContextPath());
        System.out.println(session.getId());
        System.out.println(response);
        return "ok";
    }

    /**
     * 如果客户端传递的参数是普通类型。只需要在Controller的方法中写上一样的参数名，即可<br/>
     * 比如客户端传递的参数是：username=zjc&password=123456 <br/>
     * 要求Controller的方法上的参数名要和客户端的参数名一致！！！<br/>
     */
    @RequestMapping(value = "/param2")
    public String param2(String username, String password) {

        System.out.println(username);
        System.out.println(password);

        return "ok";
    }

    /**
     * 如果如果的多个普通类型的值，只需要在Controller方法上，追加数组类型的参数即可<br/>
     * 要求：Controller方法上的参数名要和客户端发过来的参数名一致！！<br/>
     */
    @RequestMapping(value = "/param3")
    public String param3(String[] hobby) {

        System.out.println(hobby.length);
        Arrays.asList(hobby).forEach(System.out::println);

        return "ok";
    }

    /**
     * @return
     * @RequestParam(name = "user") String username 表示指客户端user参数的值，赋给方法参数username <br/>
     * name属性是客户端参数名<br/>
     * 如果name属性指定的参数不存在，就报400 Bad Request错误！！！<br/>
     * required = false 允许客户端参数不存在<br/>
     * defaultValue属性指定客户端如果没值，就使用默认值<br/>
     */
    @RequestMapping(value = "/param4")
    public String param4(
            @RequestParam(name = "user", required = false, defaultValue = "zjc")String username) {
        System.out.println(username);
        return "ok";
    }

    /**
     * @param userAgent
     * @return
     * @RequestHeader(name = "User-Agent") String userAgent 表示把请求头User-Agent的值，赋给方法参数userAgent
     */
    @RequestMapping(value = "/param5")
    public String param5(
            @RequestHeader(name = "User-Agent") String userAgent,
            @RequestHeader(name = "Host") String host) {
        System.out.println("User-Agent ——> " + userAgent);
        System.out.println("host ——> " + host);
        return "ok";
    }

    /**
     * @param jsessionId
     * @return
     * @CookieValue(name = "JSESSIONID") String jsessionId 表示取JSESSIONID的Cookie，的值赋给方法参数 jsessionId
     */
    @RequestMapping(value = "/param6")
    public String param6(
            @CookieValue(name = "JSESSIONID") String jsessionId) {
        System.out.println("JSESSIONID ——> " + jsessionId);
        return "ok";
    }

    /**
     * 如果参数是一个对象类型。要求客户端的参数名要和javaBean的属性名一致！！！<br/>
     */
    @RequestMapping(value = "/param7")
    public String param7(Person person) {
        System.out.println("person ——> " + person);

        return "ok";
    }

}

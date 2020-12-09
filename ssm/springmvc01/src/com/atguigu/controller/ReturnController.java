package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RequestMapping(value = "/zjc")
@Controller
public class ReturnController {

    @RequestMapping(value = "/return1")
    public String return1() {
        System.out.println("return1 方法");
        /**
         * 1.如果没有视图解析器的时候，返回值要写上完整的跳转路径 <br/>
         * 2.如果有视图解析器，则只能写跳转路径的文件名（视图名）即可！！！<br/>
         * 因为返回的视图名，还要和视图解析器中的前后做字符串拼接操作，形成完整的跳转路径之后再进行页面的跳转<br/>
         * 3.不管有没有视图解析器，默认情况下，SpringMVC底层默认使用的是请求转发来进行页面的跳转<br/>
         */
        return "ok";
    }


    @RequestMapping(value = "/return2")
    public String return2() {
        System.out.println("return2 方法");
        /**
         * 如何显示的告诉SpringMVC返回的路径使用请求转发来进行跳转<br/>
         * 1 在返回值前面 使用前缀 forward: 表示返回的路径就是使用请求转发<br/>
         * 2 在使用显示的请求转发的时候，返回的路径不会和视图解析器一起工作<br/>
         * 3 显示的请求转发，后面只能写上完整的跳转路径<br/>
         * 4 显示的请求转发后面的地址还分为相对路径和绝对路径两种<br/>
         * 5 以斜杠打头的地址是绝对路径，不以斜杠打头的地址是相对路径<br/>
         * 6 绝对路径效果如下：<br/>
         * 路径中的首字母斜杠表示地址为:http://ip:port/工程路径/ 映射到代码的web目录<br/>
         * /pages/ok.jsp 表示地址为：http://ip:port/工程路径/pages/ok.jsp 也就是映射到代码的web/pages/ok.jsp <br/>
         * 7 相对路径效果如下(禁止使用)：<br/>
         * 相对路径地址是：pages/ok.jsp , 相对路径在工作的时候会参照当前请求的地址。<br/>
         * 如果当前请求地址是：http://localhost:8080/springmvc01/return2 <br/>
         * 最终得到的路径是： http://localhost:8080/springmvc01/pages/ok.jsp <br/>
         * 如果当前请求地址是：http://localhost:8080/springmvc01/abc/return2 <br/>
         * 最终得到的路径是： http://localhost:8080/springmvc01/abc/pages/ok.jsp <br/>
         */
        return "forward:/pages/ok.jsp";
    }

    @RequestMapping(value = "/return3")
    public String return3() {
        System.out.println("return3");
        /**
         * 如何显示的告诉SpringMVC返回的路径使用 请求重定向 来进行跳转<br/>
         * 1 在返回值前面 使用前缀 redirect: 表示返回的路径就是使用 请求重定向<br/>
         * 2 在使用显示的 请求重定向 的时候，返回的路径不会和视图解析器一起工作<br>
         * 3 显示的请求重定向，后面只能写上完整的跳转路径<br/>
         * 4 显示的 请求重定向 后面的地址还分为相对路径和绝对路径两种<br/>
         * 5 以斜杠打头的地址是绝对路径，不以斜杠打头的地址是相对路径<br/>
         * 6 绝对路径效果如下：<br/>
         * 路径中的首字母斜杠表示地址为 : http://ip:port/工程路径/ 映射 到代码的web目录<br/>
         * /pages/ok.jsp 表示地址为：http://ip:port/工程路径/pages/ok.jsp 也就是映射到代码的web/pages/ok.jsp <br/>
         * 7 相对路径效果如下(禁止使用)：<br/>
         * 相对路径地址是：pages/ok.jsp , 相对路径在工作的时候会参照当前请求的地址。<br/>
         * 如果当前请求地址是：http://localhost:8080/springmvc01/abc/return3 <br/>
         * 最终得到的路径是： http://localhost:8080/springmvc01/abc/pages/ok.jsp <br/>
         *
         * 如果当前请求地址是：http://localhost:8080/springmvc01/return3 <br/>
         * 最终得到的路径是： http://localhost:8080/springmvc01/pages/ok.jsp <br/>
         */
        return "redirect:/pages/ok.jsp";
    }

    @RequestMapping(value = "/return4")
    public ModelAndView return4() {

        System.out.println("return4");

        // 创建ModelAndView对象用于返回值
        ModelAndView modelAndView = new ModelAndView("ok");

        /**
         * 最后的跳转需要一个跳转的路径 <br/>
         * 如果有视图解析器，只需要设置视图名即可<br/>
         * 如果没有视图解析器，需要写上完整的跳转路径<br/>
         * SpringMVC底层默认使用请求转发<br/>
         */
//        modelAndView.setViewName("ok");
        // 完整的跳转路径
//        modelAndView.setViewName("/pages/ok.jsp");

        return modelAndView;
    }

    @RequestMapping(value = "/return5")
    public ModelAndView return5() {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("return5");
        /**
         * 在ModelAndView中显示的请求转发或显示的重定向，跟返回String类型的显示请求转发和显示重定向规则一样<br/>
         *
         * 显示的请求转发: modelAndView.setViewName("forward:/pages/ok.jsp");
         */
//        modelAndView.setViewName("forward:/pages/ok.jsp");
        /**
         * 显示重定向： modelAndView.setViewName("redirect:/pages/ok.jsp");
         */
        modelAndView.setViewName("redirect:/pages/ok.jsp");
        return modelAndView;
    }


}

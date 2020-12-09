package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 有了模块路径之后，每个方法的请求地址前面必须添加模块路径才允许访问<br/>
 */
@RequestMapping(value = "/mapping")
@Controller
public class RequestMappingController {
    /**
     * params="username"			表示	请求地址必须带有username参数 <br/>
     * params = "username=zjc"   表示	请求参数中必须要有username，而且值还必须是zjc <br/>
     * params = "username!=zjc"  表示	1、请求参数中不能有username参数。2、有username参数，但值不能等于zjc <br/>
     * params = "!username"         表示	请求地址不能带有username参数 <br/>
     * params = {"username","password=666666"} 表示必须要有username参数，而且还要有password参数。且password参数值必须是666666 <br/>
     *
     * @return
     */
    @RequestMapping(value = "/params", params = {"!username"})
    public String params() {
        System.out.println(" params 属性 ");

        return "ok";
    }

    /**
     * headers属性是要求匹配请求头信息，使用规则跟params一样<br/>
     *
     * @return
     */
    @RequestMapping(value = "/headers", headers = "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Safari/537.36")
    public String headers() {
        System.out.println(" headers 属性 ");
        return "ok";
    }

    /**
     * method = RequestMethod.GET 表示只允许GET请求访问 <br/>
     * method = RequestMethod.POST 表示只允许 POST 请求访问 <br/>
     *
     * @return
     */
    @RequestMapping(value = "/method", method = RequestMethod.POST)
    public String method() {
        System.out.println(" method 属性 ");
        return "ok";
    }


}

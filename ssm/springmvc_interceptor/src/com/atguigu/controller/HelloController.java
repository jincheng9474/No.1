package com.atguigu.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(Map<String,Object> map){
        map.put("key1", "国哥好帅");
        map.put("key2", "蒙蒙好美");
        System.out.println(" Controller#hello() 目标方法 ");
        return "ok";
    }

}

package com.zjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : ZJC
 * @Date : 2020/11/9 10:12
 * className : RsetController
 * package: com.zjc.controller
 * version : 1.0
 * Description
 */
@Controller
public class RestController {
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String queryBookById(@PathVariable("id") Integer id) {
        System.out.println("查询id为" + id + "的图书信息");
        return "forward:/index.jsp";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String queryBooks() {
        System.out.println("查询全部的图书信息");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook() {
        System.out.println("添加图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/book/1", method = RequestMethod.PUT)
    public String updateBook() {
        System.out.println("修改图书");
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/book/1", method = RequestMethod.DELETE)
    public String deleteBook() {
        System.out.println("删除图书");
        return "redirect:/index.jsp";
    }
}

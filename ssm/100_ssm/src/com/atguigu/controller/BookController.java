package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;


@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book/add")
    public String add(){
        bookService.saveBook(new Book(null,"和国哥一起甜蜜蜜的日子","蒙蒙",
                new BigDecimal("999"), 9999,666));
        return "ok";
    }

}

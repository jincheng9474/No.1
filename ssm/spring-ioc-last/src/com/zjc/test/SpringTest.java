package com.zjc.test;

import com.zjc.pojo.Book;
import com.zjc.pojo.User;
import com.zjc.service.BookService;
import com.zjc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // UserService里的baseDao，会注入什么值
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.saveEntity(new User());
        System.out.println("——————————————————————————————————————————————————————————");
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.saveEntity(new Book());
    }

}

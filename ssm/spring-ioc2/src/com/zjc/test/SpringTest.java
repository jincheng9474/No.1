package com.zjc.test;


import com.zjc.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService);
        System.out.println(applicationContext.getBean("bookDao"));
        System.out.println(applicationContext.getBean("bookController"));
        System.out.println(applicationContext.getBean("book"));

    }
}

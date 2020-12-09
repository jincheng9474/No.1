package com.atguigu.service.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void saveBook() {
        bookService.saveBook(new Book(null,"和蒙蒙的每一天","国哥",
                new BigDecimal("1234"), 123,2345));
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void queryBookById() {
    }

    @Test
    public void queryBooks() {
    }
}
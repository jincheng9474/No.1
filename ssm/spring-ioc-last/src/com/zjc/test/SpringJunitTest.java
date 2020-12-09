package com.zjc.test;

import com.zjc.pojo.Book;
import com.zjc.pojo.User;
import com.zjc.service.BookService;
import com.zjc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ContextConfiguration指定在Junit测试中创建Spring容器需要的配置文件
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
/**
 *@RunWith(SpringJUnit4ClassRunner.class) 表示使用Spring对Junit扩展之后的类来进行跑测试（这里有Spring容器对象，可以使用Spring的注解）
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJunitTest {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @Test
    public void test1() {
        // UserService里的baseDao，会注入什么值
        userService.saveEntity(new User());
        System.out.println("————————————————————————————————————————————————————");
        bookService.saveEntity(new Book());
    }

}

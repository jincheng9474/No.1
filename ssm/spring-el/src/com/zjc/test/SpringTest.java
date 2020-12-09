package com.zjc.test;

import com.zjc.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author : ZJC
 * @Date : 2020/11/2 11:30
 * className : SpringTest
 * package: com.zjc.test
 * version : 1.0
 * Description
 */
public class SpringTest {
    @Test
    public void test() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p26 = (Person) applicationContext.getBean("p26");
        System.out.println(p26);
    }
}

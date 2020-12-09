package com.zjc.test;



import org.junit.Test;
import com.zjc.pojo.Calculate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    Calculate calculate;

    @Test
    public void test() {
        calculate.add(100, 100);
        System.out.println("————————————————————————————————————————————————");
        calculate.div(100, 10);
        System.out.println("————————————————————————————————————————————————");
        calculate.add(1, 2, 3);
    }

}

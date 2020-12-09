package com.zjc.test;

import com.zjc.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author : ZJC
 * @Date : 2020/11/4 10:54
 * className : SpringTest
 * package: com.zjc.test
 * version : 1.0
 * Description
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    @Autowired
    TransactionService transactionService;

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(jdbcTemplate);
    }

    @Test
    public void multiUpdate(){
        transactionService.multiUpdate();
    }
}

package com.zjc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author : ZJC
 * @Date : 2020/11/4 10:25
 * className : BookDao
 * package: com.zjc.dao
 * version : 1.0
 * Description
 */
@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateBook() {
        jdbcTemplate.update("update book set `name` = ?","图书表被修改了");
    }
}

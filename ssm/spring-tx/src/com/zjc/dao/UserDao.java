package com.zjc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author : ZJC
 * @Date : 2020/11/4 10:27
 * className : UserDao
 * package: com.zjc.dao
 * version : 1.0
 * Description
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateUser() {
        jdbcTemplate.update("update user set `username` = ?","用户表被修改了");
    }
}

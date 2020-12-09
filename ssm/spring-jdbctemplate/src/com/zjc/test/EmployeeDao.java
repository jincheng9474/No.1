package com.zjc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends JdbcDaoSupport {

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate2(JdbcTemplate jdbcTemplate){
        setJdbcTemplate(jdbcTemplate);
    }

    public Employee queryEmployeeById(Integer id){
        String sql = "select `id`,`name`,`salary` from employee where id = ?";
        return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), id);
    }

}

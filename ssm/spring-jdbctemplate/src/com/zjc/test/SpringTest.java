package com.zjc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(jdbcTemplate);
    }

    //    实验2：将id=5的记录的salary字段更新为1300.00
    @Test
    public void test2() {
        String sql = "update employee set salary = ? where id = ?";
        /**
         * udpate()方法用于执行insert,delete,update的sql语句<br/>
         *  第一个参数是sql语句<br/>
         *  第二个参数是sql中占位符的参数值<br/>
         * 返回值是影响的行数
         */
        System.out.println(jdbcTemplate.update(sql, new BigDecimal("1300"), 5));

    }

    //    实验3：批量插入
    @Test
    public void test3() {
        String sql = "insert into employee(`name`,`salary`) values(?,?)";
        // 插入一条记录
//        System.out.println(jdbcTemplate.update(sql, "天天爱国哥", new BigDecimal("100000")));

        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"aaaa", new BigDecimal(10000)});
        batchArgs.add(new Object[]{"bbbb", new BigDecimal(20000)});
        batchArgs.add(new Object[]{"cccc", new BigDecimal(30000)});

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    //    实验4：查询id=5的数据库记录，封装为一个Java对象返回
    @Test
    public void test4() {
        String sql = "select `id`,`name`,`salary` from employee where id = ?";
        /**
         * queryForObject()当查询回来的结果只有一行的时候，使用queryForObject();
         * 第一个参数是sql语句<br/>
         * 第二个参数是：RowMapper接口实现类，这个接口的实现类需要将查询回来的每一行记录转换为JavaBean对象 <br/>
         * 第三个参数是，sql语句占位符的参数值<br/>
         */
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5);

        System.out.println(employee);
    }

    //    实验5：查询salary>4000的数据库记录，封装为List集合返回
    @Test
    public void test5() {
        String sql = "select `id`,`name`,`salary` from employee where salary > ?";
        /**
         * JdbcTemplate工具类跟之前学习的DBUtils包中的QueryRunner相似<br/>
         * JdbcTemplate中
         *  update()用来执行inert,delete,update的sql语句<br/>
         *  queryForObject()查询一行数据<br/>
         *  query()查询多行数据<br/>
         *
         * QueryRunner中
         *  query()用来执行查询
         *         ResultSetHandler接口实现类决定查询回来的结果<br/>
         *              BeanHandler()查询一个对象<br/>
         *              BeanListHandler()查询多个对象<br/>
         *              ScalarHandler()查询一行一列的数据
         *  update()用来执行inert,delete,update的sql语句<br/>
         */
        /**
         * 当查询回来是多个JavaBean的时候，使用query()方法<br/>
         * 第一个参数是sql语句<br/>
         * 第二个参数是：RowMapper接口实现类，这个接口的实现类需要将查询回来的每一行记录转换为JavaBean对象 <br/>
         * 第三个参数是，sql语句占位符的参数值<br/>
         */
        List<Employee> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), new BigDecimal("1400"));
        query.forEach(System.out::println);
    }

    //    实验6：查询最大salary
    @Test
    public void test6() {
        String sql = "select max(salary) from employee";
        /**
         * 第一个参数是sql语句，第二个参数是返回的数据类型
         */
        BigDecimal maxSalary = jdbcTemplate.queryForObject(sql, BigDecimal.class);

        System.out.println(maxSalary);
    }

    //    实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
    @Test
    public void test7() {
        /**
         * :name它是具名参数（命名参数）,它的语法格式是 ==>> :参数名 <br/>
         * :xxx 同时也是占位符 <br/>
         */
        String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";

        Map<String, Object> paramMap = new HashMap<>();
        /**
         * map的key要和参数名一致
         */
        paramMap.put("name", "0821，我爱你");
        paramMap.put("salary", new BigDecimal(10000));

        namedParameterJdbcTemplate.update(sql, paramMap);

    }

    //    实验8：重复实验7，以SqlParameterSource形式传入参数值
    @Test
    public void test8() {
        /**
         * :name它是具名参数（命名参数）,它的语法格式是 ==>> :参数名 <br/>
         * :xxx 同时也是占位符 <br/>
         */
        String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";

        Employee employee = new Employee(null, "国哥，我爱你，爱你，爱你", new BigDecimal(666666));

        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));

    }

    //    实验9：创建Dao，自动装配 JdbcTemplate 对象
    @Test
    public void test9() {
        System.out.println(employeeDao.queryEmployeeById(1));
    }

    //    实验10：通过继承JdbcDaoSupport创建JdbcTemplate的Dao
    @Test
    public void test10() {
        System.out.println(employeeDao.queryEmployeeById(1));
    }
}

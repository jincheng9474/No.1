package com.zjc.mapper.test;

import com.zjc.mapper.UserMapper;
import com.zjc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @Author : ZJC
 * @Date : 2020/10/27 14:14
 * className : UserMapperTest
 * package: com.zjc.mapper.test
 * version : 1.0
 * Description
 */
public class UserMapperTest {
    public static final java.util.function.BiConsumer<Integer, User> INTEGER_USER_BI_CONSUMER = (k, v) -> {
        System.out.println(k);
        System.out.println(v);
        System.out.println("——————————————————————————————————————————————————");
    };
    SqlSessionFactory sqlSessionFactory;

    /**
     * @Author ZJC
     * @Date 14:17 2020/10/27
     * @return void
     * 会在每个测试方法之前执行
     */
    @Before
    public void init() throws IOException {
        System.out.println("init方法已初始化");

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    @Test
    public void queryUserById() {
        System.out.println("测试方法");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.queryUserById(1);
            System.out.println(user);
        } finally {
            session.close();
        }
    }

    @Test
    public void queryUsers() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            for (User user : mapper.queryUsers()) {
                System.out.println(user);
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void insertUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Integer insertUser = mapper.insertUser(new User(null, "zzz", 1));
            System.out.println(insertUser);

            session.commit();//提交事务
        } finally {
            session.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            int updateUser = mapper .updateUser(new User(1, "zjc", 1));
            System.out.println(updateUser);

            session.commit();//提交事务
        } finally {
            session.close();
        }
    }

    @Test
    public void deleteUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            int userById = mapper.deleteUserById(2);
            System.out.println(userById);

            session.commit();//提交事务
        } finally {
            session.close();
        }
    }

    @Test
    public void queryUsersForMap() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.queryUsersForMap().forEach((k,v) -> {
                System.out.println(k);
                System.out.println(v);
                System.out.println("——————————————————————————————————————————————————————————————");
            });
        } finally {
            session.close();
        }
    }
}
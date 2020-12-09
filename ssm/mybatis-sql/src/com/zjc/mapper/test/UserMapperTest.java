package com.zjc.mapper.test;

import com.zjc.mapper.UserMapper;
import com.zjc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryUsersBySample() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = session.getMapper(UserMapper.class);

            mapper.queryUsersBySample(new User(null,"16",10)).forEach(System.out::println);

        } finally {
            session.close();
        }
    }
    @Test
    public void queryUsersBySampleChoose() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = session.getMapper(UserMapper.class);

            mapper.queryUsersBySampleChoose(new User(null,null,10)).forEach(System.out::println);

        } finally {
            session.close();
        }
    }


        @Test
    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = session.getMapper(UserMapper.class);

            mapper.updateUser(new User(6,null,0 ));

            session.commit();
        } finally {
            session.close();
        }
    }




        @Test
    public void queryUsersByIds() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = session.getMapper(UserMapper.class);

            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            ids.add(4);

            mapper.queryUsersByIds(ids).forEach(System.out::println);

        } finally {
            session.close();
        }
    }




        @Test
    public void insertUsers() {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            UserMapper mapper = session.getMapper(UserMapper.class);

            List<User> users = new ArrayList<>();

            users.add(new User(null,"aaa",1));
            users.add(new User(null,"bbb",1));
            users.add(new User(null,"ccc",1));
            users.add(new User(null,"ddd",1));

            mapper.insertUsers(users);


            session.commit();
        } finally {
            session.close();
        }
    }












}
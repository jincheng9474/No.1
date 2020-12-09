package com.zjc.mapper.test;

import com.zjc.mapper.ClazzMapper;
import com.zjc.pojo.Clazz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClazzMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryClazzByIdForSimple() {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            ClazzMapper clazzMapper = session.getMapper(ClazzMapper.class);

            Clazz clazz = clazzMapper.queryClazzByIdForSimple(1);

            System.out.println(clazz);
        } finally {
            session.close();
        }
    }
}
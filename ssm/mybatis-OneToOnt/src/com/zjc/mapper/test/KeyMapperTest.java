package com.zjc.mapper.test;

import com.zjc.mapper.KeyMapper;
import com.zjc.pojo.Key;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author : ZJC
 * @Date : 2020/10/28 18:53
 * className : KeyMapperTest
 * package: com.zjc.mapper.test
 * version : 1.0
 * Description
 */
public class KeyMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryKeyById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            KeyMapper mapper = session.getMapper(KeyMapper.class);

            Key key = mapper.queryKeyById(1);

            System.out.println(key.getId());
            System.out.println(key.getName());

        } finally {
            session.close();
        }
    }

    @Test
    public void queryKeyByIdForTwoStep() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            KeyMapper mapper = session.getMapper(KeyMapper.class);

            Key key = mapper.queryKeyByIdForTwoStep(1);

            System.out.println(key.getId());
            System.out.println(key.getName());

            System.out.println(key.getLock());

        } finally {
            session.close();
        }
    }
}
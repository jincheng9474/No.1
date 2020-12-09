package com.zjc.hello;

import com.zjc.mapper.UserMapper;
import com.zjc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mybatis {
    /**
     * @Author ZJC
     * @Date 11:03 2020/10/27
     * @return
     * 通过查询mybatis数据库中的t_user表中的记录，得到一个User对象
     */
    @Test
    public void test1() throws IOException {
        //读取mybatis-config.xml配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //SqlSession相当于前面的Connection对象（Connection对象要求，每次使用完要马上关闭）
        SqlSession session = sqlSessionFactory.openSession();
        try {
        //通过Session获取UserMapper接口的实现类
        UserMapper mapper = session.getMapper(UserMapper.class);
        //执行查询
        User user = mapper.queryUserById(1);
        System.out.println(user);
        } finally {
            session.close();
        }
    }
}

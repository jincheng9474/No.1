package com.zjc.dao;

import com.zjc.pojo.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User>{
    @Override
    public void saveEntity(User entity) {
        System.out.println(" UserDao 保存 " + entity);
    }
}

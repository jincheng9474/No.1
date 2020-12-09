package com.zjc.mapper;

import com.zjc.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户的lastName属性并且sex属性值来做查询用户信息<br/>
     *  如果lastName属性值非空，就进入查询条件 <br/>
     *  如果sex值有效（0和1），也进入查询条件
     */
    public List<User> queryUsersBySample(User user);

    /**
     * 如果用户名lastName属性值有效，则只使用lastName属性查询用户<br/>
     * 如果用户名lastName无效，而sex有效，而使用sex属性查询用户<br/>
     * 如果lastName属性和sex属性都无效，则可以使用自定义条件查询
     */
    public List<User> queryUsersBySampleChoose(User user);

    /**
     * 更新用户 <br/>
     * 如果lastName属性值为null，则不更新last_name属性列，
     * 如果sex属性值非法，则不更新sex属性列。
     */
    public int updateUser(User user);



//    1 遍历查询条件，比如： select * from 表名 where id in( xx , xxx , xxx)
    public List<User> queryUsersByIds(List<Integer> ids);

//    2 遍历批量插入，比如：insert into 表名（列1，列2，列3...） values(值1，值2，值3)，(值1，值2，值3)，(值1，值2，值3)
    public int insertUsers(List<User> users);
}

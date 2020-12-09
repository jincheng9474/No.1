package com.zjc.mapper;

import com.zjc.pojo.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @Author : ZJC
 * @date : 2020/10/27 10:40
 * className : UserMapper
 * package: com.zjc.mapper
 * version : 1.0
 * Description
 */
public interface UserMapper {
    /**
     * @Author ZJC
     * @Date 10:41 2020/10/27
     * @return
     * 根据id查询user对象
     */
    public User queryUserById(Integer id);

    /**
     * @Author ZJC
     * @Date 14:01 2020/10/27
     * @return
     * 查询全部用户
     */
    public List<User> queryUsers();

    @MapKey("id")
    //查询全部用户
    public Map<Integer,User> queryUsersForMap();

    /**
     * @Author ZJC
     * @Date 14:02 2020/10/27
     *@return
     * 添加用户
     */
    public int insertUser(User user);

    /**
     * @Author ZJC
     * @Date 14:03 2020/10/27
     * @return a
     * 更新用户
     */
    public int updateUser(User user);

    /**
     * @Author ZJC
     * @Date 14:04 2020/10/27
     * @return
     * 删除用户
     */
    public int deleteUserById(Integer id);
}

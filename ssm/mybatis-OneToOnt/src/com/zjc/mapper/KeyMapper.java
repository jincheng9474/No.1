package com.zjc.mapper;
import com.zjc.pojo.Key;
public interface KeyMapper {
    /**
     * 根据给定的id，查询出相应的Key信息，以及Lock锁的信息
     * @param id
     * @return
     */
    public Key queryKeyById(Integer id);

    /**
     * 要两次查询，一次查Key（常用列表）,一次查Lock锁（不常用表）
     * @param id
     * @return
     */
    public Key queryKeyByIdForTwoStep(Integer id);

}

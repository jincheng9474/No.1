package com.zjc.mapper;
import com.zjc.pojo.Lock;
public interface LockMapper {
    /**
     * 只是根据lock编号查询lock信息（不常用列）
     */
    public Lock queryLockById(Integer id);

}

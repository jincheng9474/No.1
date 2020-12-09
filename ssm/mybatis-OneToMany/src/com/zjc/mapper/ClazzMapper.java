package com.zjc.mapper;

import com.zjc.pojo.Clazz;

public interface ClazzMapper {
    /**
     * 一次性把班级，和班级所有学生信息，都查询出来<br/>
     */
    public Clazz queryClazzByIdForSimple(Integer id);

}

package com.zjc.dao;

public abstract class BaseDao<T> {

    public abstract void saveEntity(T entity);

}

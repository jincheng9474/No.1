package com.zjc.dao;

import com.zjc.pojo.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void saveEntity(Book entity) {
        System.out.println("BookDao 保存 " + entity);
    }
}

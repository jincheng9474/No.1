package com.zjc.service;

import com.zjc.dao.BookDao;
import com.zjc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : ZJC
 * @Date : 2020/11/4 10:31
 * className : TransactionService
 * package: com.zjc.service
 * version : 1.0
 * Description
 */
@Service
public class TransactionService {

    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;

    /**
     * @Transactional注解表示打那个前方法有事务
     */
    @Transactional
    public void multiUpdate() {
        bookDao.updateBook();
        int i = 12 / 1;
        userDao.updateUser();
    }
}

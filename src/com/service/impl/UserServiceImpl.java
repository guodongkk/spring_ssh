package com.service.impl;/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: UserServiceImpl
 */

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


    @Transactional
    @Override
    public void add(User user) {

        userDao.add(user);

    }
}

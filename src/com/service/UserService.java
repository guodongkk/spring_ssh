package com.service;/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: UserService
 */

import com.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public void add(User user);

}

package com.controller;/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: UserController
 */


import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

@RequestMapping("addUser")
public User addUser(User user){
    userService.add(user);
    return user;
}

@RequestMapping("findAll")
public List<User> findAll(){
  return userService.findAll();
}


}

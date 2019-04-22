package com.controller;/*
 * @author :张
 * Date  : 2019/4/22
 * @Description: UserController
 */


import com.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@RequestMapping
@RestController
public class TestController {

    @RequestMapping("/hello")
   @ResponseBody
    public User hello(){
     User user=new User("zhangsan","zhangsan123");
     return user;
    }

    @RequestMapping("/hehe")
    public User hehe(){

        return new User("zhangsan","hehe123");
    }
}

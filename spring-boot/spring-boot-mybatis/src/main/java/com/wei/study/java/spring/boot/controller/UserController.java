package com.wei.study.java.spring.boot.controller;

import com.wei.study.java.spring.boot.model.User;
import com.wei.study.java.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public Object getUser() {
        User user = userService.getUser();
        return user;
    }

    @RequestMapping("getUsers")
    public Object getUsers() {
        List<User> users = userService.getUsers();
        return users;
    }
}

package com.wei.study.java.spring.boot.service;

import com.github.pagehelper.PageHelper;
import com.wei.study.java.spring.boot.mapper.UserMapper;
import com.wei.study.java.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    public List<User> getUsers() {
        User user = new User();
        user.setId(0);
        PageHelper.startPage(0,1);
        return userMapper.selectAll();
    }


}

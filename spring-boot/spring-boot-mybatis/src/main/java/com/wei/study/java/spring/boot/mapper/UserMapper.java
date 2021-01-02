package com.wei.study.java.spring.boot.mapper;

import com.wei.study.java.spring.boot.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> selectUser();
}

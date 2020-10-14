package com.wei.study.java.dubbo;

import java.lang.management.ManagementFactory;

import com.wei.study.java.dubbo.user.model.User;
import com.wei.study.java.dubbo.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(Integer id) {
		User user = new User();
		user.setId(id);
		user.setAge(10);
		user.setName("zhangsan:" + ManagementFactory.getRuntimeMXBean().getName());
		return user;
	}

}

package com.wei.study.java.dubbo.boot.service;

import java.lang.management.ManagementFactory;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import com.wei.study.java.dubbo.user.model.User;
import com.wei.study.java.dubbo.user.service.UserService;

/**
 *
 * @author WEI
 * @Time: 2020-10-14 14:12:10
 *
 */
@DubboService
@Service
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

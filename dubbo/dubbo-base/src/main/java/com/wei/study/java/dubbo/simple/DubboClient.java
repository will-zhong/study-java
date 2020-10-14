package com.wei.study.java.dubbo.simple;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;

import com.wei.study.java.dubbo.user.service.UserService;

/**
 * 
 *
 * @author WEI
 * @Time: 2020-10-12 16:34:26
 *
 */
public class DubboClient {

	public static void main(String[] args) {

		// application
		ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-client");

		// 设置引用reference
		ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
		referenceConfig.setInterface(UserService.class);
		referenceConfig.setUrl("dubbo://192.168.3.2:20880/com.wei.study.java.dubbo.user.service.UserService");
		referenceConfig.setApplication(applicationConfig);
		
		referenceConfig.setTimeout(60000);

		UserService userService = referenceConfig.get();

		System.out.println(userService.getUser(1));

	}
}

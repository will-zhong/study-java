package com.wei.study.java.dubbo.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import com.wei.study.java.dubbo.user.service.UserService;

/**
 * 
 *
 * @author WEI
 * @Time: 2020-10-12 16:34:26
 *
 */
public class DubboClient {

	public static void main(String[] args) throws IOException {

		// application
		ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-client");

		// 注册中心
		RegistryConfig registryConfig = new RegistryConfig("multicast://224.5.6.7:1234");

		// 设置引用reference
		ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<>();
		referenceConfig.setInterface(UserService.class);
		referenceConfig.setRegistry(registryConfig);
		referenceConfig.setApplication(applicationConfig);
//		referenceConfig.setUrl("dubbo://192.168.3.2:20880/com.wei.study.java.dubbo.user.service.UserService");

		UserService userService = referenceConfig.get();

		System.out.println(userService.getUser(1));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			if (br.readLine().equals("q")) {
				break;
			}
			System.out.println(userService.getUser(1));
		}

	}
}

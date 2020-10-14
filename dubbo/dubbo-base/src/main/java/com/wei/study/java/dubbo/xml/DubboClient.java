package com.wei.study.java.dubbo.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wei.study.java.dubbo.user.service.UserService;

/**
 *
 * @author WEI
 * @Time: 2020-10-13 17:24:48
 *
 */
public class DubboClient {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
		UserService userService = applicationContext.getBean(UserService.class);

		System.out.println(userService.getUser(1));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			if (br.readLine().equals("q")) {
				break;
			}
			System.out.println(userService.getUser(1));
		}

		applicationContext.close();
	}
}

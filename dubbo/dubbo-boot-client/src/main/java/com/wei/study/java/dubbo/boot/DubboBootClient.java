package com.wei.study.java.dubbo.boot;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wei.study.java.dubbo.user.service.UserService;

/**
 *
 * @author WEI
 * @Time: 2020-10-14 14:41:06
 *
 */
@EnableDubbo
@SpringBootApplication
public class DubboBootClient {

	@DubboReference
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DubboBootClient.class, args).close();
	}
	
	@Bean
	public ApplicationRunner getBean() {
		return args->{
			System.out.println(userService.getUser(1));
		};
	}
}

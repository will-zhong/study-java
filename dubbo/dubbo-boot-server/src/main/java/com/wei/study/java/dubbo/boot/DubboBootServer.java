package com.wei.study.java.dubbo.boot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author WEI
 * @Time: 2020-10-14 13:58:30
 *
 */
@EnableDubbo
@SpringBootApplication
public class DubboBootServer {

	public static void main(String[] args) {
		SpringApplication.run(DubboBootServer.class, args);
	}
}

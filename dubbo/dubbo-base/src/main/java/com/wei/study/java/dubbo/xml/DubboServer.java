package com.wei.study.java.dubbo.xml;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author WEI
 * @Time: 2020-10-13 17:19:15
 *
 */
public class DubboServer {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");
		System.out.println("服务已暴露");
		System.in.read();
		applicationContext.close();
	}
}

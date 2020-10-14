package com.wei.study.java.dubbo.simple;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.wei.study.java.dubbo.UserServiceImpl;
import com.wei.study.java.dubbo.user.service.UserService;

public class DubboServer {

	public static void main(String[] args) throws IOException {
		// 暴露 服务
		// application
		ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-server");

		// protocol -dubbo 协议
		ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
		protocolConfig.setPort(-1); // 默认20880

		// 注册中心 （简单）
		RegistryConfig registryConfig = new RegistryConfig(RegistryConfig.NO_AVAILABLE);

		// service
		ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
		serviceConfig.setInterface(UserService.class); // 必须的
		serviceConfig.setRef(new UserServiceImpl());

		serviceConfig.setApplication(applicationConfig);
		serviceConfig.setProtocol(protocolConfig);
		serviceConfig.setRegistry(registryConfig);

		serviceConfig.export();

		System.out.println("服务器已暴露");

		System.in.read();
	}
}

package com.wei.study.java.dubbo.multicast;

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
		applicationConfig.setQosEnable(false);

		// protocol -dubbo 协议
		ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
		protocolConfig.setPort(-1); // 默认20880

		// 注册中心 （multicast 主网广播协议）
		RegistryConfig registryConfig = new RegistryConfig("multicast://224.0.0.1:3333");

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

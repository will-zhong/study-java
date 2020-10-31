package com.wei.study.java.designpattern.singleton.hungry;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:28:11
 *
 */
public class HungrySingleton {

	// 利用JVM 类初始化（加载 ====> 验证 ====> 准备（默认值）====> 解析 ====> 初始化（赋值））保证线程安全
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {
		
		if (instance != null) { // 可以防止反射
			throw new RuntimeException("Singleton Can Not Be New");
		}
	}

	public static HungrySingleton getInstance() {
		return instance;
	}
}

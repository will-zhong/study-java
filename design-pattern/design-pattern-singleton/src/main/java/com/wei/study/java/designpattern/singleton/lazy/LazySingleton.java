package com.wei.study.java.designpattern.singleton.lazy;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:21:49
 *
 */
public class LazySingleton {

	// volatile 防止JIT 指令重排引起的异常
	private volatile static LazySingleton instance;

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}

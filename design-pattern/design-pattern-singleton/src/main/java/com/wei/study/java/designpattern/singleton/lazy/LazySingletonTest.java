package com.wei.study.java.designpattern.singleton.lazy;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:24:58
 *
 */
public class LazySingletonTest {

	public static void main(String[] args) {
		LazySingleton instance = LazySingleton.getInstance();
		LazySingleton instance2 = LazySingleton.getInstance();
		System.out.println(instance == instance2);
	}
}

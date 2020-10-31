package com.wei.study.java.designpattern.singleton.innerclass;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:43:05
 *
 */
public class Test {

	public static void main(String[] args) {
		InnerClassSingleton instance = InnerClassSingleton.getInstance();
		InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
		System.out.println(instance == instance2);
	}
}

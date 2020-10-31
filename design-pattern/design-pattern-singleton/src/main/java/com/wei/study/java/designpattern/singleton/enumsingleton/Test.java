package com.wei.study.java.designpattern.singleton.enumsingleton;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:46:23
 *
 */
public class Test {

	public static void main(String[] args) {
		EnumSingleton instance = EnumSingleton.INSTANCE;
		EnumSingleton instance2 = EnumSingleton.INSTANCE;

		System.out.println(instance == instance2);
	}
}

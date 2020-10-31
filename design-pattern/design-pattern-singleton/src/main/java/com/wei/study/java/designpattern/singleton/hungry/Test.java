package com.wei.study.java.designpattern.singleton.hungry;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:39:00
 *
 */
public class Test {

	public static void main(String[] args) {
		HungrySingleton instance = HungrySingleton.getInstance();
		HungrySingleton instance2 = HungrySingleton.getInstance();
		System.out.println(instance == instance2);
	}
}

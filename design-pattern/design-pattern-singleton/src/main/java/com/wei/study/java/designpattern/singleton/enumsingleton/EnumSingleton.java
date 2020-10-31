package com.wei.study.java.designpattern.singleton.enumsingleton;

/**
 * 可以防止反射
 *
 * @author WEI
 * @Time: 2020-10-31 14:44:57
 *
 */
public enum EnumSingleton {

	INSTANCE;
	
	public void print() {
		System.out.println("Enum Singleton");
	}
}

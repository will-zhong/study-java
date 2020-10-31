package com.wei.study.java.jvm.thread.volatile_;

/**
 * volatile 只能用于定义类成员变量，或者静态变量
 * volatile 不能和final 一起使用
 *
 * @author WEI
 * @Time: 2020-10-28 22:26:07
 *
 */
public class VolatileTest {

	volatile String str;

	// private volatile final String str2;

	volatile static String str3;

	// private volatile final static String str4;

	public VolatileTest() {
//		volatile String str5;
	}

//	public VolatileTest(volatile String arg) {}

	public void m1() {
//		volatile String str6;
	}

//	public void m1(volatile String arg) {}

	public static void m2() {
//		volatile String str7;
//		volatile static String str8;
	}

//	public static void m2(volatile String arg) {}
	
	
}

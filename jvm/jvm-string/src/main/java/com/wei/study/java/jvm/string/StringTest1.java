package com.wei.study.java.jvm.string;

/**
 *
 * @author WEI
 * @Time: 2020-10-28 18:10:57
 *
 */
public class StringTest1 {

	public static void main(String[] args) {
		String str1 = "HelloWorld";
		String str2 = new String("HelloWorld");
		String str3 = "Hello";
		String str4 = "World";
		String str5 = "Hello" + "World";
		String str6 = str3 + str4;
		System.out.println(str1 == str2); // false
		System.out.println(str1 == str5); // true
		System.out.println(str1 == str6); // false
		System.out.println(str1 == str6.intern()); // true
		System.out.println(str2 == str2.intern()); // false
	}
}

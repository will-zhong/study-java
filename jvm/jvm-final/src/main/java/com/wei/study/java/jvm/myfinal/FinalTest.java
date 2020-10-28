package com.wei.study.java.jvm.myfinal;

/**
 *
 * @author WEI
 * @Time: 2020-10-28 18:01:16
 *
 */
public class FinalTest {

	private final String str;
	
	public FinalTest() {
		this("");
	}
	
	public FinalTest(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return this.str;
	}
	
	public static void main(String[] args) {
		FinalTest f = new FinalTest("Hello");
		System.out.println(f.getStr());
	}
}

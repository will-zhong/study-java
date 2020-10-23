package com.wei.study.java.jvm.spi;

/**
 *
 * @author WEI
 * @Time: 2020-10-22 22:05:03
 *
 */
public class FileSearch implements Search {

	@Override
	public void search() {
		System.out.println("It is File Search.");
	}
}

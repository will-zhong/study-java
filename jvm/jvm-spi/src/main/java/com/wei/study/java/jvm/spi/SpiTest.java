package com.wei.study.java.jvm.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 * @author WEI
 * @Time: 2020-10-22 22:06:14
 *
 */
public class SpiTest {

	public static void main(String[] args) {
		ServiceLoader<Search> loader = ServiceLoader.load(Search.class);
		Iterator<Search> s = loader.iterator();
		while (s.hasNext()) {
			Search ss = s.next();
			ss.search();
		}

	}
}

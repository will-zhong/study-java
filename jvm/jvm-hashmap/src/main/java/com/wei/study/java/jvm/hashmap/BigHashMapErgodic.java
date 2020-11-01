package com.wei.study.java.jvm.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 大HashMap的快速遍历
 *
 * @author WEI
 * @Time: 2020-10-27 22:37:31
 *
 */
public class BigHashMapErgodic {

	private volatile Map<String, Integer> a;
	
	public static void main(String[] args) {
		
		Map<String, Integer> bigMap = new HashMap<>();

		 int amount = 100;// * 100000;
		// init
		for (int i = 0; i < amount; i++) {
			bigMap.put("" + i, i);
		}
		List<String> list = new ArrayList<>();
		
		long start = System.currentTimeMillis();
//		t1(bigMap, list);
		t2(bigMap, list);
		System.out.println(System.currentTimeMillis() - start + "ms");
		System.out.println(list.size());

	}

	public static void t1(Map<String, Integer> bigMap, List<String> list) {

		Iterator<Entry<String, Integer>> iterator = bigMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> next = iterator.next();
			list.add(next.getKey());
		}
	}

	public static void t2(Map<String, Integer> bigMap, List<String> list) {

		Iterator<Entry<String, Integer>> iterator = bigMap.entrySet().iterator();

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (iterator.hasNext()) {
						try {
							Entry<String, Integer> next = iterator.next();
							list.add(next.getKey());
							iterator.remove();
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}).start();
		}

		while (!bigMap.isEmpty()) {
			System.out.println(bigMap.size());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

package com.wei.study.java.jvm.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 大HashMap的快速遍历
 *
 * @author WEI
 * @Time: 2020-10-27 22:37:31
 *
 */
public class ThreadTraverse {

	public static void main(String[] args) throws Exception {

		Map<String, Integer> map = MapInit.getOneMillion();

		long start = System.currentTimeMillis();
		traverse(map);
		long t1 = System.currentTimeMillis() - start;

		System.out.println(t1 + "ms");
	}

	volatile static long sum = 0;
	
	static ReentrantLock lock = new ReentrantLock();

	private static void traverse(Map<String, Integer> map) throws Exception {

		List<Thread> ts = new ArrayList<>();

		Spliterator<Entry<String, Integer>> spliterator = map.entrySet().spliterator();
		
		for (int i = 0; i < 1; i++) {
			ts.add(new Thread(new Runnable() {

				@Override
				public void run() {
					spliterator.forEachRemaining((entry)->{
						lock.lock();
						sum += entry.getValue();
						lock.unlock();
					});
				}
			}));
		}

		for (Thread t : ts) {
			t.start();
		}
		
		for (Thread t : ts) {
			t.join();
		}
		
		System.out.println(sum);
		System.out.println(Integer.MAX_VALUE);
	}

}

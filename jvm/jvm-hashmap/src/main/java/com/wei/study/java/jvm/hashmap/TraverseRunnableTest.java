package com.wei.study.java.jvm.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 10:46:56
 *
 */
public class TraverseRunnableTest {

	public static void main(String[] args) throws InterruptedException {
		Map<String, Integer> map = MapInit.getOneMillion();

		long start = System.currentTimeMillis();
		traverse(map);
		long t1 = System.currentTimeMillis() - start;

		System.out.println(t1 + "ms");
	}

	/**
	 * @param map
	 * @throws InterruptedException 
	 */
	private static void traverse(Map<String, Integer> map) throws InterruptedException {
		
		List<Thread> ts = new ArrayList<>();
		List<TraverserRunnable> trs = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			TraverserRunnable traverserRunnable = new TraverserRunnable(map);
			ts.add(new Thread(traverserRunnable));
			trs.add(traverserRunnable);
		}

		for (Thread t : ts) {
			t.start();
		}
		
		for (Thread t : ts) {
			t.join();
		}
		
		long sum = 0;
		for(TraverserRunnable tr : trs) {
			sum += tr.getSum(); 
			System.out.println(tr.getSum());
		}
		System.out.println(sum);
	}
}

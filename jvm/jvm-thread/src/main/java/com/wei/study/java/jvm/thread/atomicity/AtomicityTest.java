package com.wei.study.java.jvm.thread.atomicity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author WEI
 * @Time: 2020-10-30 19:31:52
 *
 */
public class AtomicityTest {

	volatile static int sum = 0;

	public static void add() throws InterruptedException {
		List<Thread> ts = new ArrayList<>();

		ReentrantLock look = new ReentrantLock();

		for (int i = 0; i < 100; i++) {
			ts.add(new Thread(() -> {
				for (int j = 0; j < 10000; j++) {
					look.lock();
					sum += 1;
					look.unlock();
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
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		add();
		System.out.println(System.currentTimeMillis() - start);
	}
}

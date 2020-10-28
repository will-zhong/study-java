package com.wei.study.java.jvm.thread.wait;

/**
 *
 * @author WEI
 * @Time: 2020-10-25 17:19:48
 *
 */
public class WaitTest {

	public static void main(String[] args) {

		new Thread(() -> {
			synchronized (WaitTest.class) {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 1 : " + i);
					sleep();

					if (i == 5) {
						wt();
					}
				}
			}
		}).start();

		new Thread(() -> {
			synchronized (WaitTest.class) {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 2 : " + i);
					sleep();
					if (i == 5) {
						wt();
					}
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized (WaitTest.class) {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 3 : " + i);
					sleep();
				}
				WaitTest.class.notify();
			}
		}).start();
	}

	public static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void wt() {
		try {
			WaitTest.class.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

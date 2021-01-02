package com.wei.study.java.jvm.thread.threadlocal;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    final static ThreadLocal<Long> tl = new ThreadLocal<Long>(){


        protected Long initialValue() {
            System.out.println("init = " + System.currentTimeMillis());
            return System.currentTimeMillis();
        }
    };

    public static void begin() {
        System.out.println("begin = " + System.currentTimeMillis());
        tl.set(System.currentTimeMillis());
    }

    public static long end() {
        System.out.println("end = " + System.currentTimeMillis());
        return System.currentTimeMillis() - tl.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost = " + ThreadLocalTest.end());
    }
}

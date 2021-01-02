package com.wei.study.java.jvm.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest {

    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference stampedReference = new AtomicStampedReference(100,0);
}

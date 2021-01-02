package com.wei.study.java.jvm.hashmap.base;

import java.util.HashMap;

/**
 * @author WEI
 * @Time: 2020-10-31 22:31:23
 */
public class HashMapBaseTest {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

        HashMap<String, Integer> hashmap = new HashMap<>();

        for (Integer i = 0; i < 20; i++) {
            String key = "" + i;
            hashmap.put(key, i);

        }


    }
}

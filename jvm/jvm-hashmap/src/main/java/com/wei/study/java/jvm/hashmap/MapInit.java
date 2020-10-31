package com.wei.study.java.jvm.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author WEI
 * @Time: 2020-10-30 0:04:26
 *
 */
public class MapInit {

	public static Map<String, Integer> getOneThousand() {
		return get(1000);
	}
	
	public static Map<String, Integer> getOneMillion() {
		return get(1000000);
	}
	
	public static Map<String, Integer> getTenMillion() {
		return get(10000000);
	}
	
	public static Map<String, Integer> get(int size) {
		
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < size; i++) {
			map.put("" + i, i);
		}
		
		return map;
	}
}

package com.wei.study.java.jvm.hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Spliterator;

/**
 *
 * @author WEI
 * @Time: 2020-10-30 0:01:47
 *
 */
public class SimpleTraverse {

	public static void main(String[] args) {

		Map<String, Integer> map = init();
		long start = System.currentTimeMillis();
		iterator(map);
		long t1 = System.currentTimeMillis() - start;

		map = init();
		start = System.currentTimeMillis();
		forEach(map);
		long t2 = System.currentTimeMillis() - start;

		map = init();
		start = System.currentTimeMillis();
		lambda(map);
		long t3 = System.currentTimeMillis() - start;

		map = init();
		start = System.currentTimeMillis();
		stream(map);
		long t4 = System.currentTimeMillis() - start;

		map = init();
		start = System.currentTimeMillis();
		parallelStream(map);
		long t5 = System.currentTimeMillis() - start;

		map = init();
		start = System.currentTimeMillis();
		spliterator(map);
		long t6 = System.currentTimeMillis() - start;

		System.out.println(t1 + "ms");
		System.out.println(t2 + "ms");
		System.out.println(t3 + "ms");
		System.out.println(t4 + "ms");
		System.out.println(t5 + "ms");
		System.out.println(t6 + "ms");
	}

	public static Map<String, Integer> init() {
		return MapInit.getTenMillion();
	}

	static int sum = 0;
	static List<String> list = new ArrayList<>();

	public static void output(Entry<String, Integer> entry) {
		sum += entry.getValue();
	}

	public static void print() {
		System.out.println(sum);
		sum = 0;
	}

	public static void iterator(Map<String, Integer> map) {
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			output(iterator.next());
		}
		print();
	}

	public static void forEach(Map<String, Integer> map) {
		for (Entry<String, Integer> entry : map.entrySet()) {
			output(entry);
		}
		print();
	}

	public static void lambda(Map<String, Integer> map) {
		map.forEach((key, value) -> {
			sum += value;
		});
		print();
	}

	public static void stream(Map<String, Integer> map) {
		map.entrySet().stream().forEach((entry) -> {
			output(entry);
		});
		print();
	}

	public static void parallelStream(Map<String, Integer> map) {
		map.entrySet().parallelStream().forEach((entry) -> {
			output(entry);
		});
		print();
	}

	public static void spliterator(Map<String, Integer> map) {
		Spliterator<Entry<String, Integer>> spliterator = map.entrySet().spliterator();
		spliterator.forEachRemaining((entry) -> {
			output(entry);
		});
		print();
	}
}

package com.wei.study.java.jvm.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 10:40:28
 *
 */
public class TraverserRunnable implements Runnable{

	private Map<String, Integer> hashmap = new HashMap<>();
	
	public TraverserRunnable(Map<String, Integer> hashmap) {
		this.hashmap = hashmap;
	}
	
	private long sum = 0;
	
	@Override
	public void run() {
		Set<Entry<String,Integer>> entrySet = hashmap.entrySet();
		
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
		
		while(true) {
			Entry<String, Integer> entry = getEntry(iterator);
			if(entry == null) {
				break;
			}
			sum += entry.getValue();
		}
		
	}
	
	public long getSum() {
		return this.sum;
	}

	public synchronized static Entry<String, Integer> getEntry(Iterator<Entry<String, Integer>> iterator) {
		if(iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			iterator.remove();
			return entry;
		}
		
		return null;
	}
}

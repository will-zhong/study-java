package com.wei.study.java.designpattern.singleton.innerclass;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * @author WEI
 * @Time: 2020-10-31 14:40:14
 *
 */
public class InnerClassSingleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private static class InnerClassSingletonHolder {
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}

	private InnerClassSingleton() {
		if (InnerClassSingletonHolder.instance != null) { // 可以防止反射
			throw new RuntimeException("单例不允许多个实例 ");
		}
	}

	public static InnerClassSingleton getInstance() {
		return InnerClassSingletonHolder.instance;
	}

	// 防止序列化破坏单例
	public Object readResolve() throws ObjectStreamException {
		return InnerClassSingletonHolder.instance;
	}
}

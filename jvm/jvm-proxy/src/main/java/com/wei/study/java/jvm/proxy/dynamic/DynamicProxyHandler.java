package com.wei.study.java.jvm.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author WEI
 * @Time: 2020-10-23 16:30:23
 *
 */
public class DynamicProxyHandler implements InvocationHandler {

	private Object obj;

	public DynamicProxyHandler(final Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("买房前准备");
		Object result = method.invoke(obj, args);
		System.out.println("买房后装修");
		return result;
	}

}

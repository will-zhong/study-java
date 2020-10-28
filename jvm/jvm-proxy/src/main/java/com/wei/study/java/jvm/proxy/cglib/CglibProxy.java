package com.wei.study.java.jvm.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 *
 * @author WEI
 * @Time: 2020-10-24 22:57:52
 *
 */
public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("买房前准备");
		Object result = proxy.invokeSuper(obj, args); // 重点：调用父类
		System.out.println("买房后装修");
		return result;
	}

}

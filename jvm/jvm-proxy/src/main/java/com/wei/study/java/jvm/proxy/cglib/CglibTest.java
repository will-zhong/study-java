package com.wei.study.java.jvm.proxy.cglib;

import com.wei.study.java.jvm.proxy.BuyHouseImpl;

import net.sf.cglib.proxy.Enhancer;

/**
 *
 * @author WEI
 * @Time: 2020-10-24 22:59:00
 *
 */
public class CglibTest {

	public static void main(String[] args) {
		
		CglibProxy cglibProxy = new CglibProxy();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(BuyHouseImpl.class);
		enhancer.setCallback(cglibProxy);
		
		Object obj = enhancer.create();
		((BuyHouseImpl)obj).buyHosue();
	}
}

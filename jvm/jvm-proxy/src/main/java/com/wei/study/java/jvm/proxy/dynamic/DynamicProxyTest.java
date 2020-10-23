package com.wei.study.java.jvm.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.wei.study.java.jvm.proxy.BuyHouse;
import com.wei.study.java.jvm.proxy.BuyHouseImpl;

/**
 *
 * @author WEI
 * @Time: 2020-10-23 16:32:46
 *
 */
public class DynamicProxyTest {

	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader()
				, new Class[] { BuyHouse.class }, new DynamicProxyHandler(buyHouse));
		proxyBuyHouse.buyHosue();
	}
}

package com.wei.study.java.jvm.proxy;

/**
 *
 * @author WEI
 * @Time: 2020-10-23 16:28:17
 *
 */
public class ProxyText {

	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
		buyHouseProxy.buyHosue();
	}
}

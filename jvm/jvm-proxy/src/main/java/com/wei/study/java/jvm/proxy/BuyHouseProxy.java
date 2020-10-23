package com.wei.study.java.jvm.proxy;

/**
 *
 * @author WEI
 * @Time: 2020-10-23 16:26:44
 *
 */
public class BuyHouseProxy implements BuyHouse {

	private BuyHouse buyHouse;

	public BuyHouseProxy(final BuyHouse buyHouse) {
		this.buyHouse = buyHouse;
	}

	@Override
	public void buyHosue() {
		System.out.println("买房前准备");
		buyHouse.buyHosue();
		System.out.println("买房后装修");
	}

}

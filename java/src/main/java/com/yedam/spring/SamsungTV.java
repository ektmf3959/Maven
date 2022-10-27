package com.yedam.spring;


public class SamsungTV implements TV{

	@Override
	public void on() {
		System.out.println("스프링 방식으로");
	}

}

package com.yedam.java;

public class Main {

	public static void main(String[] args) {
		TV tv = new SamsungTV();
		tv.on();
		
		TVDisplay td = new TVDisplay(new SamsungTV());
		td.tvOn();
	}

}

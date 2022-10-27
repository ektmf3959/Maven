package com.yedam.java;


public class TVDisplay {
	TV tv;
	
	//생성자
	public TVDisplay(TV tv) {
		this.tv = tv;
	}
	
	//메소드(setter)
	public void setTV(TV tv) {
		this.tv = tv;
	}
	
	public void tvOn() {
		this.tv.on();
	}
}

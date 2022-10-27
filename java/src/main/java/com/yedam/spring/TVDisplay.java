package com.yedam.spring;

public class TVDisplay {
	TV tv;
	
	public TVDisplay() {
		
	}
	
	public TVDisplay(TV selectedTv) {
		this.tv = selectedTv;
	}
	
	public void setTV(TV tv) {
		this.tv = tv;
	}
	//setTV에서 첫글자만 자동으로 소문자로 바꿔줘서 tV로 name이 들어감
	//<property name="tV" ref="tv" /> 
	public void run() {
		this.tv.on();
	}
}

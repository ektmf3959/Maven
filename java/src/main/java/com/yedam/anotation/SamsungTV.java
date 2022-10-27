package com.yedam.anotation;

import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {

	@Override
	public void on() {
		System.out.println("어노테이션 사용");
	}

}

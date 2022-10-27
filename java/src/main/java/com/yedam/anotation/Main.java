package com.yedam.anotation;


import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TVDisplay td = (TVDisplay)ctx.getBean("TVDisplay");
		td.run();
	}

}

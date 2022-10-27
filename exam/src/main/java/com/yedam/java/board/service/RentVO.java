package com.yedam.java.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RentVO extends BookVO {
//	RENT_NO	NUMBER
//	BOOK_NO	NUMBER
//	RENT_PRICE	NUMBER
//	RENT_DATE	DATE
//	RENT_STATUS	CHAR(1 BYTE)
	
	private int rentNo;
	private int bookNo;
	private int RentPrice;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date rentDate;
	private String rentStatus;
	
}

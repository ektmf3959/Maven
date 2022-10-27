package com.yedam.java.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	/*
	 * BOOK_NO	NUMBER
		BOOK_NAME	VARCHAR2(50 BYTE)
		BOOK_COVERING	VARCHAR2(20 BYTE)
		BOOK_DATE	DATE
		BOOK_PRICE	NUMBER
		BOOK_PUBLISHER	VARCHAR2(50 BYTE)
		BOOK_INFO	VARCHAR2(2000 BYTE)
	 */
	
	private int bookNo;
	private String bookName;
	private String bookCovering;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
}

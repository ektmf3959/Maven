package com.yedam.java.board.mapper;

import java.util.List;

import com.yedam.java.board.service.BookVO;

public interface BookMapper {
	//입력될 도서번호 조회
	public BookVO getBookNo();
	//등록
	int bookInsert(BookVO BookVO);
	//조회
	public List<BookVO> bookList();
}

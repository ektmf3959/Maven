package com.yedam.java.board.service;

import java.util.List;

public interface BoardService {
	//입력될 도서번호 조회
	public int getBookNo();
	//등록
	int bookInsert(BookVO bookVO);
	//전체조회
	public List<BookVO> bookList();
}

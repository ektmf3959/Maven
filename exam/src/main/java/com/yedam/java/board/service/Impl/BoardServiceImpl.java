package com.yedam.java.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.board.mapper.BookMapper;
import com.yedam.java.board.service.BoardService;
import com.yedam.java.board.service.BookVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BookMapper bkMapper;

	@Override
	public int getBookNo() {
		return bkMapper.getBookNo().getBookNo();
	}

	@Override
	public int bookInsert(BookVO bookVO) {
		return bkMapper.bookInsert(bookVO);
	}

	@Override
	public List<BookVO> bookList() {
		return bkMapper.bookList();
	}

	

}

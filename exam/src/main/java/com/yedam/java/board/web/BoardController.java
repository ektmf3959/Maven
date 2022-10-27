package com.yedam.java.board.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.board.service.BoardService;
import com.yedam.java.board.service.BookVO;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/bookList")
	public String BookInfo(Model model) {
		model.addAttribute("bookList", service.bookList());
		return "board/bookList";
	}
	
	//도서정보 등록
	@GetMapping("/bookInsert")
	public String bookInsert(Model model) {
		model.addAttribute("no", service.getBookNo());
		return "board/bookInsert";
	}
	
	//등록 Db insert
	@PostMapping("/bookInsert")
	public String BookInsertboard(BookVO bookVO, RedirectAttributes ratt) {
		int result = service.bookInsert(bookVO);
		if(result == 1) {
			ratt.addFlashAttribute("msg", "정상적으로 등록되었습니다.");
		} else {
			ratt.addAttribute("msg", "정상적으로 등록되지 않았습니다.");
		}
		return "redirect:bookList";
	}
	
}

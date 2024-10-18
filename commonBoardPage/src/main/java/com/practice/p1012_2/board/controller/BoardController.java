package com.practice.p1012_2.board.controller;

import com.practice.p1012_2.board.dto.BoardDto;
import com.practice.p1012_2.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "redirect:/board/list";
	}
	
//	@GetMapping("/board/list")
//	public String openBoardList(Model model) throws Exception{
//		List<BoardDto> list = boardService.selectBoardList();
//		model.addAttribute("list", list);
//		return "/board/boardList";
//	}

	@GetMapping("/board/list")
	public String categoryList(@RequestParam(value = "category", required = false, defaultValue = "모든게시판")
							   String category, Model model) throws Exception{
		List<BoardDto> list;
		if (category.equals("모든게시판")){
			list = boardService.selectBoardList();
		} else {
			list = boardService.selectBoardListByCategory(category);
		}

		model.addAttribute("list", list);
		model.addAttribute("selectedCategory", category);
		return "/board/boardList";
	}
	
	@GetMapping("/board/write")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	@PostMapping("/board/insert")
	public String insertBoard(BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/detail")
	public String openBoardDetail(@RequestParam int boardIdx, Model model) throws Exception{
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}
	
	@PostMapping("/board/update")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/delete")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/list";
	}
}

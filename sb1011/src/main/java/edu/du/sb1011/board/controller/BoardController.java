package edu.du.sb1011.board.controller;

import edu.du.sb1011.board.dto.BoardDto;
import edu.du.sb1011.board.service.BoardService;
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
	public String root(){
		return "redirect:/board/openBoardList";
	}

	@GetMapping("/board/openBoardList")
	public String  openBoardList(Model model) {
		List<BoardDto> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "/board/boardList";
	}
	
	@GetMapping("/board/openBoardWrite")
	public String openBoardWrite() {
		return "/board/boardWrite";
	}
	
	@PostMapping("/board/insertBoard")
	public String insertBoard(BoardDto board) {
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList";
	}
	
	@GetMapping("/board/openBoardDetail")
	public String openBoardDetail(@RequestParam int boardIdx, Model model) {
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}
	
	@PostMapping("/board/updateBoard")
	public String updateBoard(BoardDto board) {
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList";
	}
	
	@PostMapping("/board/deleteBoard")
	public String deleteBoard(int boardIdx) {
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList";
	}
}

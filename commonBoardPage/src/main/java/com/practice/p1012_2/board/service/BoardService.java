package com.practice.p1012_2.board.service;


import com.practice.p1012_2.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
	
	List<BoardDto> selectBoardList() throws Exception;
	
	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(BoardDto board) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	List<BoardDto> selectBoardListByCategory(String category) throws Exception;

}

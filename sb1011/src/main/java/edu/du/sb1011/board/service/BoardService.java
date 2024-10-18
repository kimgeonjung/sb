package edu.du.sb1011.board.service;

import edu.du.sb1011.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
	List<BoardDto> selectBoardList();
	void insertBoard(BoardDto board);
	BoardDto selectBoardDetail(int boardIdx);
	void updateBoard(BoardDto board);
	void deleteBoard(int boardIdx);
}

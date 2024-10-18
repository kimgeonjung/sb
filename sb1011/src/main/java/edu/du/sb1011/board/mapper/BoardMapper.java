package edu.du.sb1011.board.mapper;

import edu.du.sb1011.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList();
	void insertBoard(BoardDto board);
	BoardDto selectBoardDetail(int boardIdx);
	void updateHitCount(int boardIdx);
	void updateBoard(BoardDto board);
	void deleteBoard(int boardIdx);
}

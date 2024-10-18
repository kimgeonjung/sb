package com.practice.p1012_2.board.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardDto {
	private int boardIdx;
	private String title;
	private String category;
	private String contents;
	private int hitCnt;
	private String creatorId;
	private String createdDatetime;
	private String updaterId;
	private String updatedDatetime;
}

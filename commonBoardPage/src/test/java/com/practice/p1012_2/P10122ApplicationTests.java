package com.practice.p1012_2;

import com.practice.p1012_2.board.dto.BoardDto;
import com.practice.p1012_2.board.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class P10122ApplicationTests {

    @Autowired
    BoardService boardService;

    @Test
    void 선택된게시글정보() throws Exception {
        BoardDto dto = boardService.selectBoardDetail(1);
        System.out.println(dto);
    }

}

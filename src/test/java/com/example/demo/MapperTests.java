/*
package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.Demo5Application;
import com.board.app_board.dto.BoardVo;
import com.board.mapper.MainMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = Demo5Application.class)
class MapperTests {

	@Autowired
	private MainMapper boardMapper;

	@Test
	public void testOfInsert() {
		BoardVo params = new BoardVo();
		params.setMemId("hong123");
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");

		int result = boardMapper.insertBoard(params);
		System.out.println("결과는 " + result + "입니다.");
	}

	@Test
	public void testOfSelectDetail() {
		BoardVo board = boardMapper.selectBoardDetail((long) 1, "hong123");
		try {
			String boardJson = new ObjectMapper().writeValueAsString(board);

			System.out.println("=========================");
			System.out.println(boardJson);
			System.out.println("=========================");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOfUpdate() {
		BoardVo params = new BoardVo();
		params.setTitle("1번 게시글 제목을 수정합니다.");
		params.setContent("1번 게시글 내용을 수정합니다.");
		params.setIdx((long) 1);

		int result = boardMapper.updateBoard(params);

		if (result == 1) {
			BoardVo board = boardMapper.selectBoardDetail((long) 1, "hong123");
			try {
				String boardJson = new ObjectMapper().writeValueAsString(board);

				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testOfDelete() {
		int result = boardMapper.deleteBoard((long) 1, "hong123");

		if (result == 1) {
			BoardVo board = boardMapper.selectBoardDetail((long) 1, "hong123");
			try {
				String boardJson = new ObjectMapper().writeValueAsString(board);

				System.out.println("=========================");
				System.out.println(boardJson);
				System.out.println("=========================");

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void testMultipleInsert() {
		for (int i = 2; i <= 50; i++) {
			BoardVo params = new BoardVo();
			params.setTitle(i + "번 게시글 제목");
			params.setContent(i + "번 게시글 내용");
			boardMapper.insertBoard(params);
		}
	}
	
	
	@Test
	public void testSelectList() {
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		if (boardTotalCount > 0) {
			List<BoardVo> boardList = boardMapper.selectBoardList();
			
				for (BoardVo board : boardList) {
					System.out.println("=========================");
					System.out.println(board.getTitle());
					System.out.println(board.getContent());
					System.out.println("=========================");
				}
		}
	}
}
 */
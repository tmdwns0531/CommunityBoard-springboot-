package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.app_board.dto.BoardVo;



@Service
@Transactional
public interface BoardService {
	
	public int insertBoard(BoardVo params);

	public BoardVo selectBoardDetail( Long idx, String memId);

	public int updateBoard(BoardVo params);

	public int deleteBoard( Long idx,String memId);

	public List<BoardVo> selectBoardList();

	public int selectBoardTotalCount();

}

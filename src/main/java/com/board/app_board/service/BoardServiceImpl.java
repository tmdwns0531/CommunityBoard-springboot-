package com.board.app_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.app_board.dto.BoardVo;
import com.board.mapper.MainMapper;
import com.board.service.BoardService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	MainMapper mapper;
	

	@Override
	public int updateBoard(BoardVo params) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(params);
	}
	
	@Override
	public int insertBoard(BoardVo params) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(params);
	}


	@Override
	public BoardVo selectBoardDetail(Long idx, String memId) {
		// TODO Auto-generated method stub
		return mapper.selectBoardDetail(idx, memId);
	}

	@Override
	public int deleteBoard(Long idx, String memId) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(idx, memId);
	}

	@Override
	public List<BoardVo> selectBoardList() {
		// TODO Auto-generated method stub
		return mapper.selectBoardList();
	}

	@Override
	public int selectBoardTotalCount() {
		// TODO Auto-generated method stub
		return mapper.selectBoardTotalCount();
	}






}

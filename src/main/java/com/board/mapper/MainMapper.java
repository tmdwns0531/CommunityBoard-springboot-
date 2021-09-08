package com.board.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.board.app_board.dto.BoardVo;
import com.board.app_member.dto.MemberVo;

@Mapper
public interface MainMapper {
	
	//회원 관련
	public List<MemberVo> getMemberList() throws Exception;

	public List<MemberVo> checkMember(@Param("_id") String id, @Param("_pw") String pw) throws Exception;
	
	public String checkOverlapId(@Param("_id") String id) throws Exception;
	
	public int joinMember(MemberVo vo) throws Exception;
	
	
	// 게시판 관련
	public int insertBoard(BoardVo params);

	public BoardVo selectBoardDetail(@Param("_idx") Long idx, @Param("_memId") String memId);

	public int updateBoard(BoardVo params);

	public int deleteBoard(@Param("_idx") Long idx, @Param("_memId") String memId);

	public List<BoardVo> selectBoardList();

	public int selectBoardTotalCount();
}

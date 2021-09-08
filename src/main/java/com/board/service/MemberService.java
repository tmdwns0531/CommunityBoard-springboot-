package com.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.app_member.dto.MemberVo;


@Service
@Transactional
public interface MemberService {

	public List<MemberVo> getMemberList() throws Exception;

	public List<MemberVo> checkMember(String id, String pw) throws Exception;
	
	public String checkOverlapId(String id) throws Exception;
	
	public int joinMember(MemberVo vo) throws Exception;
}

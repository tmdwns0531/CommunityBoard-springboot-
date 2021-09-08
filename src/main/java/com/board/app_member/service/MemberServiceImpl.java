package com.board.app_member.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.app_member.dto.MemberVo;
import com.board.mapper.MainMapper;
import com.board.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MainMapper mapper;

	@Override
	public List<MemberVo> getMemberList() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getMemberList();
	}

	@Override
	public List<MemberVo> checkMember(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		return mapper.checkMember(id, pw);
	}

	@Override
	public String checkOverlapId(String id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.checkOverlapId(id);
	}

	@Override
	public int joinMember(MemberVo vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.joinMember(vo);
	}


}

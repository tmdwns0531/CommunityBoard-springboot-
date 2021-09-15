package com.board.app_board.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.app_board.dto.BoardVo;
import com.board.app_member.dto.MemberVo;
import com.board.commandObj.Member;
import com.board.service.BoardService;
import com.board.utils.ScriptUtils;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public String boardList(Model model, HttpSession sess) throws Exception {
		// 게시판 조회
		List<BoardVo> li = service.selectBoardList();

		model.addAttribute("boardList", li);
		return "board/boardList";
	}

	@PostMapping("/insert")
	public void boardInsert(Member member, HttpServletResponse response, HttpSession sess) throws Exception {
		MemberVo mem = (MemberVo) sess.getAttribute("loginUser");

		BoardVo vo = new BoardVo();
		vo.setMemId(mem.getId());
		vo.setTitle(member.getTitle());
		vo.setContent(member.getContent());

		// 게시글 저장
		int rs = service.insertBoard(vo);

		if (rs > 0) {
			ScriptUtils.alertAndMovePage(response, "게시글 작성이 완료되었습니다.", "/board/list");
		} else {
			ScriptUtils.alertAndMovePage(response, "게시글 작성 오류 (개발자문의).", "/");
		}
	}

	@GetMapping("/delete")
	public void deleteBoard(Member member, HttpSession sess, HttpServletResponse response) 
			throws Exception {

		MemberVo user = (MemberVo) sess.getAttribute("loginUser");

		// 게시글 삭제
		service.deleteBoard(Long.parseLong(member.getIdx()), user.getId());

		ScriptUtils.alertAndMovePage(response, "게시글 삭제가 완료되었습니다.", "/board/list");
	}

	@PostMapping("/revise")
	public void reviseBoard(Member member, HttpSession sess, HttpServletResponse response) throws Exception {

		BoardVo vo = new BoardVo();
		vo.setIdx(Long.parseLong(member.getIdx()));
		vo.setMemId(member.getMemId());
		vo.setTitle(member.getTitle());
		vo.setContent(member.getContent());

		// 게시글 수정
		service.updateBoard(vo);

		ScriptUtils.alertAndMovePage(response, "게시글 수정 완료되었습니다.", "/board/list");
	}

	@GetMapping("/boardForm") // 수정 + 등록 폼
	public String boardForm(@RequestParam(required = false) String idx, HttpSession sess, Model model)
			throws Exception {

		MemberVo user = (MemberVo) sess.getAttribute("loginUser");

		if (idx != null) { // 수정
			BoardVo vo = service.selectBoardDetail(Long.parseLong(idx), user.getId());
			model.addAttribute("userInfo", vo);
		} else {
			model.addAttribute("userInfo", null);
			model.addAttribute("userId", user.getId());
		}

		// 게시글 수정
		return "board/boardForm";
	}

}

package com.board.app_member.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.app_member.dto.MemberVo;
import com.board.commandObj.Member;
import com.board.service.MemberService;
import com.board.utils.ScriptUtils;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;

	@PostMapping("/login")
	public void login(@RequestParam String id, @RequestParam String pw, HttpSession sess, HttpServletResponse response)
			throws Exception {

		List<MemberVo> member = service.checkMember(id, pw);

		System.out.println("member.size ? " + member.size());
		if (member.size() != 0) {
			sess.setAttribute("loginUser", member.get(0));
			ScriptUtils.alertAndMovePage(response, "로그인 완료", "/");
		}
		ScriptUtils.alertAndBackPage(response, "아이디 비밀번호가 일치하지 않습니다");
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}

	@GetMapping("/logout")
	public String loginOut(HttpSession sess) {
		System.out.println("로그아웃!");

		sess.invalidate();
		return "redirect:/";
	}

	@GetMapping("/memList")
	public String MemberList(Model model) throws Exception {

		List<MemberVo> list = service.getMemberList();

		for (MemberVo memberVo : list) {
			System.out.println(memberVo);
		}

		model.addAttribute("memList", list);
		return "member/memberList";
	}

	@ResponseBody
	@PostMapping("/checkId") // 아이디 중복 검사
	public String checkOverlapId(@RequestBody Member member) throws Exception {

		String rs = service.checkOverlapId(member.getId());

		if (rs != null) {
			return "overlap";
		}
		return "ok";
	}

	@PostMapping("/join")
	public void joinMember(Member member, HttpServletResponse response) throws Exception {
		
		MemberVo vo = new MemberVo();
		vo.setId(member.getId());
		vo.setPw(member.getPw());
		vo.setName(member.getName());
		vo.setEmail(member.getEmail());
		vo.setNickname(member.getNickname());
		vo.setAddress(member.getAddress());
		vo.setJoinPath(member.getJoinpath());
		
		
		int rs = service.joinMember(vo);
		
		if (rs > 0) {
			ScriptUtils.alertAndMovePage(response, "회원가입이 완료되었습니다", "/member/loginForm");
		}
		ScriptUtils.alertAndBackPage(response, "회원가입 실패 ( * 개발자 문의[메일] * )");
	}
}

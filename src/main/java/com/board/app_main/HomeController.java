package com.board.app_main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.app_member.dto.MemberVo;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Locale locale, Model model, HttpSession sess) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		System.out.println("session ? " + (MemberVo) sess.getAttribute("loginUser"));
		model.addAttribute("serverTime", formattedDate);

		return "main/index";
	}
}
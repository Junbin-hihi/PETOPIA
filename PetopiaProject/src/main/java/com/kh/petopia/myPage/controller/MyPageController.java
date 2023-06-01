package com.kh.petopia.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.petopia.myPage.model.service.MyPageService;

@Controller
public class MyPageController {

	@Autowired
	private MyPageService myPageService;
	
	@RequestMapping("myPage.me")
	public String myPage() {
		return "myPage/myPage";
	}
	
	// 마이페이지 게시글 조회
	@RequestMapping("board.me")
	public String myBoardList(Model model) {
		
		model.addAttribute("list", myPageService.myBoardList());
		
		return "member/myBoardList";
	}
	
}

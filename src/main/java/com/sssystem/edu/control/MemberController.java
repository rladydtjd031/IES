package com.sssystem.edu.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/member/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/member/joinCheck")
	public String joinCheck(){
		return "join_check";
	}
	
	@RequestMapping("/member/join")
	public String join(){
		return "join";
	}
	
	@RequestMapping("/member/findIdCheck")
	public String findIdCheck(){
		return "search_id";
	}
	
	@RequestMapping("/member/findId")
	public String findId(){
		return "search_id_ok";
	}
	
	@RequestMapping("/member/findPasswordCheck")
	public String findPasswordCheck(){
		return "search_pass";
	}
	
	@RequestMapping("/member/findPassword")
	public String findPassword(){
		return "search_pass_ok";
	}
	
}

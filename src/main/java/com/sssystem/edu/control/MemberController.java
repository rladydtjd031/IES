package com.sssystem.edu.control;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.service.MemberService;
import com.sssystem.edu.vo.support.SessionVO;




@Controller
public class MemberController{
	
	@Autowired
	MemberService memberService;

	@RequestMapping("/member/login")
	public String login(){
		return "member/login";
	}
	
	@RequestMapping("member/loginAccess")
	public String loginAccess(@RequestParam(value="id") String id,
							  @RequestParam(value="pass") String pass, Model model){
		if(memberService.selectLogin(id).equals(pass)){
		SessionVO sessionVO = memberService.selectSession(id);
		model.addAttribute("user", sessionVO);
		return "index";
		}
		else {
			return "redirect:login";
		}
	}//loginAccess
	
	@RequestMapping("/member/joinCheck")
	public String joinCheck(){
		return "member/join_check";
	}//joinCheck
	
	@RequestMapping("/member/joinAccess")
	public String joinAccess(@RequestParam(value="user_nm") String user_nm,
			  				 @RequestParam(value="emp_serial") String emp_serial, Model model){
		if(memberService.selectEmp(user_nm, emp_serial).equals(user_nm)){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("user_nm", user_nm);
			map.put("emp_serial", emp_serial);
			
			HashMap<String, Object> deptjob = memberService.selectDept1(map);
			int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
			MemberVO memverVO = memberService.select(user_no);
			model.addAttribute("deptjob", deptjob);
			model.addAttribute("member", memverVO);
			
			return "member/join";
		}
		else return "redirect:join_check";
	}//joinAccess
	
	@RequestMapping("member/joinAction")
	public String joinAction(@RequestParam(value="user_no") int user_no,
							 @RequestParam(value="user_id") String user_id,
							 @RequestParam(value="user_pwd") String user_pwd,
							 @RequestParam(value="line_no") String line_no,
							 @RequestParam(value="phone") String phone_no,
							 @RequestParam(value="second") String second_no,
							 @RequestParam(value="post") String post,
							 @RequestParam(value="address") String address,
							 @RequestParam(value="email") String email,
							 Model model){
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUser_no(user_no);
		memberVO.setUser_id(user_id);
		memberVO.setUser_pwd(user_pwd);
		memberVO.setLine_no(line_no);
		memberVO.setPhone_no(phone_no);
		memberVO.setSecond_no(second_no);
		memberVO.setPost(post);
		memberVO.setAddress(address);
		memberVO.setEmail(email);
		
		if(memberService.updateJoin(memberVO)){
		
			return "member/login";
			}
		else 
		return "member/join_check";
		}
		
		
	
	@RequestMapping("/member/findIdCheck")
	public String findIdCheck(){
		return "member/search_id";
	}//findIdCheck
	
	
	@RequestMapping("/member/findIdCheckAccess")
	public String findIdCheckAccess(@RequestParam(value="user_nm") String user_nm,
							  	    @RequestParam(value="emp_serial") String emp_serial, Model model){
		if(memberService.selectEmp1(user_nm, emp_serial).equals(user_nm)){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("user_nm", user_nm);
			map.put("emp_serial", emp_serial);
			
			HashMap<String, Object> deptjob = memberService.selectDept(map);
			int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
			MemberVO memverVO = memberService.select(user_no);
			String id = memverVO.getUser_id().substring(0,memverVO.getUser_id().length()-4)+"****";
			model.addAttribute("user_nm", user_nm);
			model.addAttribute("id", id);
			return "member/search_id_ok";
		}
		else 
		return "redirect:findIdCheck";
	}//findIdCheckAccess
	
	@RequestMapping("/member/findPasswordCheck")
	public String findPasswordCheck(){
		return "member/search_pass";
	}//findPasswordCheck
	
	@RequestMapping("/member/findPasswordAccess")
	public String findPassword(@RequestParam(value="user_id") String user_id,
							   @RequestParam(value="user_nm") String user_nm,
	  	    				   @RequestParam(value="emp_serial") String emp_serial, Model model){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_nm", user_nm);
		map.put("emp_serial", emp_serial);
		
		if(memberService.selectEmp2(map).equals(user_nm)){
			HashMap<String, Object> deptjob = memberService.selectDept(map);
		int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
		MemberVO memverVO = memberService.select(user_no);
		model.addAttribute("member", memverVO);
		return "member/search_pass_ok";
		}
		else return "redirect:search_pass";
	}//findPassword
	
}


















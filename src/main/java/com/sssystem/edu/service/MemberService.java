package com.sssystem.edu.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.vo.support.SessionVO;


public interface MemberService {

	public boolean updateJoin(MemberVO member);
	public String selectLogin(String id);
	public String selectEmp(String user_nm, String emp_serial);
	public String selectEmp1(String user_nm, String emp_serial);
	public boolean findId(String name, String empno);
	public SessionVO selectSession(String id);
	public HashMap<String, Object> selectDept(HashMap<String, String> map);
	public HashMap<String, Object> selectDept1(HashMap<String, String> map);
	public String selectEmp2(HashMap<String, String> map);
	public MemberVO select(int user_no);
	public MemberVO select2(int user_no);
	public int selectID(String id);
	public boolean selectLogSession(int log);
	public boolean selectWrite(int log);
	public void insertLog(int log);
	public boolean selectQuestion(int log);
	public ArrayList<String> myWriteView(int log);
	public ArrayList<String> myQuestionView(int log);
	
}

package com.sssystem.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.service.MemberService;
import com.sssystem.edu.vo.support.SessionVO;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private SqlSession session;

	@Override
	public boolean updateJoin(MemberVO member) {//회원가입
		int t = session.update("member.join", member);
		if (t == 1) return true;
		return false;
	}

	@Override
	public String selectLogin(String id) {//로그인
		String pw = session.selectOne("member.login", id);
		return pw;
	}

	@Override
	public String selectEmp(String user_nm, String emp_serial) {
		String result = session.selectOne("member.selectEmp", emp_serial);
		return result;
	}//회원가입전 이름, 사원번호 확인

	@Override
	public String selectEmp1(String user_nm, String emp_serial) {
		String user_name = session.selectOne("member.selectEmp1", emp_serial);
		return user_name;
	}

	@Override
	public boolean findId(String name, String empno) {
		int t = session.selectOne("member.findId", name);
		if(t == 1) return true;
		return false;
	}//아이디 찾기

	@Override
	public SessionVO selectSession(String id) {
		SessionVO sessionVO = null;
		sessionVO = session.selectOne("member.session", id);
		return sessionVO;
	}

	@Override
	public HashMap<String, Object> selectDept(HashMap<String, String> map) {
		HashMap<String, Object> getMap = null;
		getMap = session.selectOne("member.selectDept", map);
		return getMap;
	}

	@Override
	public HashMap<String, Object> selectDept1(HashMap<String, String> map) {
		HashMap<String, Object> getMap = null;
		getMap = session.selectOne("member.selectDept1", map);
		return getMap;
	}

	@Override
	public String selectEmp2(HashMap<String, String> map) {
		String user_nm = session.selectOne("member.selectEmp2", map);
		return user_nm;
	}

	@Override
	public MemberVO select(int user_no) {
		MemberVO member = session.selectOne("member.select", user_no);
		return member;
	}

	@Override
	public MemberVO select2(int user_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean selectLogSession(int log) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectWrite(int log) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertLog(int log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean selectQuestion(int log) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> myWriteView(int log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> myQuestionView(int log) {
		// TODO Auto-generated method stub
		return null;
	}

}

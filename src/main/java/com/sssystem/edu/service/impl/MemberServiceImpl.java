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
	public boolean selectLogin(String id, String pass) {//로그인
		int t = session.insert("member.login", id);
		if(t == 1) return true;
		return false;
	}

	@Override
	public boolean selectEmp(String user_nm, String emp_serial) {
		int t = session.selectOne("member.selectEmp", emp_serial);
		if(t == 1) return true;
		return false;
	}//회원가입전 이름, 사원번호 확인

	@Override
	public boolean selectEmp1(String user_nm, String emp_serial) {
		int t = session.selectOne("member.selectEmp1", emp_serial);
		if(t == 1) return true;
		return false;
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
	public boolean selectEmp2(HashMap<String, String> map) {
		int t = session.selectOne("member.selectEmp2", map);
		if(t == 1) return true;
		return false;
	}

	@Override
	public MemberVO select(int user_no) {
		// TODO Auto-generated method stub
		return null;
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

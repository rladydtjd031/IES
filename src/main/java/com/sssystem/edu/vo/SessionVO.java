package com.sssystem.edu.vo;

public class SessionVO {
	private int user_no;
	private String user_nm;
	private int dept_no;
	private int job_no;
	private int admin_yn;
	private int manage_yn;
	
	public SessionVO() {
		// TODO Auto-generated constructor stub
	}

	public SessionVO(int user_no, String user_nm, int dept_no, int job_no,
			int admin_yn, int manage_yn) {
		super();
		this.user_no = user_no;
		this.user_nm = user_nm;
		this.dept_no = dept_no;
		this.job_no = job_no;
		this.admin_yn = admin_yn;
		this.manage_yn = manage_yn;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public int getJob_no() {
		return job_no;
	}

	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}

	public int getAdmin_yn() {
		return admin_yn;
	}

	public void setAdmin_yn(int admin_yn) {
		this.admin_yn = admin_yn;
	}

	public int getManage_yn() {
		return manage_yn;
	}

	public void setManage_yn(int manage_yn) {
		this.manage_yn = manage_yn;
	}

	@Override
	public String toString() {
		return "SessionBean [user_no=" + user_no + ", user_nm=" + user_nm
				+ ", dept_no=" + dept_no + ", job_no=" + job_no + ", admin_yn="
				+ admin_yn + ", manage_yn=" + manage_yn + "]";
	}
}

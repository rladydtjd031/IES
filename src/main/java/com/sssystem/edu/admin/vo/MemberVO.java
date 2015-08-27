package com.sssystem.edu.admin.vo;

import java.util.Date;

public class MemberVO {
  private int user_no;
  private String user_pwd;
  private String user_nm;
  private String emp_serial;
  private Date birth_dt;
  private String gender_yn;
  private int dept_no;
  private String dept_nm;
  private int job_no;
  private String job_nm;
  private String user_id;
  private String line_no;
  private String phone_no;
  private String second_no;
  private String post;
  private String address;
  private String email;
  private String profil_picture;
  private String admin_yn;
  private String manage_yn;
  private Date hiredate;
  private Date input_dt;
  
  public MemberVO() {
  }

  public MemberVO(int user_no,String user_pwd, String user_nm, String emp_serial,
      Date birth_dt, String gender_yn, int dept_no, String dept_nm,
      int job_no, String job_nm, String user_id, String line_no,
      String phone_no, String second_no, String post, String address,
      String email, String profil_picture, String admin_yn,
      String manage_yn, Date hiredate, Date input_dt) {
    super();
    this.user_no = user_no;
    this.user_nm = user_nm;
    this.emp_serial = emp_serial;
    this.birth_dt = birth_dt;
    this.gender_yn = gender_yn;
    this.dept_no = dept_no;
    this.dept_nm = dept_nm;
    this.job_no = job_no;
    this.job_nm = job_nm;
    this.user_id = user_id;
    this.line_no = line_no;
    this.phone_no = phone_no;
    this.second_no = second_no;
    this.post = post;
    this.address = address;
    this.email = email;
    this.profil_picture = profil_picture;
    this.admin_yn = admin_yn;
    this.manage_yn = manage_yn;
    this.hiredate = hiredate;
    this.input_dt = input_dt;
  }
  
  public String getUser_pwd() {
	    return user_nm;
	  }

	  public void setUser_pwd(String user_pwd) {
	    this.user_nm = user_nm;
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

  public String getEmp_serial() {
    return emp_serial;
  }

  public void setEmp_serial(String emp_serial) {
    this.emp_serial = emp_serial;
  }

  public Date getBirth_dt() {
    return birth_dt;
  }

  public void setBirth_dt(Date birth_dt) {
    this.birth_dt = birth_dt;
  }

  public String getGender_yn() {
    return gender_yn;
  }

  public void setGender_yn(String gender_yn) {
    this.gender_yn = gender_yn;
  }

  public int getDept_no() {
    return dept_no;
  }

  public void setDept_no(int dept_no) {
    this.dept_no = dept_no;
  }

  public String getDept_nm() {
    return dept_nm;
  }

  public void setDept_nm(String dept_nm) {
    this.dept_nm = dept_nm;
  }

  public int getJob_no() {
    return job_no;
  }

  public void setJob_no(int job_no) {
    this.job_no = job_no;
  }

  public String getJob_nm() {
    return job_nm;
  }

  public void setJob_nm(String job_nm) {
    this.job_nm = job_nm;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getLine_no() {
    return line_no;
  }

  public void setLine_no(String line_no) {
    this.line_no = line_no;
  }

  public String getPhone_no() {
    return phone_no;
  }

  public void setPhone_no(String phone_no) {
    this.phone_no = phone_no;
  }

  public String getSecond_no() {
    return second_no;
  }

  public void setSecond_no(String second_no) {
    this.second_no = second_no;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getProfil_picture() {
    return profil_picture;
  }

  public void setProfil_picture(String profil_picture) {
    this.profil_picture = profil_picture;
  }

  public String getAdmin_yn() {
    return admin_yn;
  }

  public void setAdmin_yn(String admin_yn) {
    this.admin_yn = admin_yn;
  }

  public String getManage_yn() {
    return manage_yn;
  }

  public void setManage_yn(String manage_yn) {
    this.manage_yn = manage_yn;
  }

  public Date getHiredate() {
    return hiredate;
  }

  public void setHiredate(Date hiredate) {
    this.hiredate = hiredate;
  }

  public Date getInput_dt() {
    return input_dt;
  }

  public void setInput_dt(Date input_dt) {
    this.input_dt = input_dt;
  }

  @Override
  public String toString() {
    return "MemberBean [user_no=" + user_no + ", user_nm=" + user_nm
        + ", emp_serial=" + emp_serial + ", birth_dt=" + birth_dt
        + ", gender_yn=" + gender_yn + ", dept_no=" + dept_no
        + ", dept_nm=" + dept_nm + ", job_no=" + job_no + ", job_nm="
        + job_nm + ", user_id=" + user_id + ", line_no=" + line_no
        + ", phone_no=" + phone_no + ", second_no=" + second_no
        + ", post=" + post + ", address=" + address + ", email="
        + email + ", profil_picture=" + profil_picture + ", admin_yn="
        + admin_yn + ", manage_yn=" + manage_yn + ", hiredate="
        + hiredate + ", input_dt=" + input_dt + "]";
  }
}

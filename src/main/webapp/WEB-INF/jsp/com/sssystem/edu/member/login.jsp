<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@taglib uri= "http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri= "http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri= "http://struts.apache.org/tags-logic" prefix="logic" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사내교육시스템 - 로그인</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/login.css">

<script type="text/javascript">
function FormChkModule(f){
	if(f.id.value==""){
		alert("아이디를 입력하세요!!");
		f.id.focus();
		return false;
	}
	if(f.pass.value==""){
		alert("비밀번호를 입력하세요!!");
		f.pass.focus();
		return false;
	}
	return true;
}//FormChkModule
$(function(){
	document.frmLogin.id.focus();
});
</script>
<!-- <html:messages id="msg" message="true"> Action의 GLOBAL_MESSAGE와 mapping
	<script type="text/javascript">alert('<bean:write name ="msg"/>');</script>
</html:messages>
<html:messages id= "msg" property ="errid">
	<script type="text/javascript">alert('<bean:write name="msg"/>');</script>
</html:messages>
<html:messages id= "msg" property ="errpass">
	<script type="text/javascript">alert('<bean:write name="msg"/>');</script>
</html:messages> -->
</head>

<body>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1><a href="login" class="logo hid_txt" tabindex="1">사내교육시스템</a></h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->
		<div id="content">
			<form id="frmLogin" name="frmLogin" target="_top" AUTOCOMPLETE="off" action="loginAccess" method="post" onsubmit="return FormChkModule(this)">
			<fieldset class="login_form">
			<legend class="blind">로그인</legend>
				<div class="input_row" id="id_area">
					<span class="input_box">
						<label for="id" id="label_id_area" class="lbl">아이디</label>
						<input type="text" id="id" name="id" tabindex="7" accesskey="L" placeholder="아이디" class="int" maxlength="20" value="">
					</span>
				</div>
				<div class="input_row" id="pw_area">
					<span class="input_box">
						<label for="pw" id="label_pw_area" class="lbl" >비밀번호</label>
						<input type="password" id="pw" name="pass" tabindex="8" placeholder="비밀번호" class="int" maxlength="20">
					</span>
				</div>
				<div class="btn_login">
					<input type="submit" title="로그인" alt="로그인" tabindex="12" value="login">
				</div>
			</fieldset>
			</form>
			<div class="find_info">
				<a href="findIdCheck" onclick="">아이디 찾기</a> / <a href="findPasswordCheck" onclick="">비밀번호 찾기</a> <span class="bar">|</span> <a href="joinCheck">회원가입</a>
			</div>
		</div>
	</div>
</div>
</body>
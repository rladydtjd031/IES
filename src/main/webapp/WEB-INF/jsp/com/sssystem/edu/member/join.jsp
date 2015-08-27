<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${deptjob == null }">
	<c:redirect url="/member/check.do"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사내교육시스템 - 회원가입</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/iessvn/js/postSearch.js"></script>
<script type="text/javascript" src="/iessvn/js/ajax.js"></script>
<script type="text/javascript" src="/iessvn/js/common.js"></script>
<script type="text/javascript" src="/iessvn/js/formcheck.js"></script>
<link rel="stylesheet" type="text/css" href="join.css">
<html:messages id="msg" property="errors">
<script type="text/javascript">alert('<bean:write name="msg" />');</script>
</html:messages>
</head>
<body>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1><a href="login.do" class="logo hid_txt" tabindex="1">사내교육시스템</a></h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->	
		<div id="content">
			<form id="frmjoin" name="frmjoin" target="_top" AUTOCOMPLETE="off" novalidate action="joinAction.do" method="post" onsubmit="return joinFormCheck(this);">
			<input type="hidden" name="user_no" value="${member.user_no }" required />
			<input type="hidden" name="idDup" id="idDup" required />
			<input type="hidden" name="pwdChk" value="false" required />
			<fieldset class="join_form">
			<legend class="blind">회원가입</legend>
				<div class="dep_info">
					<h2>부서</h2>
					<span>${deptjob.DEPT_NM } / ${deptjob.JOB_NM }</span>
				</div>
				<div class="row_group">
					<div class="join_row" id="idDiv">
						<input type="text" class="int" placeholder="아이디" maxlength="18" value="" name="user_id" id="id" required>
						
						<!-- class:error e_info, error, error gm -->
						<div class="error" id="idMsg">6~18자리의 영문/숫자 조합</div>
					</div>				
					<div class="join_row" id="pswd1Div">
						<input type="password" class="int" placeholder="비밀번호" maxlength="18" name="user_pwd" id="pswd1" required>				
						<div class="error" id="pswd1Msg">6~18자리의 영문/숫자 조합</div>
					</div>
					<div class="join_row" id="pswd2Div">
						<input type="password" class="int" placeholder="비밀번호 확인" maxlength="16" name="user_pwd2" id="pswd2" required>
						<div class="error" id="pswd2Msg">비밀번호가 일치하지 않습니다.</div>
					</div>
				</div>
				<!-- USER INFO -->
				<div class="row_group">
					<div class="join_row" id="linenumDiv">
						<c:set var="line_no" value="${member.line_no }" />
						<c:if test="${fn:indexOf(line_no, '-') == -1 }">
							<c:set var="lineno1" value="${line_no }" />
							<c:set var="lineno2" value="" />
							<c:set var="lineno3" value="" />
						</c:if>
						<c:if test="${fn:indexOf(line_no, '-') > -1 }">
						<c:set var="linenum" value="${fn:split(line_no, '-') }"></c:set>
						<c:forEach var="lineno" items="${linenum }" varStatus="l">
							<c:if test="${l.count == 1}"><c:set var="lineno1" value="${lineno }" /></c:if>
							<c:if test="${l.count == 2}"><c:set var="lineno2" value="${lineno }" /></c:if>
							<c:if test="${l.count == 3}"><c:set var="lineno3" value="${lineno }" /></c:if>
						</c:forEach>
						</c:if>
						<div class="linenum1">
							<input type="number" max="9999" class="int num_only" placeholder="내선번호" value="${lineno1 }" maxlength="3" name="line_no1" id="linenum1" required>
						</div>
						<span class="cell">-</span>
						<div class="linenum2">
							<input type="number" max="9999" class="int num_only" placeholder="" value="${lineno2 }" maxlength="4" name="line_no2" id="linenum2" required>
						</div>
						<span class="cell">-</span>
						<div class="linenum3">
							<input type="number" max="9999" class="int num_only" placeholder="" value="${lineno3 }" maxlength="4" name="line_no3" id="linenum3" required>
						</div>
					</div>
					<div class="join_row" id="cellnumDiv">
						<c:set var="phone_no" value="${member.phone_no }" />
						<c:if test="${fn:indexOf(phone_no, '-') == -1 }">
							<c:set var="phoneno1" value="${line_no }" />
							<c:set var="phoneno2" value="" />
							<c:set var="phoneno3" value="" />
						</c:if>
						<c:if test="${fn:indexOf(phone_no, '-') > -1 }">
						<c:set var="phonenum" value="${fn:split(phone_no, '-') }"></c:set>
						<c:forEach var="phoneno" items="${phonenum }" varStatus="p">
							<c:if test="${p.count == 1}"><c:set var="phoneno1" value="${phoneno }" /></c:if>
							<c:if test="${p.count == 2}"><c:set var="phoneno2" value="${phoneno }" /></c:if>
							<c:if test="${p.count == 3}"><c:set var="phoneno3" value="${phoneno }" /></c:if>
						</c:forEach>
						</c:if>
						<div class="cellnum1">
							<input type="number" max="9999" class="int num_only" placeholder="휴대폰번호" value="${phoneno1 }" maxlength="3" name="phone_no1" id="cellnum1" required>
						</div>
						<span class="cell">-</span>
						<div class="cellnum2">
							<input type="number" max="9999" class="int num_only" placeholder="" value="${phoneno2 }" maxlength="4" name="phone_no2" id="cellnum2" required>
						</div>
						<span class="cell">-</span>
						<div class="cellnum3">
							<input type="number" max="9999" class="int num_only" placeholder="" value="${phoneno3 }" maxlength="4" name="phone_no3" id="cellnum3" required>
						</div>
					</div>
					<div class="join_row" id="secnumDiv">
						<c:set var="second_no" value="${member.second_no }" />
						<c:if test="${fn:indexOf(second_no, '-') == -1 }">
							<c:set var="secondno1" value="${second_no }" />
							<c:set var="secondno2" value="" />
							<c:set var="secondno3" value="" />
						</c:if>
						<c:if test="${fn:indexOf(second_no, '-') > -1 }">
						<c:set var="secondnum" value="${fn:split(second_no, '-') }"></c:set>
						<c:forEach var="secondno" items="${secondnum }" varStatus="s">
							<c:if test="${s.count == 1}"><c:set var="secondno1" value="${secondno }" /></c:if>
							<c:if test="${s.count == 2}"><c:set var="secondno2" value="${secondno }" /></c:if>
							<c:if test="${s.count == 3}"><c:set var="secondno3" value="${secondno }" /></c:if>
						</c:forEach>
						</c:if>
						<div class="secnum1">
							<input type="number" max="9999" class="int num_only" placeholder="비상연락망" value="${secondno1 }" maxlength="3" name="second_no1" id="secnum1">
						</div>
						<span class="cell">-</span>
						<div class="secnum2">
							<input type="number" max="9999" class="int num_only" placeholder="" value="${secondno2 }" maxlength="4" name="second_no2" id="secnum2">
						</div>
						<span class="cell">-</span>
						<div class="secnum3">
							<input type="number" max="9999" class="int num_only" placeholder="" value="${secondno3 }" maxlength="4" name="second_no3" id="secnum3">
						</div>
					</div>
					<div class="join_row join_addr" id="addrDiv">
						<input type="tel" class="int" placeholder="우편번호" value="${member.post }" pattern="\d{3}\-\d{3}" title="000-000" maxlength="4" name="post" id="addrcode" readonly="true" required>
						<a class="btn_search" href="javascript:execDaumPostcode();">우편번호 찾기</a>
						<input type="text" class="int" placeholder="주소" value="${member.address }" maxlength="100" name="address" id="addr" required>
					</div>
					<div class="join_row" id="emailDiv">
						<c:set var="email" value="${member.email }" />
						<c:if test="${fn:indexOf(email, '@') == -1 }">
							<c:set var="email1" value="${email }" />
							<c:set var="email2" value="" />
						</c:if>
						<c:if test="${fn:indexOf(email, '@') > -1 }">
						<c:set var="splitEmail" value="${fn:split(email, '@') }"></c:set>
						<c:forEach var="emailaddr" items="${splitEmail }" varStatus="e">
							<c:if test="${e.count == 1}"><c:set var="email1" value="${emailaddr }" /></c:if>
							<c:if test="${e.count == 2}"><c:set var="email2" value="${emailaddr }" /></c:if>
						</c:forEach>
						</c:if>					
						<div class="emaild1">
							<input type="text" class="int"  placeholder="이메일" value="${email1 }" maxlength="50" name="email1" id="email1">
						</div>
						<span class="cell">@</span>
						<div class="emaild2">
							<input type="text" class="int" placeholder="" value="${email2 }" maxlength="50" name="email2" id="email2">
						</div>
					</div>
				</div>

				<div class="btn_join">
					<input type="submit" name="join" title="회원가입" alt="회원가입" tabindex="12" value="Join!">
				</div>
			</fieldset>
			</form>
		</div>
	</div>
</div>
</body>
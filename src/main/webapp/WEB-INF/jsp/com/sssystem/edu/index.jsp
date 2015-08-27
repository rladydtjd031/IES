<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<logic:notPresent scope="session" name="user">
<%-- <c:redirect url="/member/login.do" ></c:redirect> --%>
</logic:notPresent>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link href='${initParam.root }/fullcalendar-2.3.2/fullcalendar.css' rel='stylesheet' />
<link href='${initParam.root }/fullcalendar-2.3.2/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src='${initParam.root }/fullcalendar-2.3.2/lib/moment.min.js'></script>
<script src='${initParam.root }/fullcalendar-2.3.2/fullcalendar.min.js'></script>
<script type="text/javascript" src="${initParam.root }/js/fullcalendar.js"></script>

<link rel="stylesheet" type="text/css" href="index.css" />
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    $( "#summary" ).sortable({
        revert: true
      });
      $( "dl, dd" ).disableSelection();
});
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<section id="cen">
				<div id="top">
					<div id="userInfo" class="left">
					<dl>
						<dt class="prfl_thmb">
						<img src="/iessvn/images/iu.jpg" />
						<div class="mask"></div>
						</dt>
						<dd><em>${user.user_nm }</em> 님</dd>
						<dd>회원정보수정 | <a href="/iessvn/member/login.do" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a></dd>
					</dl>
					<p>출석수<span>${log }</span></p>
					<p>교육이수<span></span></p>
					<p>교육예정<span></span></p>
					<p>게시글수<span>${write }</span></p>
					<p>질문수<span>${question }</span></p>
					<p>댓글수<span>${reply }</span></p>
					</div>
					<div id="imgSection" class="right">
						<img src="/iessvn/images/5.png" alt="공간절약" />
					</div>
				</div>
				<div id="mid">
					<p><span class="title">공지사항</span>
					${notice } </p>
				</div>
				<div id="bot">
					<div id="calendar" class="left"><div id="calendar"></div></div>
					<div id="summary" class="right">
						<dl>
							<dt>최근 이수 교육</dt>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
						</dl>
						<dl>
							<dt>이수 예정 교육</dt>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
							<dd>영어 초급 교육 1</dd>
						</dl>
						<dl>
							<dt>나의 질문</dt>
							<c:forEach var="title" items="${myWriteView }">
							<dd>${title }</dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>나의 게시글</dt>
							<c:forEach var="title" items="${myQuestionView }">
							<dd>${title }</dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>나의 댓글</dt>
							<c:forEach var="contents" items="${replyContents }">
							<dd>${contents }</dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>건의사항</dt>
							<c:forEach var="qnaBoard" items="${recommendView }">
							<dd>${qnaBoard }</dd>
							</c:forEach>
						</dl>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
	
</body>
</html>



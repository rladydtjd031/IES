<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>사내교육시스템 - 아이디찾기</title>
	<link rel="stylesheet" type="text/css" href="${initParam.root }/css/search.css">
</head>
<body>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1>${user_nm }님의 아이디</h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->
		<div id="content">
			<ul class="search_id">
				<li class="li_tit">아이디</li>
				<li class="li_con">${id }</li>
			</ul>
			<a class="link" href="login">확인</a>
		</div>
	</div>
</div>
</body>
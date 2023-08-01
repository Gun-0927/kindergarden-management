<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<link rel="stylesheet" href="../css/styles.css">
	<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<body>
	<% if(session.getAttribute("id")==null) { //로그인 상태 확인, 로그아웃 된 상태 %>
		<div class="login-form" >
		<form action="../login/Login.do" method="post" name="LoginForm"> 
			<input type="text" name="id" class="text-field" placeholder="아이디">
			<input type="password" name="password" class="text-field" placeholder="비밀번호">
			<input type="submit" value="로그인" class="submit-btn">
		</form>
		<div class="links">
			<a href="LoginIdSearch.jsp">아이디 찾기</a>
			<a href="LoginPasswordSearch.jsp">비밀번호 찾기</a>
			<a href="LoginSelect.jsp">회원가입</a>
		</div>
	</div>

	<% } else { //로그인 된 상태 %>
	<% 		response.sendRedirect("../Project/MainPage.jsp"); %>
	<% } %>
	
	
	
</body>
</html>
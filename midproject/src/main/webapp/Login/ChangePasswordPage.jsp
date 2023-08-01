<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<link rel="stylesheet" href="../css/styles.css">
	<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<body>
	<div class="login-form">
	  	<p>변경할 비밀번호를 입력하세요</p>
	  	<form action="<%= request.getContextPath() %>/login/ChangePassword.do" method="post" name="LoginForm">
			<div id="parent-info">
		        <input type="password" name="password" class="text-field" placeholder="비밀번호">
		        <input type="password" name="password2" class="text-field" placeholder="비밀번호 확인">
		        <input type="submit" name="signup" value="비밀번호변경">
			</div>
		</form>
		<div class="links">
			<a href="LoginForm.jsp">로그인</a>
			<a href="LoginIdSearch.jsp">아이디 찾기</a>
			<a href="LoginPasswordSearch.jsp">비밀번호 찾기</a>
	    </div>
	</div>
</body>
</html>

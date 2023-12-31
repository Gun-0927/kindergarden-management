<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
	<link rel="stylesheet" href="../css/styles.css">
	<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<body>
	<div class="login-form" >
		<form action="<%= request.getContextPath() %>/login/idcheck.do" method="post" name="LoginForm">
			<input type="text" name="name" class="text-field" placeholder="이름">
			<input type="text" name="regnum" class="text-field" placeholder="주민등록번호" style="width:124px"> -
	        <input type="password" name="regnum2" class="text-field" placeholder="뒷자리" style="width:124px">
			<input type="submit" value="아이디 찾기" class="submit-btn">
		</form>
		<div class="links">
			<a href="LoginForm.jsp">로그인</a>
			<a href="LoginPasswordSearch.jsp">비밀번호 찾기</a>
			<a href="LoginSelect.jsp">회원가입</a>
		</div>
	</div>
</body>
</html>
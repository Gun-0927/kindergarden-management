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
		<h2>어떤 사용자로<br>가입 하시겠습니까?</h2>
	  	<form name="logupbar"> 
		    <input type="checkbox" name="chk_info" value="Teacher" onclick="window.location.href='LoginSelectTeacher.jsp';">교사 회원
			<input type="checkbox" name="chk_info" value="Parent" onclick="window.location.href='LoginSelectParent.jsp';">학부모 회원
	</div>
</body>
</html>

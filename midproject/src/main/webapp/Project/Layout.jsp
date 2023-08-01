<%@page import="utils.AlertFunc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="Layout.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<body>
    <img src="sun.jpg" alt="image" style="width: 200px; height: 150px; border-radius: 20px" onclick="location.href='MainPage.jsp';">
    <span class="user-info">
	    <div class="user-name">
	    	<br>
	    	<br>
	    	<%=session.getAttribute("name") %> 회원님, 환영합니다.
	    	<br>
	        <button>개인정보 수정</button>
	        <button onclick="location.href='../login/Logout.do';">로그아웃</button>
	    </div>
    </span>
	<header class="logo">
            <span style="font-size: 4em;">원생 관리 시스템</span>
            <a href="MainPage.jsp"></a>
    </header>
    <aside class="sidebar" style="display: inline-block; width: 200px;">
        <h2>카테고리</h2>
        <a href="MainPage.jsp" class="category-link <%= (request.getRequestURI().endsWith("MainPage.jsp")) ? "active" : "" %>">홈</a>
        <a href="Notice.jsp" class="category-link <%= (request.getRequestURI().endsWith("Notice.jsp")) ? "active" : "" %>">공지사항</a>
        <a href="Board.jsp" class="category-link <%= (request.getRequestURI().endsWith("Board.jsp")) ? "active" : "" %>">알림장</a>
        <a href="Album.jsp" class="category-link <%= (request.getRequestURI().endsWith("Album.jsp")) ? "active" : "" %>">앨범</a>
        <a href="Calendar.jsp" class="category-link <%= (request.getRequestURI().endsWith("Calendar.jsp")) ? "active" : "" %>">일정표</a>
        <a href="ClassInfo.jsp" class="category-link <%= (request.getRequestURI().endsWith("ClassInfo.jsp")) ? "active" : "" %>">반정보</a>
    </aside>
<%-- <% if(session.getAttribute("id")==null) { //로그인 상태 확인, 로그아웃 된 상태 %>  --%>
<%-- 		<%AlertFunc.alertLocation("로그인을 해주세요.", "../Login/LoginForm.jsp", out); %> --%>
<%-- 	<% } else { //로그인 된 상태%> --%>
<%-- 	<%	}%> --%>
</body>
</html>
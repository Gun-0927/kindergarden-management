<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>공지사항</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


<style type="text/css">
table {
	width: 70% !important;
	margin-left: 15%;
	margin-right: 25%;
}
</style>

</head>
<body>
	<jsp:include page="/Board/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<h2 style="text-align: center;">공지사항</h2>
	<table class="table table-bordered">
		<tr class="top">
			<td>작성자</td>
			<td>${dto.writerid}</td>
			<td>작성날짜</td>
			<td>${dto.write_date}</td>
			<td>조회수</td>
			<td>${dto.count}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${dto.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3">${dto.content}</td>
		</tr>
		<tr>
			<td colspan="4" align="center">

				<button type="button"
					onclick="location.href='../board/edit.do?boardnum=${dto.boardnum}';">
					수정하기</button>
				<button type="button"
					onclick="location.href='../board/delete.do?boardnum=${dto.boardnum}';">
					삭제하기</button>
				<button type="button" onclick="location.href='../board/list.do';">
					목록 바로가기</button>
			</td>
		</tr>
	</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"
		integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
		crossorigin="anonymous"></script>
</body>
</html>










<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>알림장</title>
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
	<h2>알림장</h2>
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
			<td>첨부파일</td>
		</tr>
		<c:forEach items="${cdtoList}" var="cdto">
			<tr>
				<td>댓글작성자</td>
				<td>${cdto.id}</td>
				<td>댓글내용</td>
				<td>${cdto.content}</td>
				<td>작성 일자</td>
				<td>${cdto.write_date}</td>
			</tr>

		</c:forEach>
		<tr>
		<tr>
			<form method="post" name="form1"
				action="WriteCom.do?boardnum=${dto.boardnum}">
				<td>댓글쓰기</td>
				<td><input type="text" name="commentContent"
					style="width: 150px;" /></td>
				<td><input type="submit" value="작성하기" /></td>
			</form>
		</tr>
		<td colspan="4" align="center">
			<button type="button"
				onclick="location.href='../board/edit2.do?boardnum=${dto.boardnum}';">
				수정하기</button>
			<button type="button"
				onclick="location.href='../board/delete2.do?boardnum=${dto.boardnum}';">
				삭제하기</button>
			<button type="button" onclick="location.href='../board/list2.do';">
				목록 바로가기</button>
		</td>
		</tr>
	</table>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"
		integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8="
		crossorigin="anonymous"></script>
	</div>
</body>
</html>
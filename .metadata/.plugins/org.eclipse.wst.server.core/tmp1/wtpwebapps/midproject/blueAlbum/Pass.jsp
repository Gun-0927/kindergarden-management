<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>비밀번호 검증</title>
</head>
<body>
	<jsp:include page="/blueAlbum/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<h2 style="text-align: center;">비밀번호 검증</h2>
	<form action="../albumBoard/pass.do" method="post" name="writeForm">
		<input type="hidden" name="alnum" value="${param.alnum}" /> <input
			type="hidden" name="mode" value="${param.mode}" />
		<table border="1" style="border-color: #1BBC9B; border-style: solid; border-collapse: collapse; text-align: center; width: 100%;">
			<tr>
				<td>비밀번호</td>
				<td><input type="number" name="pass" style="width: 100px"
					required /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">검증하기</button>
					<button type="reset">초기화</button>
					<button type="button"
						onclick="location.href='../albumBoard/list.do';">목록 돌아가기
					</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
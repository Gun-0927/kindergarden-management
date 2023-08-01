<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>수정 화면</title>
</head>
<body>
	<jsp:include page="/blueAlbum/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<h2 style="text-align: center;">수정하기</h2>
	<form action="../albumBoard/edit.do" method="post" name="writeForm"
		enctype="multipart/form-data">
		<input type="hidden" name="alnum" value="${dto.alnum}" /> <input
			type="hidden" name="preOfile" value="${dto.imgName}" /> <input
			type="hidden" name="preNfile" value="${dto.nfile}" />
		<table border="1" style="border-color: #1BBC9B; border-style: solid; border-collapse: collapse; text-align: center; width: 100%;">
			<tr>
				<td>번호</td>
				<td>${dto.alnum}</td>
				<td>작성자</td>
				<td>${dto.teacherId}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${dto.writeDate}</td>
				<td>조회수</td>
				<td>${dto.count}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 90%;"
					value="${dto.title}" /></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><img
					src="<%=request.getContextPath()%>/Storage/${dto.nfile}"
					width="100px" height="200px" /></td>
			</tr>
			<tr>
				<td>첨부 파일</td>
				<td><input type="file" name="ofile" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">작성완료</button>
					<button type="reset">초기화</button>
					<button type="button"
						onclick="location.href='../albumBoard/list.do';">목록바로가기</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
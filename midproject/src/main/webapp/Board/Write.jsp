<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>글 작성</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style type="text/css">
table {
	width: 50% !important;
	margin-left: 25%;
	margin-right: 25%;
}
</style>
</head>
<body>
	<jsp:include page="/Board/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<br>
	<h2 style="text-align: center;">글 작성</h2>
	<br>

	<form action="../board/write.do" method="post" name="writeForm"">
		<table class="table table-bordered">
			<tr>
				<th scope="col">작성 위치</th>
				<td>
					<%
					String boardkind = request.getParameter("boardkind");
					%> <select id="WRITING_LOCATION" name="boardkind" size="1"
					onchange="if(this.value=='1') location.href='Write2.jsp?boardkind=1'">
						<option value="">작성 위치를 선택하세요.</option>
						<option value="0" <%if ("0".equals(boardkind)) {%> selected
							<%}%>>공지사항</option>
						<option value="1" <%if ("1".equals(boardkind)) {%> selected
							<%}%>>알림장</option>
				</select> <script>
					function changeLocation(value) {
						if (value === '1') {
							location.href = 'Write2.jsp?boardkind=1';
						}
					}
				</script>

				</td>
			</tr>
			<tr>
				<th scope="col">제목</th>
				<td><input type="text" name="title" style="width: 90%;" /></td>
			</tr>

			<tr>
				<th scope="col">내용</th>
				<td><textarea name="content" style="width: 90%; height: 100px;"></textarea>
				</td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="submit">작성완료</button>
					<button type="reset">초기화</button>
					<button type="button" onclick="location.href='../board/list.do';">
						목록 바로가기</button>
					<button type="button"
						onclick="location.href='../Board/Enterance.jsp';">홈페이지 바로
						가기</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>반 신청</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style type="text/css">
table {
	width: 40% !important;
	margin-left: 25%;
	margin-right: 25%;
}
</style>
</head>
<body>
	<jsp:include page="/Board/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<h2 style="text-align: center;">반 신청</h2>
	<br>

	<form action="../classCheck/writeClass.do" method="post"
		name="writeForm"">
		<table class="table table-bordered">
			<tr>
				<td><input type="text" name="classnum" style="width: 10%;" />
				</td>
				<th scope="col">반</th>
			</tr>
			<tr>
				<td><input type="text" name="childname" style="width: 10%;" />
				</td>
				<th scope="col">학생</th>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="submit">반 신청하기</button>
					<button type="button"
						onclick="location.href='../classCheck/list3.do';">반 목록</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>작성 화면</title>
<!-- Add Bootstrap CSS for styling -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/blueAlbum/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<div class="container">
		<h1 class="text-center my-4">작성 화면</h1>
		<form method="post" action="../albumBoard/write.do"
			enctype="multipart/form-data">
			<input type="hidden" name="teacherid"
				value="<%=session.getAttribute("id")%>">
			<div class="form-group row">
				<label for="title" class="col-sm-2 col-form-label">제목:</label>

				<div class="col-sm-10">
					<input type="text" class="form-control" name="title" id="title"
						placeholder="제목을 입력하세요">
				</div>
			</div>
			<div class="form-group row">
				<label for="file" class="col-sm-2 col-form-label">파일:</label>
				<div class="col-sm-10">
					<input type="file" class="form-control-file" name="file" id="file"
						multiple>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10">
					<input type="submit" class="btn btn-primary" value="등록">
					<button type="reset" class="btn btn-secondary">초기화</button>
					<button type="button" class="btn btn-info"
						onclick="location.href='../albumBoard/list.do';">목록 바로가기
					</button>
				</div>
			</div>
		</form>
	</div>
	</div>
	<!-- Add Bootstrap and jQuery JS for functionality -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
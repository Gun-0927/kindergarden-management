<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Layout.jsp"></jsp:include>
<meta charset="UTF-8">
<title>자료 게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
	table{
		width : 50% !important;
		margin-left:25%; 
    	margin-right:25%;
		
	}
</style>
</head>
<body>
	<br><h2 style="text-align: center;">반 작성</h2><br>

	<form action="../../m2board/write2.do" method="post" name="writeForm"">
		<table class="table table-bordered">
			<tr>
				<th scope="col">반 이름</th>
				<td>
					<input type="text" name="classname" style="width:90%;" />
				</td>
			</tr>	
			<tr>
				<th scope="col">학생 이름</th>
				<td>		
					<input type="text" name="teachername" style="width:90%;" />
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="submit">반 설정하기</button>
					<button type="reset">초기화</button>
					<button type="button" onclick="location.href='List3.jsp';">반 목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>자녀정보</title>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<jsp:include page="/Project/Layout.jsp"></jsp:include>
	<div
		style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
		<br>
		<h2 style="text-align: center;">찾아보기</h2>
		<br>
		<form method="get" action="../board/find.do">
			<table class="table table-bordered ">
				<tr>
					<th scope="col">자녀 이름 검색</th>
					<td><select name="searchChname">
							<option value="chname"
								<c:if test="${map.searchChname=='chname'}">selected</c:if>>자녀
								이름</option>
					</select> <input type="search" name="searchValue" value="${map.searchValue}" />
						<input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>
		<table class="table table-bordered ">
			<tr>
				<th scope="col">
					<div style="max-height: 100px; overflow-y: auto;">
						<c:forEach items="${parentList}" var="parent">
							<input type="checkbox" name="parentId"
								value=" ${parent.chname}-${parent.id}">
			                ${parent.chname}/${parent.id}<br>
						</c:forEach>
					</div>
				</th>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="button">작성완료</button>
					<button type="reset">초기화</button>
				</td>
			</tr>
		</table>
	</div>
	<script>
		let checkedIds = []; // 선택된 체크박스의 id를 저장할 배열

		$('input[name=parentId]').change(function() {
			const selectedId = $(this).val();

			if ($(this).is(":checked")) {
				if (!checkedIds.includes(selectedId)) {
					checkedIds.push(selectedId);
				}
			} else {
				checkedIds = checkedIds.filter(function(id) {
					return id !== selectedId;
				})
			}
			;
			console.log(checkedIds);
		});

		$('button[type=button]').click(function() {
			// checkedIds 값을 서버로 전송합니다.
			$.ajax({
				url : "../board/write2.do",
				type : 'get',
				data : {
					checkedIds : JSON.stringify(checkedIds)
				},
				success : function() {
					// 성공적으로 서버에 값을 전송한 경우, 팝업창을 닫습니다.
					window.close();
				},
				error : function() {
					// 서버와 통신 중 에러가 발생한 경우, 에러 메시지를 표시합니다.
					alert('서버와 통신 중 에러가 발생했습니다.');
				}
			});
		});
	</script>
</body>
</html>
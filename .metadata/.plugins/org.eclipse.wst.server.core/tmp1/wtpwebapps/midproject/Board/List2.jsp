<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 부트스트랩 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>알림장</title>
<style>
a {
	text-decoration: none
}
</style>

</head>
<body>
	<jsp:include page="/Board/Layout.jsp"></jsp:include>
	<div style="border: 3px solid #b7d9df; border-radius: 20px; width: 1300px; height: auto; position: absolute; left: 310px;">
	<h2 style="text-align: center; color: green;">알림장</h2>
	<br>
	<br>
	<!-- 검색 -->
	<form method="get">
		<table width="100%">
			<tr align="right">
				<td><select name="searchType">
						<option value="title"
							<c:if test="${map.searchType=='title'}">selected</c:if>>제목
						</option>
						<option value="content"
							<c:if test="${map.searchType=='content'}">selected</c:if>>내용
						</option>
				</select> <input type="search" name="searchStr" value="${map.searchStr}" /> <input
					type="submit" value="검색" /></td>
			</tr>
		</table>
	</form>
	<!-- 목록 -->
	<table class="table table-bordered";>
		<thead>
			<tr>
				<th scope="col">작성 날짜</th>
				<th scope="col">글 번호</th>
				<th scope="col">글 제목</th>
				<th scope="col">작성자</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tboby> <c:choose>
			<c:when test="${empty boardList }">
				<tr>
					<td colspan="6" align="center">등록된 게시물이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${boardList}" var="list" varStatus="stat">
					<tr align="center">
						<td>${list.write_date}</td>
						<td>${map.totalCount-((map.pageNum-1)*map.pageSize)-stat.index}</td>
						<td align="center"><a
							href="../board/view2.do?boardnum=${list.boardnum}">${list.title}
						</a></td>
						<td>${list.writerid}</td>
						<td>${list.count}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose> <!--  하단 메뉴(페이징 글쓰기) -->
		<table width="100%">
			<tr align="center">
				<td>${map.pagingStr}</td>
				<td width="100">
					<form action="../Board/Write2.jsp?boardkind=1" method="post">
						<button type="submit">글쓰기</button>
					</form>
				</td>
			</tr>
		</table>
		</tbody>
	</table>
	</div>
</body>
</html>
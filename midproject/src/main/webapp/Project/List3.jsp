<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>반 설정</title>
<style>a{text-decoration: none}
.main-content {
  margin-left: 240px; /* aside 영역의 너비만큼 여백을 줌 */
}
</style>

</head>
<div class="main-content">
<body>
<a href="Enterance.jsp">메인화면으로 돌아가기</a>
  <h2 style="text-align : center; color: green;">반 설정하기</h2><br><br>
   <!-- 검색 -->
   <form method="get">
      <table  width="100%">
          <tr align="right">
            
         </tr>      
      </table>   
   </form>
   <!-- 목록 -->
      <table class="table table-bordered";>
      <thead>
      <tr>
         <th scope="col">반 이름</th>
         <th scope="col">선생님 이름</th>
         <th scope="col">학생 이름</th>
      </tr>      
      </thead>
 	<tbody>
<c:choose>
   <c:when test="${empty classList }">
      <tr>
         <td colspan="6" align="center">등록된 반이 없습니다.</td>
      </tr>
   </c:when>
   <c:otherwise>
      <c:forEach items="${classList}" var="list" varStatus="stat">
         <tr align="center">
         	<td>${list.classname}</td>
            <td>${list.teacherid}</td>
            <td>3</td>
         </tr>
      </c:forEach>
   </c:otherwise>
</c:choose>
   <!--  하단 메뉴(페이징 글쓰기) -->
   <table  width="100%">
      <tr align="center">
         <td>
         ${map.pagingStr}
         </td>
         <td width="100">
          <form action="WriteClass.jsp" method="post">
		    <button type="submit">반 추가</button>
		</form>
         </td>
      </tr>
   </table>
   </tbody>
   </table>
</body>
</div>
</html>
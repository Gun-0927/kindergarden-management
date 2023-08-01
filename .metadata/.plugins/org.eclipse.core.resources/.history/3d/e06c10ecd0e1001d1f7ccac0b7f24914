<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<link rel="stylesheet" href="../css/styles.css">
	<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<script>
function checkId() {
    const idInput = document.getElementsByName("id")[0];
    const idValue = idInput.value;
    
    // 아이디가 한글을 제외하고 10글자 이하인지 확인
    const isIdValid = /^[a-zA-Z0-9]{1,10}$/.test(idValue);
    if (!isIdValid) {
        alert("아이디는 영문자 또는 숫자로 1글자 이상, 10글자 이하로 입력해주세요.");
        return;
    }
    
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '../blueproject/duplicate.do', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                const result = xhr.responseText;
                if (result === "true") {
                    alert("이미 사용중인 아이디입니다.");
                } else {
                    const apply = confirm("사용 가능한 아이디입니다. 사용하시겠습니까?");
                    if (apply) {
                        idInput.readOnly = true;
                        idInput.style.backgroundColor = 'lightgray';
                        idInput.style.width = '260px';
                        document.getElementById("button-wrapper").style.display = "none";
                    }
                }
            } else {
                alert("서버 오류가 발생했습니다.");
            }
        }
    };
    xhr.send('id=' + encodeURIComponent(idValue));
}
</script>
<body>
	<div class="login-form">
	  	<p>정보를 입력해주세요</p>
	  	<form action="<%= request.getContextPath() %>/login/SignUp.do" method="post" name="LoginForm">
			<div id="parent-info">
		        <input type="text" name="name" class="text-field" placeholder="이름">
		        <input type="text" name="regnum" class="text-field" placeholder="주민등록번호" style="width:124px"> -
		        <input type="password" name="regnum2" class="text-field" placeholder="뒷자리" style="width:124px">
		        <input type="text" name="phonenum" class="text-field" placeholder="휴대폰 번호(- 제외)">
		        <input type="text" name="id" class="text-field" placeholder="아이디(영어, 최대 10글자)" style="width:215px"> <span id="button-wrapper"><button type="button" name="check" onclick="checkId()">체크</button></span>
		        <input type="password" name="password" class="text-field" placeholder="비밀번호">
		        <input type="password" name="password2" class="text-field" placeholder="비밀번호 확인">
		        <input type="text" name="addr" class="text-field" placeholder="주소">
		        <input type="text" name="email" class="text-field" placeholder="이메일">
		        <input type="submit" name="signup" value="회원가입">
			</div>
		</form>
		<div class="links">
			<a href="LoginForm.jsp">로그인</a>
			<a href="LoginIdSearch.jsp">아이디 찾기</a>
			<a href="LoginPasswordSearch.jsp">비밀번호 찾기</a>
	    </div>
	</div>
</body>
</html>

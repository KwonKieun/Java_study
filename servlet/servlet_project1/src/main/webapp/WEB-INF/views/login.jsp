<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<hr>
	<!-- id와 pw를 입력받아 서버로 전송하는 코드를 작성. post방식으로 전송 -->
	<form action="<%=request.getContextPath()%>/login" method="post">
		<label>id</label>
		<input type="text" name="id">
		<br>
		<label>pw</label>
		<input type="password" name="pw">
		<br>
		<button>로그인</button>
	</form>
</body>
</html>
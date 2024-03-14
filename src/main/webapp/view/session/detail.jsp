<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<h2>마이페이지</h2>
		<form action="/02_login/SessionController" method="post" autocomplete="off">
			<!-- EL을 사용하여 session에 저장된 데이터를 꺼내서 사용할 수 있다 -->
			<p>Name : ${svo.name}</p>
			<p>Email : ${svo.email}</p>
			<p>Addr : ${svo.addr}</p>
			<p>Phone : ${svo.phone}</p>
			<input type="submit" value="수정">
		</form>
	</body>
</html>
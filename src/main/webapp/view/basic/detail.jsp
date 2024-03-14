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
		<form action="/02_login/MyController" method="post" autocomplete="off">
			<p>Name : ${bvo.name}</p>
			<p>Email : ${bvo.email}</p>
			<p>Addr : ${bvo.addr}</p>
			<p>Phone : ${bvo.phone}</p>
			<input type="hidden" name="cmd" value="">
			<input type="submit" value="수정">
		</form>
	</body>
</html>
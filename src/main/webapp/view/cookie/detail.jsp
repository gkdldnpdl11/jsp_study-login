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
		<form action="/02_login/CookieController" method="post" autocomplete="off">
			<p>Name : ${cvo.name}</p>
			<p>Email : ${cvo.email}</p>
			<p>Addr : ${cvo.addr}</p>
			<p>Phone : ${cvo.phone}</p>
			<input type="hidden" name="cmd" value="">
			<input type="submit" value="수정">
		</form>
	</body>
</html>
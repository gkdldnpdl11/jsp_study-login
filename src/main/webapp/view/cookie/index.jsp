<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>홈페이지</title>
		<style type="text/css">
			.form{
				display: inline-block;
			}
		</style>
	</head>
	<body>
		<c:if test="${res==null}">	
			<form action="/02_login/CookieController" method="post" class="form">
				<input type="submit" value="로그인">
				<input type="hidden" name="cmd" value="c_login">
			</form>
			<form action="/02_login/CookieController" method="post" class="form">
				<input type="submit" value="회원가입">
				<input type="hidden" name="cmd" value="c_join">
			</form>
		</c:if>
		
		<c:if test="${res==1}">
			<span class="form">${cvo.name}님 환영합니다</span>
			<form action="/02_login/CookieController" method="post" class="form">
				<input type="submit" value="로그아웃">
				<input type="hidden" name="cmd" value="c_logout">
			</form>
			
			<form action="/02_login/CookieController" method="post" class="form">
				<input type="submit" value="마이페이지">
				
				<!-- 마이페이지 버튼 클릭시 3개의 hidden의 정보가 넘어감 -->
				
				<%-- 
					위의 코딩 2줄 대신에 서버에서 쿠키에 id, password 를 저장.
					<input type="hidden" name="id" value="${cvo.id}">
					<input type="hidden" name="pwd" value="${cvo.pwd}">
				--%>
				<input type="hidden" name="cmd" value="c_profile">
			</form>
		</c:if>
	</body>
</html>
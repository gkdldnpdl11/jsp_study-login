package com.ict.model.cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;

public class CookieLoginCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 쿠키는 서버에서 생성하고 브라우저에 응답하여 저장하도록 하는 데이터 조각이다
		// 브라우저는 저장된 쿠키를 해당 사이트에 자원 요청시 포함하여 전송한다
		// 다시 서버로 갈때는 쿠키정보를 가지고 간다
		// 브라우저가 사이트를 이용하면서 유지해야할 값이 있을때 사용하면 된다
		
		// 해당 사이트로 다시 요청할때는 쿠키도 함께 전송된다
		// 요청에 의해서 쿠키정보를 확인할 수 있다
		// 쿠키 구성 요소 :
		// 이름 : 쿠키이름
		// 값 : 이름과 연결된 값
		// 유효시간 : 초단위 시간 (일반적으로 세션유지 시간동안)
		// 도메인 : 쿠키를 생성한 서버(사이트)명
		
		// 쿠키 생성(uname=이름, ict=값)
		// Cookie cookie1 = new Cookie("uname", "ict");
		// Cookie cookie2 = new Cookie("upwd", "ict1212");
		
		// 유효 시간 조정 가능(초단위)
		// cookie1.setMaxAge(60*10);	// 10분간 쿠키 유지
		
		// 브라우저에 쿠키 저장 (쿠키는 브라우저가 가지고있기때문에 response)
		// response.addCookie(cookie1);
		// response.addCookie(cookie2);
		
		return "view/cookie/loginForm.jsp";
		
	}
}

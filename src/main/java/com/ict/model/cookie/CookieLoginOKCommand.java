package com.ict.model.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ict.db.cookie.CookieDAO;
import com.ict.db.cookie.CookieVO;
import com.ict.model.basic.Command;

public class CookieLoginOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 해당 사이트로 다시 요청할때는 쿠키도 함께 전송된다
		// 요청에 의해서 쿠키정보를 확인할 수 있다
		// 쿠키 구성 요소 :
		// 이름 : 쿠키이름
		// 값 : 이름과 연결된 값
		// 유효시간 : 초단위 시간 (일반적으로 세션유지 시간동안)
		// 도메인 : 쿠키를 생성한 서버(사이트)명
		
		// CookieLoginCommand 에서 집어넣은 쿠키를 받아서 확인
		/*
		 * Cookie cookies[]=request.getCookies(); String uname=null; String upwd=null;
		 * 
		 * // 쿠키가 존재할때만 실행 if (cookies != null && cookies.length>0) { for (int i = 0; i
		 * < cookies.length; i++) { // 쿠키가 가지고 잇는 것 중 이름이 uname인것
		 * if(cookies[i].getName().equals("uname")) { uname=cookies[i].getValue(); }
		 * if(cookies[i].getName().equals("upwd")) { upwd=cookies[i].getValue(); } } }
		 * System.out.println("uname : "+uname); System.out.println("upwd : "+upwd);
		 */
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		CookieVO cvo = new CookieVO();
		cvo.setId(id);
		cvo.setPwd(pwd);
		
		CookieVO cvo2= CookieDAO.getLogin(cvo);
		if (cvo2==null) {
			return "view/cookie/loginForm.jsp";
		} else {
			
			request.setAttribute("cvo", cvo2);
			request.setAttribute("res", 1);

			// 쿠키를 이용해서 id, password 생성
			Cookie c_id = new Cookie("id", cvo.getId());
			Cookie c_pwd = new Cookie("pwd", cvo.getPwd());
			
			// 생성한 쿠키를 이용하여 id, password 값 저장 
			response.addCookie(c_id);
			response.addCookie(c_pwd);
			
			return "view/cookie/index.jsp";
		}
		
	}
}

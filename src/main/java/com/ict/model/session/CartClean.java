package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartClean {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 카드 비우기 = session 전체 초기화(=삭제)
		// request.getSession().invalidate();
		
		// 특정 속성을 이용하여 저장한 객체 삭제
		request.getSession().removeAttribute("list");
		
		return "view/session_cart/session_cart.jsp";
	}
}

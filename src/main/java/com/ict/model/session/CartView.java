package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartView {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 카드보기는 클라이언트에게 보여주기 때문에 일처리 내용 없음
		return "view/session_cart/session_cart_view.jsp";
	}
}

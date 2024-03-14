package com.ict.model.session;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartAdd {
	// 카드에 담기
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String fruits = request.getParameter("fruits");
		HttpSession session = request.getSession();
		
		// 카드에 크기를 알 수 없으므로 컬렉션에 담아야한다
		// session 에 있는 list 호출
		ArrayList<String> list =
				// 기존의 장바구니에 추가로 담아야 하기 때문에 먼저 get으로 불러옴
				(ArrayList<String>) session.getAttribute("list");

		// 맨 처음 해당 페이지로 오면 session 에는 list 가 없다 (list==null)
		// 처음에 카드가 비어있으므로 새로운 리스트를 생성 > 처음에 왔을때만 리스트를 생성한다
		if (list==null) {
			list = new ArrayList<String>();
			session.setAttribute("list", list);
		}
		
		// 맨 처음 페이지가 없어서 리스트(페이지)생성 > 페이지 생성 후 리스트에 추가함
		// 처음에만 리스트 생성하고 그 다음부터는 만들어진 리스트를 사용해서 계속 사용한다

		// 리스트에 정보 추가
		list.add(fruits);
		
		return "view/session_cart/session_cart.jsp";
	}
}

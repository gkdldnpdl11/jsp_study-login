package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ict.model.basic.Command;

public class SessionProfileCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// session 에 저장된 "svo"를 꺼냄
		// HttpSession session = request.getSession();
		// SessionVO svo = (SessionVO) session.getAttribute("svo");
		
		// request.setAttribute("pwd", svo.getPwd());
		
		// EL을 사용하여 session에 저장된 데이터를 꺼내서 사용할 수 있다
		// 그래서 위에 처럼 꺼내서 저장하고 사용할 필요가 없다
		
		return "view/session/profile.jsp";
	}
}

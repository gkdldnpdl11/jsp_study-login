package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.basic.BasicDAO;
import com.ict.db.basic.BasicVO;

public class JoinOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입을 위한 파라미터값을 받아야함, 새로운 객체를 생성하여 파라미터값을 저장
		BasicVO bvo=new BasicVO();
		bvo.setId(request.getParameter("id"));
		bvo.setPwd(request.getParameter("pwd"));
		bvo.setName(request.getParameter("name"));
		bvo.setEmail(request.getParameter("email"));
		bvo.setAddr(request.getParameter("addr"));
		bvo.setPhone(request.getParameter("phone"));
		
		// insert 의 성공의 결과값은 1이기 때문에 int로 저장
		int result=BasicDAO.getJoin(bvo);
		
		if (result==1) {
			return "view/basic/loginForm.jsp";
		} else {
			return "view/basic/joinForm.jsp";
		}
	}
}

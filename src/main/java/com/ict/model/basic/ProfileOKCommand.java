package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.basic.BasicDAO;
import com.ict.db.basic.BasicVO;

public class ProfileOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		BasicVO bvo=BasicDAO.getDetail(id);
		// 아이디와 패스워드를 가지고 왔기 때문에 if문 사용할 필요가 없다
		request.setAttribute("bvo", bvo);
		
		return "view/basic/detail.jsp";
		
	}
}

package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.session.SessionDAO;
import com.ict.db.session.SessionVO;
import com.ict.model.basic.Command;

public class SessionLoginOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String id= request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		SessionVO svo = new SessionVO();
		svo.setId(id);
		svo.setPwd(pwd);
		
		SessionVO svo2= SessionDAO.getLogin(svo);
		
		if (svo2==null) {
			return "view/session/loginForm.jsp";
		} else {
			// session.setAttribute("이름", 값);		// 저장
			// session.getAttribute("이름");			// 호출
			// session.removeAttribute("이름");		// 이름만 삭제

			// 기타 주요 메소드
			// .getId() : 세션 고유의 ID 추출
			// .getCreationTime() : 세션이 생성된 시간 반환
			// .getLastAccessedTime() : 마지막에 접근한 시간 반환
			// .invalidate() : 세션 전체 초기화(=전체 삭제)
			// .setMaxInactiveInterval(시간) : 세션 시간 제한 (ex : 로그인 시간)
			
			// ** 생명 주기 : 제한 시간을 정하지 않으면 브라우저가 종료되면 세션의 데이터도 같이 사라진다
			
			// session을 만들어서 session을 저장
			HttpSession session = request.getSession();
			session.setAttribute("svo", svo2);
			
			return "view/session/index.jsp";
		}
	}
}

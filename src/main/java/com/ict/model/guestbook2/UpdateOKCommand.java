package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.GuestBook2DAO;
import com.ict.db.guestbook2.GuestBook2VO;
import com.ict.model.basic.Command;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateOKCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("upload");
			MultipartRequest mr = 
					new MultipartRequest(request, path, 100*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			GuestBook2VO g2vo = new GuestBook2VO();
			g2vo.setIdx(mr.getParameter("idx"));
			g2vo.setName(mr.getParameter("name"));
			g2vo.setSubject(mr.getParameter("subject"));
			g2vo.setContent(mr.getParameter("content"));
			g2vo.setEmail(mr.getParameter("email"));
			g2vo.setPwd(mr.getParameter("pwd"));
			
			String old_f_name = mr.getParameter("old_f_name");
			if (mr.getFile("f_name") == null) {
				// 업로드 한 파일이 없을 때
				g2vo.setF_name(old_f_name);
			} else {
				g2vo.setF_name(mr.getFilesystemName("f_name"));
			}
			
			int result = GuestBook2DAO.getUpdate(g2vo);
			if (result>0) {
				return "GuestBook2Controller?cmd=onelist&idx="+g2vo.getIdx();
			} else {
				return "view/guestbook2/error.jsp";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "view/guestbook2/error.jsp";
		}
	}
}

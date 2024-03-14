package com.ict.controller.guestbook2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;
import com.ict.model.guestbook2.DeleteCommand;
import com.ict.model.guestbook2.DeleteOKCommand;
import com.ict.model.guestbook2.ListCommand;
import com.ict.model.guestbook2.OneListCommand;
import com.ict.model.guestbook2.UpdateCommand;
import com.ict.model.guestbook2.UpdateOKCommand;
import com.ict.model.guestbook2.WriteCommand;
import com.ict.model.guestbook2.WriteOKCommand;

@WebServlet("/GuestBook2Controller")
public class GuestBook2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		
		Command comm = null;
		switch (cmd) {
			case "list" : comm = new ListCommand(); break;
			case "write" : comm = new WriteCommand(); break;
			case "write_ok" : comm = new WriteOKCommand(); break;
			case "onelist" : comm = new OneListCommand(); break;
			case "delete" : comm = new DeleteCommand(); break;
			case "delete_ok" : comm = new DeleteOKCommand(); break;
			case "update" : comm = new UpdateCommand(); break;
			case "update_ok" : comm = new UpdateOKCommand(); break;
		}
		
		String path= comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}

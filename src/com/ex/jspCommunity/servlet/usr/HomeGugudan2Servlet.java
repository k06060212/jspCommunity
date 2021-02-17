package com.ex.jspCommunity.servlet.usr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usr/home/gugudan2")
public class HomeGugudan2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(request.getParameter("dan") == null) {
			response.getWriter().append("dan을 입력해주세요.");
			return;
		}
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		int limit = 9;
		
		if (request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}
		
		request.setAttribute("dan", dan);
		request.setAttribute("limit", limit);
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/jsp/usr/home/gugudan2.jsp");
		rDispatcher.forward(request, response);
		
	}
	
}

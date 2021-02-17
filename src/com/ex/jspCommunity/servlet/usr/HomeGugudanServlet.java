package com.ex.jspCommunity.servlet.usr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usr/home/gugudan")
public class HomeGugudanServlet extends HttpServlet {

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
		
		response.getWriter().append("<div>"+String.format("구구단 %d단", dan)+"</d>");
		
		for (int i = 1; i <= limit; i++) {
			response.getWriter().append("<div>"+String.format("%d * %d = %d", dan, i, dan * i)+"</d>");
			
		}
	}
	
}

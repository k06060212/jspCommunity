package com.ex.jspCommunity.servlet.usr;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.mysqlutil.MysqlUtil;
import com.ex.mysqlutil.SecSql;

@WebServlet("/usr/member/list")
public class MemberListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MysqlUtil.setDBInfo("192.168.200.102", "gokuma", "gokuma123", "jspCommunity");
		
		List<Map<String, Object>> memberMapList = MysqlUtil.selectRows(new SecSql().append("SELECT * FROM member ORDER BY id DESC"));
//		System.out.println(memberMapList); 	//[{updateDate=2021-02-17T20:29:37, loginId=user2, adminLevel=2, loginPw=user2, name=세종대왕, nickname=한글세종대왕, regDate=2021-02-17T20:29:37, id=2, email=k06060212@gmail.com}, {updateDate=2021-02-17T20:29:37, loginId=user1, adminLevel=2, loginPw=user1, name=홍길동, nickname=의적홍길동, regDate=2021-02-17T20:29:37, id=1, email=k06060212@gmail.com}]
		MysqlUtil.closeConnection();
		
		request.setAttribute("memberMapList", memberMapList);
		
		request.getRequestDispatcher("/jsp/usr/member/list.jsp").forward(request, response);;
	}
	
}
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.Test;
import message.GetMessageCode;

public class SendEmail extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		//根据获取到的手机号发送验证码。
		String emailcode = Test.email(email);
		//request.getSession().setAttribute("email", emailcode);
		String json = "[{'emailcode':"+emailcode+"}]";
		response.getWriter().print(json);
		 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.GetMessageCode;

/**
 * 短信验证码发送接收
 * @author Administrator
 */
@WebServlet("/sendSMS")
public class SendSms extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phone = request.getParameter("phone");
		//根据获取到的手机号发送验证码。
		String code = GetMessageCode.getCode(phone);
		String json = "[{'phonecode':"+code+"}]";
		response.getWriter().print(json);
		 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

public class UserServlet extends HttpServlet {
	private UserDAO userDAO = new UserDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		String method2 = request.getParameter("method2");
		String method3 = request.getParameter("method3");
		String method4 = request.getParameter("method4");
		String method5 = request.getParameter("method5");
		String method6 = request.getParameter("method6");
		String method7 = request.getParameter("method7");
		if("register".equals(method)){
			doRegister(request,response);
		}
		if("register2".equals(method2)){
			doRegister2(request,response);
		}
		if("dateimage".equals(method3)){
			doRuturn(request,response);
		}
		if("findUserPhone".equals(method4)){
			
			doFindPhone(request,response);
		}
       if("findUserEmail".equals(method5)){
			
			doFindEmail(request,response);
		}
       if("userLogin".equals(method6)){
			douserLogin(request,response);
		}
       if("userEmailLogin".equals(method7)){
    	  
			douserEmailLogin(request,response);
		}
		
	}

	
	
	
	private void douserEmailLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int n = userDAO.userEmailLogin(email, password);
		 if(n>0){
	    	  request.getSession().setAttribute("phone_num", email);
	    	  }
		response.getWriter().print(n);
		
		
	}




	private void douserLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int n = userDAO.userLogin(username, password);
      
    	  if(n>0){
    	 request.getSession().setAttribute("phone_num", username);
    	 
    	  
    	  }
		response.getWriter().print(n);
		System.out.println(n);
		
//		if(n>0){
//			 request.getRequestDispatcher("homepage.jsp").forward(request, response);
//		}else{
//			response.getWriter().print("alert('登入失败')");
//		}
		
		
	}




	private void doFindEmail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String email = request.getParameter("useremail");
		int n = userDAO.findUserEmail(email);
		response.getWriter().print(n);
		
	}




	private void doFindPhone(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String phone = request.getParameter("userphone");
		int n = userDAO.findUserPhone(phone);
		
		response.getWriter().print(n);
		
	}




	private void doRuturn(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String code = (String)request.getSession().getAttribute("imageCode");
		response.getWriter().print(code);
	}




	private void doRegister2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int n = userDAO.userRegister_2(country, email, phone, password);
		if(n>0){
	    	 request.getRequestDispatcher("login.jsp").forward(request, response);
	     }else{
	    	 request.getRequestDispatcher("404.html").forward(request, response);
	     }
	}




	private void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
	     int n = userDAO.userRegister(country, phone, password);
	     request.setAttribute("n", n);
	     if(n>0){
	    	 request.getRequestDispatcher("login.jsp").forward(request, response);
	     }else{
	    	 request.getRequestDispatcher("404.html").forward(request, response);
	     }
		
		
		
	}

		
		
	

}

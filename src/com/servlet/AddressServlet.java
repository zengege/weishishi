package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddressDAO;
import com.dao.UserDAO;
import com.pojo.Address;

public class AddressServlet extends HttpServlet {
	
	private AddressDAO addressDAO = new AddressDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if("address".equals(method)){
			doAddress(request,response);
		}
		if ("findall".equals(method)){
			doFindAll(request,response);
		}
	}

	private void doFindAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
		//String phone_num = request.getParameter("userphone");
		String  phone_num = "15873312137";
		List<Address> list = addressDAO.findall(phone_num);
		if (list.size() == 0){
			response.getWriter().print("[]");
			return;
		}
		
		StringBuffer sb = new StringBuffer("[");
		
		for (Address a : list){
			sb.append("{'sheng':'").append(a.getSheng())
			.append("','shi':'").append(a.getShi())
			.append("','qu':'").append(a.getQu())
			.append("','detail_ad':'").append(a.getDetail_ad())
			.append("','phone':'").append(a.getPhone())
			.append("','name':'").append(a.getName())
			.append("','id':'").append(a.getAdress_id())
			.append("'},");
		}
		String json = sb.replace(sb.length()-1, sb.length(), "]").toString();
		System.out.println(json.length());
		response.getWriter().print(json);

		
	}

	private void doAddress(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String tel = request.getParameter("tel");
		String city = request.getParameter("city");
		String detail_ad = request.getParameter("detail_add");
		//String phone_num = request.getParameter("userphone");
		String  phone_num = "15873312137";
			int n = addressDAO.add(phone_num,username, tel,city,detail_ad);
			response.getWriter().print(n);
		
	}
	
}

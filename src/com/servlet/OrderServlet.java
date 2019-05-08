package com.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDAO;
import com.pojo.Address;
import com.pojo.Car2;
import com.pojo.Order;

public class OrderServlet extends HttpServlet {

	private OrderDAO orderDAO = new OrderDAO();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		if ("findall".equals(method)) {
			doFindAll(request, response);
		}
		if ("cancel".equals(method)) {
			doCancel(request, response);
		}
		if ("page".equals(method)) {
			doGetpage(request, response);
		}
		if("in".equals(method)){
			doin(request,response);
		}
		if("add".equals(method)){
			doadd(request,response);
		}
		
	}

	
	private void doadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("laile");
		HttpSession session = request.getSession();
		String ad_id = request.getParameter("ad_id");
		System.out.println(ad_id);
		List<Car2> list = (List<Car2>) session.getAttribute("list");
		for (Car2 car2 : list) {
			orderDAO.add(car2.getPhone_num(), ad_id, car2.getGoods_count(), car2.getGoods_color(),car2.getGoods_id());
		}
		System.out.println("hhhhh");
		response.getWriter().print("添加成功");
		//request.getRequestDispatcher("login.jsp").forward(request,response);
	}


	private void doin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  
		List<Car2> list  = new ArrayList<Car2>();
		Car2 car1 = new Car2();
		car1.setGoods_color("海鸥灰");
		car1.setGoods_count(2);
		car1.setGoods_edition("4GB+32GB");
		car1.setGoods_id("1001010043706");
		car1.setGoods_name("荣耀10");
		car1.setPhone_num("13054123426");
		car1.setGoods_pic("image/smp/honor/honor10/gray");
		car1.setGoods_price(2299);
		
		Car2 car2 = new Car2();
		car2.setGoods_color("幻夜黑");
		car2.setGoods_count(1);
		car2.setGoods_edition("4GB+32GB");
		car2.setGoods_id("1001010043706");
		car2.setGoods_name("荣耀10");
		car2.setPhone_num("13054123426");
		car2.setGoods_pic("image/smp/honor/honor10/black");
		car2.setGoods_price(2299);
		
		list.add(car2);
		list.add(car1);
		
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		
		request.getRequestDispatcher("ensureorder.jsp").forward(request,response);
		
	}


	private void doGetpage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String phone_num = "13054123426";
		String condition = request.getParameter("condition");
		int n = orderDAO.getcount(condition, phone_num);
		int allPage = (int) Math.ceil(n / 4.0);

		StringBuffer sb = new StringBuffer("[");
		for (int i = 1; i <= allPage; i++) {
			sb.append("{'page':'").append(i).append("'},");
		}
		String json = sb.replace(sb.length() - 1, sb.length(), "]").toString();
		response.getWriter().print(json);
	}

	private void doCancel(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int n = orderDAO.cancel(id);
		response.getWriter().print(n);

	}

	private void doFindAll(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		String phone_num = "13054123426";
		String condition = request.getParameter("condition");
		List<Order> list = orderDAO.findall(phone_num, condition, page);
		if (list.size() == 0) {
			response.getWriter().print("[]");
			return;
		}

		StringBuffer sb = new StringBuffer("[");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Order a : list) {
			Timestamp date = a.getOrder_time();
			sb.append("{'time':'").append(fmt.format(date)).append("','id':'")
					.append(a.getOrder_id()).append("','condition':'")
					.append(a.getCondition()).append("','cname':'")
					.append(a.getCname()).append("','pic':'")
					.append(a.getGoods_pic()).append("','name':'")
					.append(a.getGoods_name()).append("','price':'")
					.append(a.getGoods_price()).append("','count':'")
					.append(a.getGoods_count()).append("','color':'")
					.append(a.getGoods_color()).append("','edition':'")
					.append(a.getGoods_edition()).append("','address':'")
					.append(a.getAdress_id()).append("'},");
		}
		String json = sb.replace(sb.length() - 1, sb.length(), "]").toString();
		response.getWriter().print(json);

	}

}

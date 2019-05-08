package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CarDAO;
import com.dao.GoodsDAO;
import com.pojo.Car;
import com.pojo.Carxs;

public class CarServlet extends HttpServlet {
	private CarDAO carDAO = new CarDAO();
	private GoodsDAO goodsDAO = new GoodsDAO();

	
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if ("addCar".equals(method)) {
			doAddCar(request, response);
		}

		if ("delfromcar".equals(method)) {
			doDelFromCar(request, response);
		}
		if ("showcar".equals(method)) {
			doShowCar(request, response);

		}
		if("selectcar".equals(method)) {
			doSelectCar(request, response);

		}
		if ("updatenum".equals(method)) {
			doUpdateNum(request,response);
		}

	}

	private void doUpdateNum(HttpServletRequest request,
			HttpServletResponse response) {
		String phone_num = (String) request.getSession().getAttribute("phone_num");
		String goods_name = request.getParameter("goods_name");
		String goods_edition = request.getParameter("goods_edition").replace(' ', '+');
		String goods_color=request.getParameter("goods_color");
		String goods_id=request.getParameter("goods_id");
carDAO.update(goods_id, goods_id, 0, goods_id, goods_id);
	
	}

	private void doSelectCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String phone_num = (String) request.getSession().getAttribute("phone_num");
		System.out.println(phone_num);
		String first = request.getParameter("kind");
		List<Carxs> carxs = carDAO.showCar(phone_num);
		System.out.println(carxs.size());
		HttpSession session = request.getSession();
		session.setAttribute("carxs", carxs);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	
	}

	private void doShowCar(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String phone_num = (String) request.getSession().getAttribute("phone_num");
		
		List<Carxs> carxs = carDAO.showCar(phone_num);
		System.out.println(carxs.size());
		HttpSession session = request.getSession();
		session.setAttribute("carxs", carxs);
		
		request.getRequestDispatcher("shoppingcar.jsp").forward(request, response);
	}

	private void doDelFromCar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String phone_num = (String) request.getSession().getAttribute("phone_num");
		String goods_name = request.getParameter("goods_name");
		String goods_edition = request.getParameter("goods_edition").replace(' ', '+');
		String goods_color=request.getParameter("goods_color");
		String goods_id=request.getParameter("goods_id");

		
		System.out.println(goods_id);
		List<Carxs> carxs = carDAO.showCar(phone_num);
		if (carxs.size() > 0) {
			carxs.remove(goods_id);
			carDAO.delfromcar(goods_id, phone_num,goods_color,goods_edition);
		}

		// carDAO.showcar(phone_num);

	}

	private void doAddCar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int goods_num = Integer.parseInt(request.getParameter("num"));
		String phone_num = (String) request.getSession().getAttribute("phone_num");
		String goods_name = request.getParameter("goods_name");
		System.out.println(goods_name);
		String goods_edition = request.getParameter("goods_edition").replace(' ', '+');
		String goods_color = request.getParameter("goods_color");
		String goods_id = goodsDAO.getgoodsid(goods_name, goods_edition);
		System.out.println("showCar");
           
		// 没有就new一个购物车
      
		// 显示购物车信息
		List<Carxs> carxs = carDAO.showCar(phone_num);
		List<Car> list=carDAO.seke(goods_color,goods_edition,goods_id,phone_num);
		System.out.println((carxs == null));
		System.out.println(list!=null);
		if (carxs == null) {
			
			carDAO.addCar(goods_id, phone_num, goods_num, goods_color,
				goods_edition);
			HttpSession session = request.getSession();
			session.setAttribute("carxs", carxs);
			
		}
		// 有就加
		// 根据id获取对应的商品项
		// 取出原有商品的数量
		// 原有商品已更新为最新添加的数量
		// carolds Map>>> CarAll
		// 修改小计 carold Car
		// 原来该商品的小计
		// 新买的商品的小计
		// 如果车中没有该商品
		else {
			if(list.size()>0){
		
				carDAO.update(goods_id, phone_num, goods_num,goods_color, goods_edition);
		}else {
			carDAO.addCar(goods_id, phone_num, goods_num, goods_color,
					goods_edition);
		}}
		}

		// 重定向(这里不是request存值可以使用重定向)，避免数据重复提交
	  
	
	}



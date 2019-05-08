package com.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDAO;
import com.pojo.Goods;
import com.pojo.GoodsColor;
import com.pojo.GoodsDetail;
import com.pojo.GoodsEdition;

public class GoodsServlet extends HttpServlet implements Serializable{

	private GoodsDAO goodsDAO = new GoodsDAO();

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String method = request.getParameter("method");
		String method1 = request.getParameter("method1");
		String method2 = request.getParameter("method2");
		if ("goodsdetailpic".equals(method2)) {
			doFindDetailpic(request, response);

		}
//		if ("goodscolor".equals(method1)) {
//			doFindColor(request, response);
//			System.out.println("ee");
//
//		}

		if ("goodsdetail".equals(method)) {
			doFindDetail(request, response);

		}
		
		
	}

	private void doFindDetailpic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String goodsname = request.getParameter("goodsname");
		GoodsDetail goodsdetailpic = goodsDAO.getdetailpic(goodsname);
		request.getSession().setAttribute("detailpic", goodsdetailpic);
	}

//	private void doFindColor(HttpServletRequest request,
//			HttpServletResponse response) {
//		String goodsname = request.getParameter("goodsname");
//		List<GoodsColor> color = goodsDAO.getgoodscolor(goodsname);
//		request.getSession().setAttribute("color", color);
//		System.out.println("lail");
//		System.out.println(goodsname);
//		System.out.println(color.get(0));
//
//	}

	private void doFindDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String goodsname = request.getParameter("goodsname");
		System.out.println(goodsname);
		
		List<GoodsColor> color = goodsDAO.getgoodscolor(goodsname);
		request.getSession().setAttribute("color", color);
		
		List<GoodsEdition> edition = goodsDAO.getgoodedition(goodsname);
		request.getSession().setAttribute("edition", edition);
		
		Goods goods = goodsDAO.getgoodsdetail(goodsname);
		request.getSession().setAttribute("list", goods);
		request.getRequestDispatcher("goodsdetail.jsp").forward(request,
				response);

	}
}

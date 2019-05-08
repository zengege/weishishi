package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ShowGoodsDAO;
import com.pojo.Goods_info1;

public class FindServlet extends HttpServlet {
	 private	ShowGoodsDAO goodsDAO = new ShowGoodsDAO();
	 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		String oldmethod = (String) request.getSession().getAttribute("oldmethod");
		request.setAttribute("method", method);
		if("findbybig_type".equals(method)){
			dofindbybig(request,response);
			oldmethod = "findbybig_type";
		}
		if("findbysmall_type".equals(method)){
			dofindbysmall(request,response);
			oldmethod = "findbysmall_type";
		}
		if("findbyorderby".equals(method)){
			dofindbyorderby(request,response);
		}
		if("findbylike".equals(method)){
			dofindbylike(request,response);
			oldmethod = "findbylike";
		}
		request.getSession().setAttribute("oldmethod", oldmethod);
		System.out.println(oldmethod);
		System.out.println(method);
	}

	private void dofindbylike(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("laile");
		int page = 1 ;
		int size = 20;
		
		String like = request.getParameter("like");
		
		String pageString = request.getParameter("page");
		if (pageString != null && pageString.trim().length() > 0) {
			page = Integer.parseInt(pageString);
		}

		String sizeString = request.getParameter("size");
		if (sizeString != null && sizeString.trim().length() > 0) {
			size = Integer.parseInt(sizeString);
		}

		if (page < 1) {
			page = 1;
		}
		
		
		int count = goodsDAO.getlikecount(like);
		int pagecount = count%size==0 ? count/size :count/size + 1 ; 
		if(page>pagecount){
			page = pagecount;
		}
		List<Goods_info1> list = goodsDAO.findbylike(page, size, like);
		
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("size", size);
		map.put("page", page);
		map.put("count", count);
		map.put("pagecount", pagecount);
		map.put("like", like);

		request.setAttribute("map", map);
		request.getRequestDispatcher("showgoods.jsp").forward(request, response);
		
	}

	private void dofindbyorderby(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String odd_even  = request.getParameter("odd_even");
		
		request.setAttribute("odd_even", odd_even);
		
		String oldmethod = request.getParameter("oldmethod");
		
		int page = 1;
		int size = 20;
		String pageString = request.getParameter("page");
		
		if(pageString !=null && pageString.trim().length() >0){
			page = Integer.parseInt(pageString);
		}
		
		String sizeString = request.getParameter("size");
		if (sizeString != null && sizeString.trim().length() > 0) {
			size = Integer.parseInt(sizeString);
		}
		
		if (page < 1) {
			page = 1;
		}
		int count =1;
		
		 List<Goods_info1> list = new ArrayList<Goods_info1>();
		
		if("findbysmall_type".equals(oldmethod)){
			
			String small_type = request.getParameter("small_type");
			
			 count = goodsDAO.getsmalltypecount(small_type);
			 int pagecount = count%size==0 ? count/size :count/size + 1 ; 
			 if(page>pagecount){
					page = pagecount;
				}
			if("odd".equals(odd_even)){
			   list = goodsDAO.findbysmallorderbyup(page,size, small_type);
			}else{
				 list = goodsDAO.findbysmallorderbydown(page,size, small_type);
			}
			
		}
		else if("findbybig_type".equals(oldmethod)){
			
			String big_type = request.getParameter("big_type");
			 count = goodsDAO.getbigtypecount(big_type);
			 int pagecount = count%size==0 ? count/size :count/size + 1 ; 
			 if(page>pagecount){
					page = pagecount;
				}
			if("odd".equals(odd_even)){
				   list = goodsDAO.findbybigorderbyup(page,size, big_type);
				}else{
					 list = goodsDAO.findbybigorderbydown(page,size, big_type);
				}
		}
		 
		int pagecount = count%size==0 ? count/size :count/size + 1 ; 
		Map map = new HashMap();
		map.put("list",list);
		map.put("size", size);
		map.put("page", page);
		map.put("count", count);
		map.put("pagecount", pagecount);
		
	
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("showgoods.jsp").forward(request, response);
	}

	private void dofindbysmall(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int size = 20;
		String small_type = request.getParameter("small_type");
		String pageString = request.getParameter("page");
		if(pageString !=null && pageString.trim().length() >0){
			page = Integer.parseInt(pageString);
		}
		
		String sizeString = request.getParameter("size");
		if (sizeString != null && sizeString.trim().length() > 0) {
			size = Integer.parseInt(sizeString);
		}
		if (page < 1) {
			page = 1;
		}
		int count = goodsDAO.getsmalltypecount(small_type);
		
		int pagecount = count%size==0 ? count/size :count/size + 1 ; 
		if(page>pagecount){
			page = pagecount;
		}
		
		List<Goods_info1> list = goodsDAO.findbysmall_type(page, size, small_type);

		Map map = new HashMap();
		map.put("list",list);
		map.put("size", size);
		map.put("page", page);
		map.put("count", count);
		map.put("pagecount", pagecount);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("showgoods.jsp").forward(request, response);
	}

	private void dofindbybig(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int page = 1 ;
		int size = 20;
		String big_type = request.getParameter("big_type");
		
		String pageString = request.getParameter("page");
		if (pageString != null && pageString.trim().length() > 0) {
			page = Integer.parseInt(pageString);
		}

		String sizeString = request.getParameter("size");
		if (sizeString != null && sizeString.trim().length() > 0) {
			size = Integer.parseInt(sizeString);
		}

		if (page < 1) {
			page = 1;
		}
		
		int count = goodsDAO.getbigtypecount(big_type);
		int pagecount = count%size==0 ? count/size :count/size + 1 ;
		if(page>pagecount){
			page = pagecount;
		}
		List<Goods_info1> list = goodsDAO.findbybig_type(page, size, big_type);
		
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("size", size);
		map.put("page", page);
		map.put("count", count);
		map.put("pagecount", pagecount);

		request.setAttribute("map", map);
		request.getRequestDispatcher("showgoods.jsp").forward(request, response);
		
		
		
	}
}

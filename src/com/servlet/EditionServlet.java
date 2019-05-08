package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GoodsDAO;

import com.pojo.GoodsEdition;

public class EditionServlet extends HttpServlet {
	
    private GoodsDAO goodsDAO = new GoodsDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("findEdition".equals(method)){
			doFindEdition(request,response);
		}
		
	}

	private void doFindEdition(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String goodsname = request.getParameter("goodsname");
		List<GoodsEdition> list = goodsDAO.getgoodeditionprice(goodsname);
		System.out.println(list.size());
		if (list.size() == 0) {
			response.getWriter().print("[]");
			return;
		}

		StringBuffer sb = new StringBuffer("[");

		for (GoodsEdition edition : list) {
			sb.append("{'editionid':'").append(edition.getEdition_id())
					.append("','goodsprice':'").append(edition.getGoods_price())
					.append("','discounts':'").append(edition.getDiscounts())
					.append("','goodsid':'").append(edition.getGoods_id())
					.append("'},");
		}
		
		String json = sb.replace(sb.length()-1, sb.length(), "]").toString();
		response.getWriter().print(json);
		
	}

}

package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JudgeDAO;
import com.pojo.GoodsJudge;
import com.util.Upload;

public class JudgeServlet extends HttpServlet {

	JudgeDAO judgeDAO = new JudgeDAO();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		
		if ("judge".equals(method)) {
			doJudge(request, response);
		}
		if("findusername".equals(method)){
			System.out.println("ww");
			doFindUsername(request,response);
		}
		if("userjudge".equals(method)){
			
			doFindJudge(request,response);
		}
		if("finduser".equals(method)){
			doFindUser(request,response);
		}

	}

	private void doFindUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String phone_num = request.getParameter("phone_num");
		int j = judgeDAO.findUser(phone_num);
		System.out.println("j="+j);
		response.getWriter().print(j);
		
	}

	private void doFindJudge(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    String phone_num = request.getParameter("phone_num");
		    String goods_name = request.getParameter("goodsname");
		    List<GoodsJudge> list = judgeDAO.getJudge(goods_name, phone_num);
		    if (list.size() == 0) {
				response.getWriter().print("[]");
				return;
			}

			StringBuffer sb = new StringBuffer("[");

			for (GoodsJudge user : list) {
				sb.append("{'phone_num':'").append(user.getPhone_num())
				.append("','judge_pic':'").append(user.getJudge_pic())
				.append("','judge_time':'").append(user.getJudge_time())
				.append("','judge_words':'").append(user.getJudge_words())
				.append("'},");
						
			}
			
			String json1 = sb.replace(sb.length()-1, sb.length(), "]").toString();
			response.getWriter().print(json1);
			
	
		
	}

	private void doFindUsername(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String goodsname = request.getParameter("goodsname");
		List<GoodsJudge> list = judgeDAO.getJudgecount(goodsname);
		
		if (list.size() == 0) {
			response.getWriter().print("[]");
			return;
		}

		StringBuffer sb = new StringBuffer("[");

		for (GoodsJudge user : list) {
			sb.append("{'phone_num':'").append(user.getPhone_num()).append("'},");
					
		}
		
		String json = sb.replace(sb.length()-1, sb.length(), "]").toString();
		response.getWriter().print(json);
		
	
		
	}

	private void doJudge(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getSession().getServletContext()
				.getRealPath("judgeimg");
		Map<String, String> map = Upload.upload(request, 100 * 1023 * 1024,
				path);
        String goods_name = request.getParameter("goods_name");
        String phone_num = request.getParameter("phone_num");
        String judge_words = request.getParameter("judge_words");
        Date day=new Date();  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String time = df.format(day); 
        String judge_time = time;
        
        int k = judgeDAO.insertJufge2(phone_num, judge_words);
        System.out.println("ee");
        
        String judge_pic = "";
        int n = 0;
		for (String string : map.keySet()) {
			System.out.println(string + "   " + map.get(string));
			 judge_pic = map.get(string);
			 n = judgeDAO.insertJufge(goods_name, phone_num, judge_pic, judge_time);
			
		}
		
		    System.out.println("ww");
		    try {
		    	Thread.sleep(1000); //1000 毫秒，也就是1秒.
		    	response.sendRedirect("judge.jsp");
		    	} catch(InterruptedException ex) {
		    	Thread.currentThread().interrupt();
		    	}
			
			 System.out.println("ww2");
		

	}

}

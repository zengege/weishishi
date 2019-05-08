package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImgServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s="abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<4;i++){
			int index = random.nextInt(26);
			char ch = s.charAt(index);
			sb.append(ch);
		}
		String code = sb.toString();
		
		BufferedImage bufferedImage = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 100	, 30);
		
		graphics.setColor(Color.red);
		graphics.setFont(new Font("����",Font.BOLD,30));
		
		graphics.drawString(code.charAt(0)+"", 10, 29);
		graphics.drawString(code.charAt(1)+"", 30, 26);
		graphics.drawString(code.charAt(2)+"", 50, 28);
		graphics.drawString(code.charAt(3)+"", 70, 25);
		
		graphics.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
		graphics.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
		graphics.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
		graphics.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
		
		//���������
		OutputStream os = response.getOutputStream();
		ImageIO.write(bufferedImage, "JPEG", os);
		os.close();
		request.getSession().setAttribute("imageCode", code);
		
//		String json = "[{'imagecode':"+code+"}]"; 
//		response.getWriter().print(json);
		
	}
	
}

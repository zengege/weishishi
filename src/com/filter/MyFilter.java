package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyFilter implements Filter {

	class MyRequest extends HttpServletRequestWrapper {

		@Override
		public String getParameter(String name) {

			String value = super.getParameter(name);
			String method = getMethod();
			if ("get".equalsIgnoreCase(method)) {
				if (value != null) {
					try {
						value = new String(value.getBytes("iso-8859-1"), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			return value;
		}

		public MyRequest(HttpServletRequest request) {
			super(request);
		}

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {

	
		request.setCharacterEncoding("utf-8");
	
		response.setContentType("text/html;charset=utf-8");
		
	
		arg2.doFilter(new MyRequest((HttpServletRequest)request), response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

package com.upon.servletpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCycle extends HttpServlet {

	
	public ServletCycle() {		
		super();
		System.out.println("Constructor");
	}

	
	


	public void destroy() {
		System.out.println("destory");
		super.destroy();
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		out.println("<html><head><body><h1 align=center>ServletÉúÃüÖÜÆÚ</body></head></html>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		
	}

	
	public void init() throws ServletException {
		System.out.println("init");
	}

}

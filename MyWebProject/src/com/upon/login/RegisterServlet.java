package com.upon.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + ">>>" + password);
		DBHelper dbHelper = new DBHelper(username, password);
		boolean b = dbHelper.insert();
		if(b) {
			out.println("<html><head><title>×¢²á³É¹¦</title></head><body><h1 align=center>¹§Ï²Äã×¢²á³É¹¦£¡<br/><a href='../loginPagel.html'>·µ»ØµÇÂ½</body></html>");
			System.out.println("×¢²á³É¹¦£¡");
		} else {
			out.println("<html><head><title>×¢²áÊ§°Ü</title></head><body><h1 align=center>×¢²áÊ§°Ü£¡<br/><a href='../register.html'>ÖØÐÂ×¢²áÐÂÕËºÅ</body></html>");
			System.out.println("×¢²áÊ§°Ü£¡");
			
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

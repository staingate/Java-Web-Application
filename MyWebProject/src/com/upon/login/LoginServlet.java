package com.upon.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
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
		Boolean b = dbHelper.select();
		if(b) {
			out.println("<html><head><title>登陆成功</title></head><body><h1 align=center>恭喜你登陆成功！</body></html>");
			System.out.println("登陆成功！");
		} else {
			out.println("<html><head><title>登陆失败</title></head><body><h1 align=center>登陆失败！请输入正确的账号密码或注册新账户！<br/><a href='../register.html'>注册新账号</body></html>");
			System.out.println("登陆失败！");
			
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

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
			out.println("<html><head><title>ע��ɹ�</title></head><body><h1 align=center>��ϲ��ע��ɹ���<br/><a href='../loginPagel.html'>���ص�½</body></html>");
			System.out.println("ע��ɹ���");
		} else {
			out.println("<html><head><title>ע��ʧ��</title></head><body><h1 align=center>ע��ʧ�ܣ�<br/><a href='../register.html'>����ע�����˺�</body></html>");
			System.out.println("ע��ʧ�ܣ�");
			
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

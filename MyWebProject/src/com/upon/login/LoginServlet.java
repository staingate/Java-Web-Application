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
			out.println("<html><head><title>��½�ɹ�</title></head><body><h1 align=center>��ϲ���½�ɹ���</body></html>");
			System.out.println("��½�ɹ���");
		} else {
			out.println("<html><head><title>��½ʧ��</title></head><body><h1 align=center>��½ʧ�ܣ���������ȷ���˺������ע�����˻���<br/><a href='../register.html'>ע�����˺�</body></html>");
			System.out.println("��½ʧ�ܣ�");
			
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

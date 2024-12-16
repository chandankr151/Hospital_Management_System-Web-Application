package com.admin.servlet;

import java.io.IOException;

import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {

	private static final long serialVersionUID = 4450655406408198350L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		HttpSession session = req.getSession();

		if ("admin@gmail.com".equalsIgnoreCase(email) && "admin".equalsIgnoreCase(pass)) {
			session.setAttribute("adminObj", new User());
			resp.sendRedirect("admin/index.jsp");
		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("admin_login.jsp");
			
		}
	}

}

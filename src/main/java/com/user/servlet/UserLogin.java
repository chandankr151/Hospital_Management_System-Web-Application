package com.user.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = -5325697664359024312L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		HttpSession session = req.getSession();
		UserDao dao = new UserDao(DBConnect.getConnection());
		User user = dao.login(email, pass);
		if (user != null) {
			session.setAttribute("userObj", user);
			resp.sendRedirect("home.jsp");
		} else {
			session.setAttribute("errorMsg", "Invalid email & password");
			resp.sendRedirect("user_login.jsp");
		}
	}
}

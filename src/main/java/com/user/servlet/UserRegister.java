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

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	private static final long serialVersionUID = 5940323108342086985L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("fullName");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		try {

			User user = new User(name, email, pass);

			UserDao dao = new UserDao(DBConnect.getConnection());
			boolean f = dao.UserRegister(user);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("successMsg", "User Registered Successfully");
				resp.sendRedirect("signup.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

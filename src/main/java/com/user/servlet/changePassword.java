package com.user.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/resetUserPass")
public class changePassword extends HttpServlet {

	private static final long serialVersionUID = 5481523108661942296L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("uid"));

		String oldPass = req.getParameter("oldPass");
		String newPass = req.getParameter("newPass");

		UserDao dao = new UserDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.checkOldPassword(id, oldPass) != 0) {

			if (dao.changeUserPassword(id, newPass)) {

				session.setAttribute("succMsg", "Password Changed Successfully");
				resp.sendRedirect("change_password.jsp");

			} else {

				session.setAttribute("errorMsg", "Something went wrong on server during password change");
				resp.sendRedirect("change_password.jsp");
			}
		} else {

			session.setAttribute("errorMsg", "Old Password Incorrect");
			resp.sendRedirect("change_password.jsp");
		}
	}

}

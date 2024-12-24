package com.doctor.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/doctorChangePass")
public class DoctorPasswordChange extends HttpServlet {

	private static final long serialVersionUID = -5161927202084141712L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("uid"));

		String oldPass = req.getParameter("oldPass");
		String newPass = req.getParameter("newPass");

		DoctorDao dao = new DoctorDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		if (dao.checkOldPassword(id, oldPass) != 0) {

			if (dao.changeUserPassword(id, newPass)) {

				session.setAttribute("succMsg", "Password Changed Successfully");
				resp.sendRedirect("doctor/edit_profile.jsp");

			} else {

				session.setAttribute("errorMsg", "Something went wrong on server during password change");
				resp.sendRedirect("doctor/edit_profile.jsp");

			}
		} else {

			session.setAttribute("errorMsg", "Old Password Incorrect");
			resp.sendRedirect("doctor/edit_profile.jsp");

		}
	}

}

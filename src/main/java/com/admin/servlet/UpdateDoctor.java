package com.admin.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {

	private static final long serialVersionUID = -1727286931541263913L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String dob = req.getParameter("dob");
		String qual = req.getParameter("qualification");
		String spec = req.getParameter("spec");
		String email = req.getParameter("email");
		String mobNo = req.getParameter("mobno");
		String pass = req.getParameter("password");
		String fullName = req.getParameter("fullname");

		Doctor dd = new Doctor(id, fullName, dob, qual, spec, email, mobNo, pass);
		DoctorDao dao = new DoctorDao(DBConnect.getConnection());
		HttpSession session = req.getSession();

		boolean docupdate = dao.updateDoctor(dd);
		if (docupdate) {
			session.setAttribute("succMsg", "doctor updated successfully");
			resp.sendRedirect("admin/viewDoctor.jsp");
		} else {

			session.setAttribute("errorMsg", "something went wrong on server");
			resp.sendRedirect("admin/viewDoctor.jsp");
		}
	}

}

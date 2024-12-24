package com.doctor.servlet;

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

@WebServlet("/doctorEditProfile")
public class Edit_DoctorProfile extends HttpServlet {

	private static final long serialVersionUID = -5511266144895375761L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("uid"));

		String dob = req.getParameter("dob");
		String qual = req.getParameter("qualification");
		String spec = req.getParameter("spec");
		String email = req.getParameter("email");
		String mobNo = req.getParameter("mobno");
		String fullName = req.getParameter("fullname");

		Doctor dd = new Doctor(id, fullName, dob, qual, spec, email, mobNo, "");
		DoctorDao dao = new DoctorDao(DBConnect.getConnection());

		HttpSession session = req.getSession();

		boolean updateProfile = dao.editDoctorProfile(dd);

		if (updateProfile) {

			session.setAttribute("succMsgd", "doctor updated successfully");
			resp.sendRedirect("doctor/edit_profile.jsp");

		} else {

			session.setAttribute("errorMsgd", "something went wrong on server");
			resp.sendRedirect("doctor/edit_profile.jsp");
		}

	}
}

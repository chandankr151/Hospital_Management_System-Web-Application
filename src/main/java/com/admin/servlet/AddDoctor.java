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

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	private static final long serialVersionUID = 9011887059952530074L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullName = req.getParameter("fullname");
		String dob = req.getParameter("dob");
		String qualification = req.getParameter("qualification");
		String specialist = req.getParameter("spec");
		String email = req.getParameter("email");
		String mobno = req.getParameter("mobno");
		String pass = req.getParameter("password");

		Doctor d1 = new Doctor(fullName, dob, qualification, specialist, email, mobno, pass);

		DoctorDao dao = new DoctorDao(DBConnect.getConnection());
		boolean flag = dao.registerDoctor(d1);

		HttpSession session = req.getSession();

		if (flag) {
			session.setAttribute("succMsg", "doctor added successfully");
			resp.sendRedirect("admin/doctor.jsp");
		} else {
			session.setAttribute("errorMsg", "something went wrong on server");
			resp.sendRedirect("admin/doctor.jsp");
		}
	}
}

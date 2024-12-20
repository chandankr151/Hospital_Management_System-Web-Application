package com.admin.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	private static final long serialVersionUID = -7283418084293812219L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();

		DoctorDao dao = new DoctorDao(DBConnect.getConnection());
		boolean deletd = dao.deleteDoctor(id);

		if (deletd) {
			session.setAttribute("succMsg", "doctor deleted successfully");
			resp.sendRedirect("admin/viewDoctor.jsp");
		} else {
			session.setAttribute("errorMsg", "Can't delete doctor something went wrong on server");
			resp.sendRedirect("admin/viewDoctor.jsp");
		}
	}

}

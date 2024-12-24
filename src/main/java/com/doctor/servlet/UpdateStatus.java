package com.doctor.servlet;

import java.io.IOException;

import com.dao.AppointmentDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

	private static final long serialVersionUID = -8700422853999268015L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));
			int did = Integer.parseInt(req.getParameter("did"));
			String comm = req.getParameter("comm");

			System.out.println("Id: " + id + "DoctorId: " + did + "Comment: " + comm);
			AppointmentDAO dao = new AppointmentDAO(DBConnect.getConnection());
			HttpSession session = req.getSession();

			if (dao.updateCommentStatus(id, did, comm)) {
				session.setAttribute("succMsg", "Comment Updated Successfully");
				resp.sendRedirect("doctor/patient.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("doctor/patient.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

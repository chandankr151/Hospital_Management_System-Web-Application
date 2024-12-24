package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDAO {

	private Connection conn;

	public AppointmentDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addAppointment(Appointment ap) {
		boolean flag = false;

		try {

			String query = "insert into appointment(user_id, fullname, gender, age, appoint_date, email, phno, diseases, doctorid, address,status) values (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ptmt = conn.prepareStatement(query);

			ptmt.setInt(1, ap.getUserId());
			ptmt.setString(2, ap.getFullName());
			ptmt.setString(3, ap.getGender());
			ptmt.setString(4, ap.getAge());
			ptmt.setString(5, ap.getAppoinDate());
			ptmt.setString(6, ap.getEmail());
			ptmt.setString(7, ap.getPhNo());
			ptmt.setString(8, ap.getDiseases());
			ptmt.setInt(9, ap.getDoctorId());
			ptmt.setString(10, ap.getAddress());
			ptmt.setString(11, ap.getStatus());

			int r = ptmt.executeUpdate();
			if (r == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<Appointment> getAllAppointmentByLoginId(int userId) {

		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from appointment where user_id=?");
			ptmt.setInt(1, userId);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(12));
				ap.setStatus(rs.getString(12));

				list.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {

		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from appointment where doctorid=?");
			ptmt.setInt(1, doctorId);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(12));
				ap.setStatus(rs.getString(12));

				list.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/// ===================Get Appointment Details using id=======

	public Appointment getAppointmentById(int doctId) {

		Appointment ap = null;

		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from appointment where id=?");
			ptmt.setInt(1, doctId);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {

				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(12));
				ap.setStatus(rs.getString(12));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ap;
	}

	//// =========================
	public boolean updateCommentStatus(int id, int doctId, String com) {

		boolean flag = false;

		try {

			String query = "update appointment set status = ? where id=? and doctorid=?";
			PreparedStatement ptmt = conn.prepareStatement(query);
			ptmt.setString(1, com);
			ptmt.setInt(2, id);
			ptmt.setInt(3, doctId);

			int f = ptmt.executeUpdate();
			if (f == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	///============================================
	
	public List<Appointment> getAllAppointment() {

		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {
			PreparedStatement ptmt = conn.prepareStatement("select * from appointment order by id desc ");
			
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(12));
				ap.setStatus(rs.getString(12));

				list.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}

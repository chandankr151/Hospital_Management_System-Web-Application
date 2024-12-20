package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {

	private Connection con;

	public DoctorDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean registerDoctor(Doctor d) {

		boolean flag = false;

		try {
			String query = "insert into doctor(doc_fullName, doc_dob, doc_qualification, doc_specialist, doc_email, doc_mobno, doc_pass) values(?,?,?,?,?,?,?)";
			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setString(1, d.getFullName());
			ptmt.setString(2, d.getDob());
			ptmt.setString(3, d.getQualification());
			ptmt.setString(4, d.getSpecialist());
			ptmt.setString(5, d.getEmail());
			ptmt.setString(6, d.getMobNo());
			ptmt.setString(7, d.getPassword());

			int i = ptmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;

		try {

			String query = "select * from doctor order by doc_id desc";
			PreparedStatement ptmt = con.prepareStatement(query);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));

				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Doctor getDoctorById(int doc_id) {

		Doctor d = new Doctor();

		String query = "select * from doctor where doc_id = ? ";
		try {
			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setInt(1, doc_id);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {

				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return d;

	}

	public boolean updateDoctor(Doctor d) {

		boolean flag = false;

		try {
			String query = "update doctor set doc_fullName=?, doc_dob =?, doc_qualification=?, doc_specialist=?, doc_email=?, doc_mobno=?, doc_pass=? where doc_id=?";
			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setString(1, d.getFullName());
			ptmt.setString(2, d.getDob());
			ptmt.setString(3, d.getQualification());
			ptmt.setString(4, d.getSpecialist());
			ptmt.setString(5, d.getEmail());
			ptmt.setString(6, d.getMobNo());
			ptmt.setString(7, d.getPassword());
			ptmt.setInt(8, d.getId());

			int i = ptmt.executeUpdate();
			if (i == 1) {
				flag = true;
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteDoctor(int id) {

		boolean flag = false;

		String query = "delete from doctor where doc_id = ?";
		PreparedStatement ptmt;

		try {
			ptmt = con.prepareStatement(query);
			ptmt.setInt(1, id);

			int f = ptmt.executeUpdate();
			if (f == 1)
				flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public Doctor login(String email, String pass) {

		Doctor d = null;

		String query = "select * from doctor where doc_email=? and doc_pass=?";
		try {
			
			PreparedStatement ptmt = con.prepareStatement(query);
			
			ptmt.setString(1, email);
			ptmt.setString(2, pass);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {

				d = new Doctor();

				d.setId(rs.getInt(1));
				d.setFullName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return d;
	}
}

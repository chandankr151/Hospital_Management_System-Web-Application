package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean UserRegister(User user) {

		boolean flag = false;

		try {
			String sql = "insert into user(user_fname, user_email, user_pass) values(?,?,?) ";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, user.getFullName());
			ptmt.setString(2, user.getEmail());
			ptmt.setString(3, user.getPassword());

			int r = ptmt.executeUpdate();
			if (r == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public User login(String email, String pass) {
		User user = null;

		try {
			String sql = "select * from user where user_email=? and user_pass=?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, email);
			ptmt.setString(2, pass);

			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}

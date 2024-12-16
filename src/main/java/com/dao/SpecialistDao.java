package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specialist;

public class SpecialistDao {

	private Connection con;

	public SpecialistDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addSpecialist(String spec) {

		boolean f = false;

		try {

			String query = "insert into specialist(spec_name) values(?)";
			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setString(1, spec);

			int i = ptmt.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public List<Specialist> getAllSpecialist(){
		
		List<Specialist>  list = new ArrayList<Specialist>();
		Specialist spec = null;
		
		String query = "select * from specialist";
		try {
			PreparedStatement ptmt = con.prepareStatement(query);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				spec = new Specialist();
				spec.setId(rs.getInt(1));
				spec.setSpecialistName(rs.getString(2));
				
				list.add(spec);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
}

package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public boolean check(String uname, String pword) {
		
		String url = "jdbc:mysql://localhost:3307/loginuser";
		String username="root";
		String password="root";
		
		String sql = "SELECT * FROM login WHERE uname=? AND upass=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(sql);//create prepared statement
			st.setString(1, uname);
			st.setString(2, pword);
			
			ResultSet rs = st.executeQuery();//executing query
			
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseLoginService {

	public boolean authenticate(String uname, String pwd) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "system";
			String pass = "21662159";		
					
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT COUNT(user_id) FROM tbl_users WHERE user_name = ? AND user_pass = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uname);
			stmt.setNString(2, pwd);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1) {
					return true;
				}
			}
			return false;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			}catch(Exception e) { }
		}
	}
}

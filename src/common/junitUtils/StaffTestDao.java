package common.junitUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.configration.DBConfig;
import entity.Staff;


public class StaffTestDao {

	public Staff getByName(String name) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "SELECT * FROM staff WHERE fullName = '" + name + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Staff result = null;
			if (rs.next()) {
				result = new Staff();
				result.setId(rs.getInt("id"));
				result.setFullName(rs.getString("fullName"));
				result.setPreferredName(rs.getString("preferredName"));
				result.setMobileNumber(rs.getString("mobileNumber"));
				result.setEmail(rs.getString("email"));
				result.setHomeAddress(rs.getString("homeAddress"));
				result.setWorkHourLimit(rs.getDouble("workHourLimit"));
				result.setPassword(rs.getString("password"));
			}
			
			conn.close();
			ps.close();
			
			return result;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return null;
	}
	
	
	public void delete(String name) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "DELETE FROM staff WHERE fullName = '" + name + "'";
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			conn.close();
			statement.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}

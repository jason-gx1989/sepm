package common.junitUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.configration.DBConfig;
import entity.Shift;

public class AddShiftTestDao {

	public Shift getShiftByLoc(String location) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "SELECT * FROM shift WHERE location = '" + location + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			Shift getShift = null;
			
			if(rs.next()) {
				getShift = new Shift();
				getShift.setId(rs.getInt("id"));
				getShift.setStartTime(rs.getDate("startTime"));
				getShift.setEndTime(rs.getDate("endTime"));
				getShift.setDuration(rs.getDouble("duration"));
				getShift.setLocation(rs.getString("location"));
				getShift.setStaffAllocated(rs.getInt("staffAllocated"));
				getShift.setStatus(rs.getInt("status"));
				getShift.setRemark(rs.getString("remark"));
			}
			
			conn.close();
			ps.close();
			
			return getShift;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void deleteByLoc(String location) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "DELETE FROM shift WHERE location = '" + location + "'";
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

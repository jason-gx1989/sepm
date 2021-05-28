package common.junitUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.configration.DBConfig;

public class GetLastItemDao {
	public int getLastItemShiftId() throws SQLException {
		
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		String sql = "SELECT * FROM shift ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int shiftId=0;
		while(rs.next()) {
			
			shiftId=rs.getInt("id");
		}
		return shiftId;
	}
	
	public int getLastItemStaffId() throws SQLException {
		
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		String sql = "SELECT * FROM staff ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int staffId=0;
		while(rs.next()) {
			
			staffId=rs.getInt("id");
		}
		return staffId;
	}

}

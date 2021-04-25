package changeLimit;

import java.sql.*;
import java.util.ArrayList;
import common.configration.DBConfig;
import entity.Staff;


public class ChangeLimitDao {

	public void changeLimit(int id, double newLimit) {
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "UPDATE staff SET workHourLimit = " + newLimit + " WHERE id = " + id;
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			conn.close();
			statement.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	public ArrayList<Staff> getStaffList() {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from staff";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Staff> result = new ArrayList<Staff>();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setId(rs.getInt("id"));
				staff.setFullName(rs.getString("fullName"));
				staff.setWorkHourLimit(rs.getDouble("workHourLimit"));
				result.add(staff);
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
}

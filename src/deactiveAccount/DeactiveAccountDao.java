package deactiveAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.configration.DBConfig;
import common.utils.DBExecuteUtils;
import entity.ShiftManager;
import entity.Staff;

public class DeactiveAccountDao {
	
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
				staff.setHomeAddress(rs.getString("homeAddress"));
				staff.setMobileNumber(rs.getString("mobileNumber"));
				staff.setEmail(rs.getString("email"));
				staff.setPreferredName(rs.getString("preferredName"));
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
	
	public ArrayList<ShiftManager> getShiftManagerList() {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from shiftmanager";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<ShiftManager> result = new ArrayList<ShiftManager>();
			while (rs.next()) {

				ShiftManager shiftManager = new ShiftManager();
				shiftManager.setId(rs.getInt("id"));
				shiftManager.setFullName(rs.getString("fullName"));
				shiftManager.setMobileNumber(rs.getString("mobileNumber"));
				shiftManager.setEmail(rs.getString("email"));
				result.add(shiftManager);
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
	
	
	public void deactiveStaffAccount(int id) {
		
		String sql = "DELETE from staff where id =" + id;
		DBExecuteUtils.delete(sql);
	}
	
	public void deactiveManagerAccount(int id) {
		
		String sql = "DELETE from shiftmanager where id =" + id;
		DBExecuteUtils.delete(sql);
	}
}

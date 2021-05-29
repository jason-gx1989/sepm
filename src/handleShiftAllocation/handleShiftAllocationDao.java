package handleShiftAllocation;

import common.configration.DBConfig;
import entity.Shift;
import entity.Staff;

import java.sql.*;
import java.util.ArrayList;


public class handleShiftAllocationDao {

	public void changeShiftStatus(int id, int staffId, int newStatus) {
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "UPDATE shift SET status = " + newStatus + " WHERE id = " + id + "  AND staffAllocated = " + staffId;
			System.out.println(sql);
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			conn.close();
			statement.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	public ArrayList<Shift> getShiftList() {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from shift";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Shift> result = new ArrayList<Shift>();
			while (rs.next()) {
				Shift shift = new Shift();
				shift.setId(rs.getInt("id"));
				shift.setStaffAllocated(rs.getInt("staffAllocated"));
				shift.setStartTime(rs.getDate("startTime"));
				shift.setEndTime(rs.getDate("endTime"));
				shift.setDuration(rs.getDouble("duration"));
				shift.setLocation(rs.getString("location"));
				shift.setStatus(rs.getInt("status"));
				shift.setRemark(rs.getString("remark"));
				result.add(shift);
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

	public Shift getShift(int id) {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from shift where id = " + id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Shift shift = new Shift();
			while (rs.next()) {

				shift.setId(rs.getInt("id"));
				shift.setStaffAllocated(rs.getInt("staffAllocated"));
				shift.setStartTime(rs.getDate("startTime"));
				shift.setEndTime(rs.getDate("endTime"));
				shift.setDuration(rs.getDouble("duration"));
				shift.setLocation(rs.getString("location"));
				shift.setStatus(rs.getInt("status"));
				shift.setRemark(rs.getString("remark"));

			}

			conn.close();
			ps.close();

			return shift;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}

		return null;
	}


}

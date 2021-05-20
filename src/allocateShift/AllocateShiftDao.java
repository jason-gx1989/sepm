package allocateShift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.configration.DBConfig;
import entity.Shift;
import entity.Staff;

public class AllocateShiftDao {
	
	
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
				shift.setEndTime(rs.getDate("endTime"));
				shift.setStartTime(rs.getDate("startTime"));
				shift.setLocation(rs.getString("location"));
				shift.setStatus(rs.getInt("status"));
				shift.setDuration(rs.getDouble("duration"));
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
	
	public int allocateShift(int shiftId, int staffId) {
		int countrows=0;
		try {			
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "UPDATE shift SET staffAllocated = " + staffId + " WHERE id = " + shiftId;
			Statement statement = conn.createStatement();
			countrows =statement.executeUpdate(sql);			
			conn.close();
			statement.close();
			return countrows;
		}
		catch (SQLException se) {
			se.printStackTrace();
			return countrows;
		}
	}
	
	public boolean isInStaff(int staffId) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		String sql = "select * from staff where id ="+staffId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return true;
		else 
			return false;
		
	}
	
	public boolean isExceedWorkload(int shiftId, int staffId) throws SQLException
	{
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		String sql = "select * from shift where staffAllocated ="+staffId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		double sumworkload=0;
		while (rs.next()) {
			sumworkload+=rs.getDouble("duration");
		}
		double shiftduration = shiftduration(shiftId);
		double staffworkload = staffworkload(staffId);
        if(sumworkload+shiftduration>staffworkload)
        	return true;
        else
        	return false;
		
		
	}
	
	public double shiftduration(int shiftId) throws SQLException 
	{
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		String sql ="select * from shift where id ="+shiftId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getDouble("duration");
	}
	public double staffworkload(int staffId) throws SQLException 
	{
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		String sql ="select * from staff where id ="+staffId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getDouble("workHourLimit");
	}

}

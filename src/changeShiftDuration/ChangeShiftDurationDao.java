package changeShiftDuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.configration.DBConfig;
import entity.Shift;

public class ChangeShiftDurationDao {
	public int changeShiftDuration(int shiftId, double duration) {
		int countrows=0;
		try {			
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "UPDATE shift SET duration = " + duration + " WHERE id = " + shiftId;
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
	
public ArrayList<Shift> getShiftList() {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			
			// only the duration of unallocated shift can be changed
			String sql = "select * from shift where staffAllocated is null";
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

}

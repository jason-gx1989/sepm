package listShiftAllocationHistory;

import java.sql.*;
import java.util.ArrayList;

import common.configration.DBConfig;
import entity.Shift;
import entity.Staff;

public class listShiftAllocationHistoryDao {
	
	public ArrayList<Shift> getShiftAllocationHistory(String staffID) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from shift where staffAllocated = " + staffID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Shift> result = new ArrayList<Shift>();
			while(rs.next()) {
				Shift shift = new Shift();
				shift.setId(rs.getInt("id"));
				shift.setStartTime(rs.getDate("startTime"));
				shift.setEndTime(rs.getDate("endTime"));
				shift.setDuration(rs.getDouble("duration"));
				shift.setLocation(rs.getString("location"));
				shift.setStaffAllocated(rs.getInt("staffAllocated"));
				shift.setStatus(rs.getInt("status"));
				shift.setRemark(rs.getString("remark"));
				result.add(shift);
			}
			conn.close();
			ps.close();
			
			return result;
			
		} catch (SQLException se) {
			se.printStackTrace();
			
			return null;
		}
	}
}

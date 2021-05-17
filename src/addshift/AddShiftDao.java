package addshift;

import java.sql.*;
import common.configration.DBConfig;

public class AddShiftDao {
	
	public void addShift(java.sql.Date startTime, java.sql.Date endTime, double duration, String location, int staffAllocated, int status, String remark) {
		
		
		try {
//			String sql = "INSERT INTO ShiftManager(startTime, endTime, duration, location, staffAllocated, status, remark) VALUES " + "('" + startTime + "','" + endTime + "','" + duration + "','" + location + "','" + staffAllocated + "','" + status + "','" + remark + "')";
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			Statement s= conn.createStatement();
			System.out.println(duration + location + staffAllocated + status + remark);
			s.executeUpdate("INSERT INTO Shift(startTime, endTime, duration, location, staffAllocated, status, remark) VALUES " + "('" + startTime + "','" + endTime + "','" + duration + "','" + location + "','" + staffAllocated + "','" + status + "','" + remark + "')");
			conn.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

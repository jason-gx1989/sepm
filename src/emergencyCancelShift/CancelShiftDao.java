package emergencyCancelShift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.configration.DBConfig;
import entity.Shift;
import entity.ShiftManager;

public class CancelShiftDao {

	public int cancelShift(int shiftId) {

		// TODO 这里不需要把staffAllocated置为空，应该更新shift表中status字段，具体的值请参阅Shift
		// entity中status的注释。

		int countrows = 0;
		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME,
					DBConfig.DB_PASSWORD);
			String sql = "UPDATE shift SET staffAllocated = " + null + " WHERE id = " + shiftId;
			Statement statement = conn.createStatement();
			countrows = statement.executeUpdate(sql);
			conn.close();
			statement.close();
			return countrows;
		} catch (SQLException se) {
			se.printStackTrace();
			return countrows;
		}
	}

	public ArrayList<Shift> getStaffShiftList(int staffId) {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from shift WHERE staffAllocated = " + staffId;
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
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return null;
	}

	public ArrayList<ShiftManager> getShifManagertList() {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from shiftmanager";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<ShiftManager> result = new ArrayList<ShiftManager>();
			while (rs.next()) {
				ShiftManager shiftManager = new ShiftManager();
				shiftManager.setId(rs.getInt("id"));
				shiftManager.setEmail(rs.getString("email"));
				result.add(shiftManager);
			}

			conn.close();
			ps.close();

			return result;
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return null;
	}
}

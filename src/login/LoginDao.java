package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.configration.DBConfig;
import entity.ShiftManager;
import entity.Staff;

public class LoginDao {

	public Staff getLoginStaffByEmail(String email) {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from Staff where email = '" + email + "' limit 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			Staff staff = null;
			while (rs.next()) {
				staff = new Staff();
				staff.setId(rs.getInt("id"));
				staff.setEmail(rs.getString("email"));
				staff.setPassword(rs.getString("password"));
			}
			conn.close();
			ps.close();

			return staff;

		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

	public ShiftManager getLoginManagerByEmail(String email) {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from ShiftManager where email = '" + email + "' limit 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			ShiftManager shiftManager = null;
			while (rs.next()) {
				shiftManager = new ShiftManager();
				shiftManager.setId(rs.getInt("id"));
				shiftManager.setEmail(rs.getString("email"));
				shiftManager.setPassword(rs.getString("password"));
			}
			conn.close();
			ps.close();

			return shiftManager;

		} catch (SQLException se) {
			se.printStackTrace();

			return null;
		}
	}

}

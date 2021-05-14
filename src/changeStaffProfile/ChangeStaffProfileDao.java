package changeStaffProfile;

import common.configration.DBConfig;
import common.utils.DBExecuteUtils;
import entity.Staff;

import java.sql.*;


public class ChangeStaffProfileDao {


	public int changeStaffProfile(int id, String fullName, String mobileNumber, String email, String workHourLimit, String preferredName, String homeAddress) {

		String sql = "UPDATE staff SET fullName = " + "'" + fullName + "'" + ", mobileNumber = " + mobileNumber
				   + ", email = " + "'" + email + "'"  + ", workHourLimit = "  + workHourLimit +
				", preferredName = " + "'" + preferredName + "'" + ",  homeAddress = " + "'" +  homeAddress+ "'" + " WHERE id = " + id;
		return DBExecuteUtils.update(sql);
	}

	public Staff getStaffProFile(int id) {


		Staff staff = new Staff();
		try {
			String sql = "SELECT * from staff where id = " + id;
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				staff.setId(rs.getInt("id"));
				staff.setFullName(rs.getString("fullName"));
				staff.setWorkHourLimit(rs.getDouble("mobileNumber"));
				staff.setEmail(rs.getString("email"));
				staff.setMobileNumber(rs.getString("mobileNumber"));
				staff.setPreferredName(rs.getString("preferredName"));
				staff.setHomeAddress(rs.getString("homeAddress"));
			}

			conn.close();
			ps.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return staff;
	}
}

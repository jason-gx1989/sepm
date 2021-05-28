package changePassword;

import common.configration.DBConfig;
import common.utils.DBExecuteUtils;
import entity.Staff;

import java.sql.*;
import java.util.ArrayList;


public class ChangePasswordDao {

	public int changePassword(String fullName, String oldPassword, String newPassword) {

		String password = "";
		try {
			String sql = "SELECT password from staff where fullName = " + "'" +fullName + "'";
			System.out.println(sql);
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
			}

			conn.close();
			ps.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		// check empty password
		if (password.equals("")){
			return 0; 
		}
		
		// check incorrect passeword
		if (!password.equals(oldPassword)){
			System.out.println("old" + oldPassword);
			System.out.println("pass" + password);
			return -1; 
		}
		
		else {
			String sql = "UPDATE staff SET password = " + "'" + newPassword + "'" + " WHERE fullName = " + "'" + fullName + "'" ;
			DBExecuteUtils.update(sql);
			return 1;
		}
	}

}

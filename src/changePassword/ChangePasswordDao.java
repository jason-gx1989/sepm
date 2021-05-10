package changePassword;

import common.configration.DBConfig;
import common.utils.DBExecuteUtils;
import entity.Staff;

import java.sql.*;
import java.util.ArrayList;

public class ChangePasswordDao {

	public int changePassword(String fullName, String oldPassword, String newPassword) {

		// TODO staff表中 isPasswordUpdated 字段也需要更新，因为这个字段会用来判断新创建的用户是否在9小时内修改了密码。

		// TODO 应该把用fullName查询用户改成用id，因为fullName有可能重复。并且用户在登录的状态下修改密码是不需要再输入名字的。
		
	

		String password = "";
		try {
			String sql = "SELECT password from staff where fullName = " + "'" + fullName + "'";
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
		if (password.equals("")) {
			return 0; // 没有这个人
		}
		if (!password.equals(oldPassword)) {
			System.out.println("old" + oldPassword);
			System.out.println("pass" + password);
			return -1; // 密码不正确
		} else {
			String sql = "UPDATE staff SET password = " + "'" + newPassword + "'" + " WHERE fullName = " + "'"
					+ fullName + "'";
			DBExecuteUtils.update(sql);
			return 1;
		}
	}

}

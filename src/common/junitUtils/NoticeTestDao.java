package common.junitUtils;

import entity.Notice;
import java.sql.*;
import common.configration.DBConfig;
import common.utils.Utils;


public class NoticeTestDao {

	public Notice getLatestNotice() {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "SELECT * from `notice` ORDER BY `sendTime` DESC LIMIT 1";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Notice notice = null;
			while (rs.next()) {
				notice = new Notice();
				notice.setId(rs.getInt("id"));
				notice.setType(rs.getString("type"));
				notice.setFrom(rs.getInt("from"));
				notice.setTo(rs.getInt("to"));
				notice.setStatus(rs.getString("status"));
				notice.setSendTime(rs.getDate("sendTime"));
			}
			
			conn.close();
			ps.close();
			
			return notice;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return null;
	}
	
	
	public void deleteLatestNotice() {
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "DELETE FROM `notice` WHERE `id` = " + getLatestNotice().getId();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			conn.close();
			statement.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}

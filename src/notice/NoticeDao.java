package notice;

import java.sql.*;
import java.util.ArrayList;
import common.configration.DBConfig;
import common.utils.Utils;
import entity.Notice;


public class NoticeDao {

	public void insertNotice(String type, int from, int to) {
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "INSERT INTO NOTICE (`type`, `from`, `to`, `status`, `sendTime`) VALUES ('" + type + "','" + from + "','" + to + "','" + "0" + "','" + Utils.getCurrentTime() + "')";
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			
			conn.close();
			statement.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	public Notice getNotice(int to, String type) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "SELECT * from notice WHERE `to` = " + to + " AND `type` = " + type + " AND `status` = '0' ORDER BY sendTime DESC LIMIT 1";
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
	
	
	public void updateStatus(int id, String status) {
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "UPDATE notice SET `status` = " + status + " WHERE id = " + id;
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

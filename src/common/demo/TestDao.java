package common.demo;
//package common;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import common.configration.DBConfig;
//import entity.ShiftManager;
//
//public class TestDao {
//	
//	public static void main(String[] args) {
//		System.out.println(111);
//	}
//
//	public void add(String email, String password) {
//		//
//
//		try {
//			String sql = "INSERT INTO ShiftManager(email,password) VALUES " + "('" + email + "','" + password + "')";
//			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
//			PreparedStatement ps = conn.prepareStatement(sql);
////			ps.setString(1, email);
////			ps.setString(2, password);
//			ps.executeUpdate(sql);
//			conn.close();
//			ps.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public ShiftManager getByEmail(String email) {
//		try {
//			String sql = " select * from ShiftManager where email = ?";
//			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, email);
//			ResultSet rs = ps.executeQuery();
//			ShiftManager result = null;
//			while (rs.next()) {
//				result = new ShiftManager();
//				result.setId(rs.getInt("id"));
//				result.setEmail(rs.getString("email"));
//			}
//
//			conn.close();
//			ps.close();
//			return result;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}

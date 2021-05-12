package vslWorkload;

import java.sql.*;
import java.util.HashMap;
import common.configration.DBConfig;


public class VslWorkloadDao {
	
	
	
	/**
	 * @param timeFrame 1 - weekly; 2 - monthly
	 */
	public HashMap<String, Double> getWorkloadByStaff(int timeFrame) {
		
		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			
			String sql = null;
			if (timeFrame == 1)
				sql = "SELECT `fullName`, SUM(`duration`) AS `workload` "
						+ "FROM `staff` JOIN `shift` ON `staff`.`id` = `shift`.`staffAllocated` "
						+ "WHERE YEAR(`shift`.`startTime`) = YEAR(CURDATE()) "
						+ "AND WEEK(`shift`.`startTime`) = WEEK(CURDATE()) "
						+ "GROUP BY `staff`.`id` "
						+ "ORDER BY `staff`.`id`";
			else
				sql = "SELECT `fullName`, SUM(`duration`) AS `workload` "
						+ "FROM `staff` JOIN `shift` ON `staff`.`id` = `shift`.`staffAllocated` "
						+ "WHERE YEAR(`shift`.`startTime`) = YEAR(CURDATE()) "
						+ "AND MONTH(`shift`.`startTime`) = MONTH(CURDATE()) "
						+ "GROUP BY `staff`.`id` "
						+ "ORDER BY `staff`.`id`";
				
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			HashMap<String, Double> result = new HashMap<String, Double>();
			while (rs.next()) {
				result.put(rs.getString("fullName"), rs.getDouble("workload"));
			}
			
			conn.close();
			ps.close();
			
			return result;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		
		return null;
	}
}

package staffdetail.calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.configration.DBConfig;

public class StaffCalendarDao {

	public List<StaffCalendarPojo> get(int staffId, int year, int month) {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);

			String sql = "SELECT " + 
						"staffAllocated AS staffId," + 
						"DATE_FORMAT(startTime, '%d') AS startDate,"+
						"DATE_FORMAT(startTime, '%m') AS startMonth," + 
						"DATE_FORMAT(startTime, '%Y') AS startYear,"+
						"DATE_FORMAT(endTime, '%d') AS endDate,"+
						"DATE_FORMAT(endTime, '%m') AS endMonth," + 
						"DATE_FORMAT(endTime, '%Y') AS endYear,"+
						"status AS status" + " FROM SHIFT" +
						" WHERE " + 
						"((DATE_FORMAT(startTime, '%m') = ?" + 
						" AND DATE_FORMAT(startTime, '%Y') = ?)"+
						" OR "+
						" (DATE_FORMAT(endtime, '%m') = ?" + 
						" AND DATE_FORMAT(endtime, '%Y') = ?))"+
						" AND " + 
						"staffAllocated = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, month);
			ps.setInt(2, year);
			ps.setInt(3, month);
			ps.setInt(4, year);
			ps.setInt(5, staffId);
			ResultSet rs = ps.executeQuery();
			
//			 System.out.println("staffId >> " + staffId);
//			 System.out.println("sql >> " + sql);
			List<StaffCalendarPojo> pojoList = new ArrayList<StaffCalendarPojo>();
			while (rs.next()) {
				StaffCalendarPojo pojo = new StaffCalendarPojo();
				
				pojo.setStartDate(rs.getInt("startDate"));
				pojo.setStartMonth(rs.getInt("startMonth"));
				pojo.setStartYear(rs.getInt("startYear"));
				pojo.setEndDate(rs.getInt("endDate"));
				pojo.setEndMonth(rs.getInt("endMonth"));
				pojo.setEndYear(rs.getInt("endYear"));
				pojo.setStaffId(rs.getInt("staffId"));
				pojo.setStatus(rs.getInt("status"));
				
				pojoList.add(pojo);
			}

			conn.close();
			ps.close();

			return pojoList;
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return null;

	}

}

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import common.configration.DBConfig;
import staffdetail.calendar.StaffCalendarDao;
import staffdetail.calendar.StaffCalendarPojo;
import staffdetail.calendar.StaffCalendarService;

public class StaffCalendarTest {

	private StaffCalendarDao dao;
	private StaffCalendarService service;

	@Before
	public void initialization() {
		//

		try {
			Connection conn = (Connection) DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME,
					DBConfig.DB_PASSWORD);
			String sql = "INSERT INTO SHIFT (`startTime`, `endTime`, `duration`, `location`, `staffAllocated`, `status`, `remark`) VALUES ('2021-05-28 00:00:00','2021-05-29 01:00:00',25,'test location','1','0','xxx')";
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			conn.close();
			statement.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		dao = new StaffCalendarDao();
		service = new StaffCalendarService();

	}

	@Test
	public void testGetStaffCalendarPojo() {

		List<StaffCalendarPojo> result = dao.get(1, 2021, 05);

		int n = result.size();

		Assert.assertEquals(n >= 1, true);

	}

	@Test
	public void testGetStaffCalendarPojo_incorrectInput() {

		List<StaffCalendarPojo> result = dao.get(-1, 2021, 05);

		int n = result.size();

		Assert.assertEquals(n == 0, true);

	}

	@Test
	public void testGetCalendarStr_case1() {

		String s = service.getCalendarStr(1, 2021, 05);
		int i = s.indexOf("28");

		Assert.assertEquals(i != -1, true);

	}

	@Test
	public void testGetCalendarStr_case2() {

		String s = service.getCalendarStr(1, 2021, 05);
		int i = s.indexOf("29");

		Assert.assertEquals(i != -1, true);

	}

	@Test
	public void testGetCalendarStr_case3() {

		String s = service.getCalendarStr(-1, 2021, 05);
		int i = s.indexOf("28");

		Assert.assertEquals(i == -1, true);

	}

	@Test
	public void testGetCalendarStr_case4() {

		String s = service.getCalendarStr(-1, 2021, 05);
		int i = s.indexOf("29");

		Assert.assertEquals(i == -1, true);

	}
}

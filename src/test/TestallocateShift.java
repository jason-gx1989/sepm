package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import allocateShift.AllocateShiftService;
import common.configration.DBConfig;
import common.junitUtils.GetLastItemDao;

public class TestallocateShift {
	public Connection conn;
	public AllocateShiftService service ;
	int shiftId ;
	int staffId ;

	@Before
	//initialize test data
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service = new AllocateShiftService();
		GetLastItemDao dao = new GetLastItemDao();
		Statement statement = conn.createStatement();
		statement.executeUpdate("INSERT INTO `shift` (`status`) VALUES ('0')");
		statement.executeUpdate("INSERT INTO `staff` (`fullName`) VALUES ('testee')");
		shiftId = dao.getLastItemShiftId();
		staffId = dao.getLastItemStaffId();
		
	}

	@After
	//delete test data
	public void tearDown() throws Exception {
		Statement statement = conn.createStatement();
		statement.executeUpdate("DELETE FROM `staff` WHERE (`id` = '"+staffId+"')");
		statement.executeUpdate("DELETE FROM `shift` WHERE (`id` = '"+shiftId+"')");
		conn.close();
	}

	@Test
	public void testallocateShift() throws SQLException {
		service.allocateShift(shiftId, staffId);
		String sql = "select * from shift where id = "+shiftId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int staffIdMysql =rs.getInt("staffAllocated");
		int statusMysql = rs.getInt("status");
		//test id
		assertEquals(staffId, staffIdMysql,0);
		//test status
		assertEquals(1, statusMysql,0);
		ps.close();
	}

}

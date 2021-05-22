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
import emergencyCancelShift.CancelShiftService;

public class CancelShiftTest{
	public Connection conn;
	public CancelShiftService service ;
	int shiftId ;
	int staffId ;

	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service = new CancelShiftService();
		Statement statement = conn.createStatement();
		statement.executeUpdate("INSERT INTO `shift` (`id`) VALUES ('5')");
		statement.executeUpdate("INSERT INTO `staff` (`id`) VALUES ('5')");	
		statement.executeUpdate("UPDATE shift SET staffAllocated = 5 WHERE id = 5");
		shiftId = 5;
		staffId = 5;
		
	}

	@After
	public void tearDown() throws Exception {
		Statement statement = conn.createStatement();
		statement.executeUpdate("DELETE FROM `staff` WHERE (`id` = '5')");
		statement.executeUpdate("DELETE FROM `shift` WHERE (`id` = '5')");
		conn.close();
	}

	@Test
	public void testcancelShift() throws SQLException {
		
		String sql = "select * from shift where id = "+shiftId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int staffIdMysqlbefore =rs.getInt("staffAllocated");
		assertTrue(staffIdMysqlbefore!=0);
		service.cancelShift(shiftId);
		String sql2 = "select * from shift where id = "+shiftId;
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ResultSet rs2 = ps2.executeQuery();
		rs2.next();
		int staffIdMysql =rs2.getInt("staffAllocated");
		int statusMysql = rs2.getInt("status");
		//test Id
		assertEquals(5, staffIdMysql,0);
		//test status
		assertEquals(4, statusMysql,0);
		ps.close();
	}

}
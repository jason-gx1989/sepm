package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import allocateShift.AllocateShiftService;
import common.configration.DBConfig;
import emergencyCancelShift.CancelShiftService;

public class CancelShiftTest{
	public Connection conn;
	public CancelShiftService service ;

	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service = new CancelShiftService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testcancelShift() throws SQLException {
		int shiftId = 1;
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
		assertEquals(0, staffIdMysql,0);
		conn.close();
		ps.close();
	}

}
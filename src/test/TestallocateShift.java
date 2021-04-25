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

public class TestallocateShift {
	public Connection conn;
	public AllocateShiftService service ;

	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service = new AllocateShiftService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testallocateShift() throws SQLException {
		int shiftId = 1;
		int staffId = 2;
		service.allocateShift(shiftId, staffId);
		String sql = "select * from shift where id = "+shiftId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int staffIdMysql =rs.getInt("staffAllocated");
		assertEquals(staffId, staffIdMysql,0);
		conn.close();
		ps.close();
	}

}

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
		GetLastItemDao dao = new GetLastItemDao();
		Statement statement = conn.createStatement();
		statement.executeUpdate("INSERT INTO `shift` (`status`) VALUES ('0')");
		statement.executeUpdate("INSERT INTO `staff` (`fullName`) VALUES ('testee')");
		//retrieve id
		shiftId = dao.getLastItemShiftId();
		staffId = dao.getLastItemStaffId();
		statement.executeUpdate("UPDATE shift SET staffAllocated = "+staffId+" WHERE id = "+shiftId);		
		
	}

	@After
	public void tearDown() throws Exception {
		Statement statement = conn.createStatement();
		statement.executeUpdate("DELETE FROM `staff` WHERE (`id` = '"+staffId+"')");
		statement.executeUpdate("DELETE FROM `shift` WHERE (`id` = '"+shiftId+"')");
		conn.close();
	}

	@Test
	public void testcancelShift() throws SQLException {
		
		String sql = "select * from shift where id = "+shiftId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int staffIdMysqlbefore =rs.getInt("staffAllocated");
		assertTrue(staffIdMysqlbefore==staffId);
		service.cancelShift(shiftId);
		String sql2 = "select * from shift where id = "+shiftId;
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ResultSet rs2 = ps2.executeQuery();
		rs2.next();
		int staffIdMysqlAfter =rs2.getInt("staffAllocated");
		int statusMysqlAfter = rs2.getInt("status");
		//test Id
		assertEquals(staffIdMysqlbefore, staffIdMysqlAfter,0);
		//test status 
		//after cancellation status changed into  4
		assertEquals(4, statusMysqlAfter,0);
		ps.close();
	}

}
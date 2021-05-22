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
import org.junit.BeforeClass;
import org.junit.Test;

import changeShiftDuration.ChangeShiftDurationService;
import common.configration.DBConfig;
import emergencyCancelShift.CancelShiftService;

public class ChangeDurationTest {
	public Connection conn;
	public ChangeShiftDurationService service ;
	int shiftId ;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service = new ChangeShiftDurationService();
		Statement statement = conn.createStatement();
		statement.executeUpdate("INSERT INTO `shift` (`id`) VALUES ('5')");		
		statement.executeUpdate("UPDATE shift SET duration = 5.0 WHERE id = 5");
		shiftId = 5;
	}

	@After
	public void tearDown() throws Exception {
		Statement statement = conn.createStatement();		
		statement.executeUpdate("DELETE FROM `shift` WHERE (`id` = '5')");
		conn.close();
	}

	@Test
	public void testChangeShiftDuration() throws SQLException {
		String sql = "select * from shift where id = "+shiftId;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		double durationMysqlbefore =rs.getDouble("duration");
		assertTrue(durationMysqlbefore==5.0);
		service.changeShiftDuration(shiftId, 2.2);
		String sql2="select * from shift where id = "+shiftId;
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ResultSet rs2 = ps2.executeQuery();
		rs2.next();
		double durationMysql =rs2.getDouble("duration");
		assertTrue(durationMysql==2.2);
		ps.close();
	}

}

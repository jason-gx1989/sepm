package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import addshift.AddShiftService;
import allocateShift.AllocateShiftService;
import common.configration.DBConfig;
import common.junitUtils.AddShiftTestDao;
import entity.Shift;
import listShiftAllocationHistory.listShiftAllocationHistoryDao;

public class TestListShiftAllocationHistory {

	public Connection conn;
	public listShiftAllocationHistoryDao dao;
	public AllocateShiftService service1;
	public AddShiftService addShiftService;
	public AddShiftTestDao addShiftTestDao;
	public String location;
	
	public int shiftId;
	public int staffId;

	
	@Before
	public void setUp() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service1 = new AllocateShiftService();
		dao = new listShiftAllocationHistoryDao();
		addShiftService = new AddShiftService();
		addShiftTestDao = new AddShiftTestDao();
	
		location = "MD";
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		shiftId = addShiftTestDao.getShiftByLoc(location).getId();
		//query staff id
		service1.allocateShift(shiftId, 1);
		
	}
	
	@Test
	public void testListShiftDuration() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		double duration = shift.getDuration();
		assertEquals("duration incorrect", 5, duration,0.0);
		
	}
	
	@Test
	public void testListShiftLocation() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		String loc = shift.getLocation();
		assertEquals("location incorrect", location, loc);
	}
	
	@Test
	public void testListShiftStaffAllocated() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		int staff = shift.getStaffAllocated();
		assertEquals("staffAllocated incorrect", 1, staff);

	}
	
	
	@Test
	public void testListShiftRemark() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		String remark = shift.getRemark();
		assertEquals("remark incorrect", "Pause", remark);
	}


	@After
	public void teraDown() {
		
		addShiftTestDao.deleteByLoc(location);
	}

}

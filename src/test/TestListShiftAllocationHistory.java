package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import addshift.AddShiftService;
import addstaff.StaffService;
import allocateShift.AllocateShiftService;
import common.configration.DBConfig;
import common.junitUtils.AddShiftTestDao;
import common.utils.DBExecuteUtils;
import entity.Shift;
import entity.Staff;
import listShiftAllocationHistory.listShiftAllocationHistoryDao;

public class TestListShiftAllocationHistory {

	public Connection conn;
	public listShiftAllocationHistoryDao dao;
	public AllocateShiftService service1;
	public AddShiftService addShiftService;
	public AddShiftTestDao addShiftTestDao;
	public String location;
	public StaffService staffService;
	public Staff staff;
	
	public int shiftId;
	public int staffId;

	
	@Before
	public void setUp() throws SQLException {
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		service1 = new AllocateShiftService();
		dao = new listShiftAllocationHistoryDao();
		addShiftService = new AddShiftService();
		addShiftTestDao = new AddShiftTestDao();
		staffService = new StaffService();
        staff = new Staff();
        
        staff.setFullName("test");
        staff.setPassword("123234");
        staff.setMobileNumber("13567765785");
        staff.setEmail("32354346@gmail.com");
        staff.setPreferredName("alice");
        staff.setHomeAddress("wewqrwe");

        staffService.createStaff(staff.getFullName(),staff.getPassword(), staff.getMobileNumber(), staff.getEmail(),staff.getPreferredName(), staff.getHomeAddress());
        String sql = " select * from staff where mobileNumber  = " + staff.getMobileNumber();
        Staff rs = DBExecuteUtils.queryStaff(sql);
        staffId = rs.getId();
		location = "MD";
		
		
	}
	
	@Test
	public void testListShiftDuration() throws SQLException {
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		shiftId = addShiftTestDao.getShiftByLoc(location).getId();
		
		service1.allocateShift(shiftId, staffId);
		double duration = 0;
		for(Shift shift : dao.getShiftAllocationHistory(staffId)) {
			if(shift.getLocation().equals(location)) {
				duration = shift.getDuration();
			}
		}
		
		assertEquals(5, duration,0.0);
		
	}
	
	@Test
	public void testListShiftLocation() throws SQLException {
		
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		shiftId = addShiftTestDao.getShiftByLoc(location).getId();
		
		service1.allocateShift(shiftId, staffId);
		String loc = null;
		for(Shift shift : dao.getShiftAllocationHistory(staffId)) {
			if(shift.getLocation().equals(location)) {
				loc = shift.getLocation();
			}
		}
		assertEquals(location, loc);
	}
	
	@Test
	public void testListShiftStaffAllocated() throws SQLException {
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		shiftId = addShiftTestDao.getShiftByLoc(location).getId();
		
		service1.allocateShift(shiftId, staffId);
		int staff = 0;
		for(Shift shift : dao.getShiftAllocationHistory(staffId)) {
			if(shift.getLocation().equals(location)) {
				staff = shift.getStaffAllocated();
			}
		}
		assertEquals(staffId, staff);

	}
	
	
	@Test
	public void testListShiftRemark() throws SQLException {
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		shiftId = addShiftTestDao.getShiftByLoc(location).getId();
		
		service1.allocateShift(shiftId, staffId);
		String remark = null;
		for(Shift shift : dao.getShiftAllocationHistory(staffId)) {
			if(shift.getLocation().equals(location)) {
				remark = shift.getRemark();
			}
		}

		assertEquals("Pause", remark);
	}


	@After
	public void teraDown() {
		
		addShiftTestDao.deleteByLoc(location);
		String sql = " delete from staff where mobileNumber  = 13567765785";
        DBExecuteUtils.delete(sql);
	}

}

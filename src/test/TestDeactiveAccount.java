package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import addshiftManager.ShiftManagerService;
import addstaff.StaffService;
import common.utils.DBExecuteUtils;
import entity.ShiftManager;
import entity.Staff;

public class TestDeactiveAccount {
	 
	 public ShiftManagerService shiftManagerService;
	 public ShiftManager shiftManager;
	 public  StaffService staffService;
	 public Staff staff;
	 
	@Before
	public void setUp() throws Exception {
		
		staffService = new StaffService();
        staff = new Staff();
        shiftManagerService = new ShiftManagerService();
        shiftManager = new ShiftManager();
        
        staff.setFullName("test");
        staff.setPassword("123234");
        staff.setMobileNumber("13567765785");
        staff.setEmail("32354346@gmail.com");
        staff.setPreferredName("alice");
        staff.setHomeAddress("wewqrwe");

        staffService.createStaff(staff.getFullName(),staff.getPassword(), staff.getMobileNumber(), staff.getEmail(),staff.getPreferredName(), staff.getHomeAddress());
        
        shiftManager.setFullName("test");
        shiftManager.setPassword("123234");
        shiftManager.setMobileNumber("13567765785");
        shiftManager.setEmail("32354346@gmail.com");

        shiftManagerService.addShiftManager(shiftManager.getFullName(),shiftManager.getPassword(), shiftManager.getMobileNumber(), shiftManager.getEmail());
	}

	@After
	public void tearDown() throws Exception {
		String sql = " delete from staff where mobileNumber  = 13567765785";
        DBExecuteUtils.delete(sql);
        String sql2 = " delete from shiftManager where mobileNumber  = 13567765785";
		DBExecuteUtils.delete(sql2);
	}

	@Test
	public void testDeactiveStaffAccount() {
		String sql = " select * from staff where mobileNumber  = " + staff.getMobileNumber();
        Staff rs = DBExecuteUtils.queryStaff(sql);
        
        Assert.assertEquals(staff.getFullName(), rs.getFullName());
        Assert.assertEquals(staff.getPassword(), rs.getPassword());
        Assert.assertEquals(staff.getMobileNumber(), rs.getMobileNumber());
        Assert.assertEquals(staff.getEmail(), rs.getEmail());
        Assert.assertEquals(staff.getPreferredName(), rs.getPreferredName());
        Assert.assertEquals(staff.getHomeAddress(), rs.getHomeAddress());
        
	}
	
	@Test
	public void testDeactiveManagerAccount() {
		String sql = " select * from shiftManager where mobileNumber  = " + shiftManager.getMobileNumber();
        ShiftManager rs = DBExecuteUtils.queryShiftManager(sql);


        Assert.assertEquals(shiftManager.getFullName(), rs.getFullName());
        Assert.assertEquals(shiftManager.getPassword(), rs.getPassword());
        Assert.assertEquals(shiftManager.getMobileNumber(), rs.getMobileNumber());
        Assert.assertEquals(shiftManager.getEmail(), rs.getEmail());
	}

}

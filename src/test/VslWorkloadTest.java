package test;

import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import addshift.AddShiftService;
import addstaff.StaffService;
import allocateShift.AllocateShiftService;
import common.junitUtils.AddShiftTestDao;
import common.junitUtils.StaffTestDao;
import common.utils.Utils;
import entity.Shift;
import entity.Staff;
import vslWorkload.VslWorkloadService;


public class VslWorkloadTest {
	
	static StaffService staffService;
	static StaffTestDao staffTestDao;
	static AddShiftService shiftService;
	static AddShiftTestDao shiftTestDao;
	static AllocateShiftService allocateShiftService;
	static VslWorkloadService vslWorkloadService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		staffService = new StaffService();
		staffTestDao = new StaffTestDao();
		shiftService = new AddShiftService();
		shiftTestDao = new AddShiftTestDao();
		allocateShiftService = new AllocateShiftService();
		vslWorkloadService = new VslWorkloadService();
		
		// Add new staff
		staffService.createStaff("This is a tester", null, null, null, null, null);
		Staff staff = staffTestDao.getByName("This is a tester");
		
		// Create different dates for shifts
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(System.currentTimeMillis());
		
		Calendar lastMonth = Calendar.getInstance();
		lastMonth.setTimeInMillis(System.currentTimeMillis());
		lastMonth.add(Calendar.MONTH, -1);
		
		Calendar lastWeek = Calendar.getInstance();
		lastWeek.setTimeInMillis(System.currentTimeMillis());
		lastWeek.add(Calendar.WEEK_OF_YEAR, -1);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		// Add new shift
		shiftService.addShift(formatter.format(today.getTime()), formatter.format(today.getTime()), "1.5", "This is testing location 1", null);
		shiftService.addShift(formatter.format(today.getTime()), formatter.format(today.getTime()), "3", "This is testing location 2", null);
		shiftService.addShift(formatter.format(lastMonth.getTime()), formatter.format(lastMonth.getTime()), "2", "This is testing location 3", null);
		shiftService.addShift(formatter.format(lastWeek.getTime()), formatter.format(lastWeek.getTime()), "5.5", "This is testing location 4", null);
		
		Shift shift1 = shiftTestDao.getShiftByLoc("This is testing location 1");
		Shift shift2 = shiftTestDao.getShiftByLoc("This is testing location 2");
		Shift shift3 = shiftTestDao.getShiftByLoc("This is testing location 3");
		Shift shift4 = shiftTestDao.getShiftByLoc("This is testing location 4");
		
		// Allocate shift to staff
		allocateShiftService.allocateShift(shift1.getId(), staff.getId());
		allocateShiftService.allocateShift(shift2.getId(), staff.getId());
		allocateShiftService.allocateShift(shift3.getId(), staff.getId());
		allocateShiftService.allocateShift(shift4.getId(), staff.getId());
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		// Delete shift used for testing
		shiftTestDao.deleteByLoc("This is testing location 1");
		shiftTestDao.deleteByLoc("This is testing location 2");
		shiftTestDao.deleteByLoc("This is testing location 3");
		shiftTestDao.deleteByLoc("This is testing location 4");
		
		// Delete staff used for testing
		staffTestDao.delete("This is a tester");
	}
	
	
	@Test
	public void testWeeklyWorkload() {
		HashMap<String, Double> weeklyWorkload = vslWorkloadService.getWorkloadByStaff(1);
		assertEquals(4.5, weeklyWorkload.get("This is a tester").doubleValue(), 0.1);
	}
	
	
	@Test
	public void testMonthlyWorkload() {
		HashMap<String, Double> monthlyWorkload = vslWorkloadService.getWorkloadByStaff(2);
		assertEquals(10, monthlyWorkload.get("This is a tester").doubleValue(), 0.1);
	}
}

package test;

import static org.junit.Assert.*;
import org.junit.*;
import addstaff.StaffService;
import changeLimit.ChangeLimitService;
import common.junitUtils.StaffTestDao;


public class changeLimitTest {
	
	private ChangeLimitService changeLimitservice = new ChangeLimitService();
	private StaffService staffService = new StaffService();
	private StaffTestDao staffTestDao = new StaffTestDao();
	private final String name = "Nier";
	private final double newLimit = 40;
	
	
	@Before
	public void setUp() {
		
		// Insert new staff into database
		staffService.createStaff(name, null, null, null, null, null);
		
		// Retrieve staff from database
		int id = staffTestDao.getByName(name).getId();
		
		// Change work limit
		changeLimitservice.changeLimit(id, newLimit);
	}
	
	
	@Test
	public void testLimit() {
		
		assertEquals(newLimit, staffTestDao.getByName(name).getWorkHourLimit(), 0.1);
	}
	
	@After
	public void tearDown() {
		
		// Delete test data from database
		staffTestDao.delete(name);
	}
}

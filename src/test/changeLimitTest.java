package test;

import static org.junit.Assert.*;
import org.junit.*;
import addstaff.StaffService;
import changeLimit.ChangeLimitService;
import common.junitUtils.StaffTestDao;

public class changeLimitTest {

	private ChangeLimitService changeLimitservice;
	private StaffService staffService;
	private StaffTestDao staffTestDao;

	String name;
	Double newLimit;
	int id;

	@Before
	public void setUp() {
		changeLimitservice = new ChangeLimitService();
		staffService = new StaffService();
		staffTestDao = new StaffTestDao();

		name = "Nier";
		newLimit = 40d;

		// Insert new staff into database
		staffService.createStaff(name, null, null, null, null, null);
		
		// Retrieve staff from database
		id = staffTestDao.getByName(name).getId();
	}

	@Test
	public void testValidLimit() {
		// Change work limit to a valid value
		changeLimitservice.changeLimit(id, newLimit);

		// Assert the current limit is the new limit specified
		assertEquals(newLimit, staffTestDao.getByName(name).getWorkHourLimit(), 0.1);
	}

	@Test
	public void testNegativeLimit() {
		// Change work limit to a valid value
		changeLimitservice.changeLimit(id, newLimit);
		
		// Change work limit to a negative value
		changeLimitservice.changeLimit(id, -10d);
		
		// Assert the current limit has not been changed to negative
		assertEquals(newLimit, staffTestDao.getByName(name).getWorkHourLimit(), 0.1);
	}

	@After
	public void tearDown() {

		// Delete test data from database
		staffTestDao.delete(name);
	}
}

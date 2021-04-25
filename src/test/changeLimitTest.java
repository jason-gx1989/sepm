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

	@Before
	public void setUp() {
		changeLimitservice = new ChangeLimitService();
		staffService = new StaffService();
		staffTestDao = new StaffTestDao();

		name = "Nier";
		newLimit = 40d;

	}

	@Test
	public void testLimit() {

		// Insert new staff into database
		staffService.createStaff(name, null, null, null, null, null);

		// Retrieve staff from database
		int id = staffTestDao.getByName(name).getId();

		// Change work limit
		changeLimitservice.changeLimit(id, newLimit);

		// assert
		assertEquals(newLimit, staffTestDao.getByName(name).getWorkHourLimit(), 0.1);
	}

	@After
	public void tearDown() {

		// Delete test data from database
		staffTestDao.delete(name);
	}
}

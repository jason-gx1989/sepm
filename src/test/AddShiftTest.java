package test;

import static org.junit.Assert.*;

import org.junit.*;

import addshift.AddShiftService;
import common.junitUtils.AddShiftTestDao;

public class AddShiftTest {
	private AddShiftService addShiftService;
	private AddShiftTestDao addShiftTestDao;

	private String location;

	@Before
	public void setUp() {

		addShiftService = new AddShiftService();
		addShiftTestDao = new AddShiftTestDao();

		location = "MD";
	}

	@Test
	public void testAddShift() {

		// Insert new shift
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", location, "1", "0");

		// Query the data from the database
		double duration = addShiftTestDao.getShiftByLoc(location).getDuration();

		// AssertTrue
		assertTrue(duration == 5);
	}

	@After
	public void tearDown() {

		addShiftTestDao.deleteByLoc(location);
	}
}

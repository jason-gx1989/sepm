package test;

import static org.junit.Assert.*;

import org.junit.*;

import addshift.AddShiftService;
import common.junitUtils.AddShiftTestDao;
import common.utils.Utils;

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
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");

		// Query the data from the database
		double duration = addShiftTestDao.getShiftByLoc(location).getDuration();
		String remark = addShiftTestDao.getShiftByLoc(location).getRemark();
		String location1 = addShiftTestDao.getShiftByLoc(location).getLocation();
		java.sql.Date startTime = addShiftTestDao.getShiftByLoc(location).getStartTime();

		// AssertTrue
		assertTrue(duration == 5);
		assertEquals("Pause", remark);
		assertEquals("MD", location1);
	}
	
	@Test
	public void testStratTime() {
		// Insert new shift
		java.sql.Date expectedTime = Utils.timeFormat("2021-04-25 00:00:00");
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		java.sql.Date startTime = addShiftTestDao.getShiftByLoc(location).getStartTime();
		//AssertEquals
		assertEquals(expectedTime, startTime);;
		
	}
	
	@Test
	public void testEndTime() {
		// Insert new shift
		java.sql.Date expectedTime = Utils.timeFormat("2021-04-26 00:00:00");
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
		java.sql.Date endTime = addShiftTestDao.getShiftByLoc(location).getEndTime();
		//AssertEquals
		assertEquals(expectedTime, endTime);
		
	}
	
	
	@Test
	public void testDurationIsNumeric1() {
		
		//Insert new shift(duration is "A")
		String r = addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "A", location, "1");
		
		//AssertEquals
		assertEquals("03", r);
	}
	
	@Test
	public void testDurationIsNumeric2() {
		
		//Insert new shift(duration is "5")
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "1");
		double duration = addShiftTestDao.getShiftByLoc(location).getDuration();
		//AssertEquals
		assertEquals(5,duration, 0.0);
	}
	
	@Test
	public void testDurationIsNumeric3() {
		
		//Insert new shift(duration is "5.00")
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5.00", location, "1");
		double duration = addShiftTestDao.getShiftByLoc(location).getDuration();
		//AssertEquals
		assertEquals(5.00,duration, 0.0);
	}
	
	@Test
	public void testLocationNotNull() {
		
		//Insert new shift
		String r = addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", null, "1");
				
		//AssertEquals
		assertEquals("04", r);
		
	}
	
	@Test
	public void testRemark() {

		// Insert new shift
		addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");

		// Query the data from the database
		String remark = addShiftTestDao.getShiftByLoc(location).getRemark();
		
		// AssertTrue
		assertEquals("Pause", remark);
	}

	@After
	public void tearDown() {

		addShiftTestDao.deleteByLoc(location);
	}
}

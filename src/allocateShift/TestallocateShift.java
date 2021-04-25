package allocateShift;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestallocateShift {
	public AllocateShiftService service ;

	@Before
	public void setUp() throws Exception {
		service = new AllocateShiftService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testallocateShift() {
		assertEquals(1, (double)service.allocateShift(1, 3),0.01);		
	}

}

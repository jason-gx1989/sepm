package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Shift;
import listShiftAllocationHistory.listShiftAllocationHistoryDao;
import listShiftAllocationHistory.listShiftAllocationHistoryService;

public class TestListShiftAllocationHistory {

	private listShiftAllocationHistoryDao dao;
	private listShiftAllocationHistoryService service;
	
	@Before
	public void setUp() {
		
		dao = new listShiftAllocationHistoryDao();
		service = new listShiftAllocationHistoryService();
	}
	
	@Test
	public void testListShiftDuration() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		double duration = shift.getDuration();
		assertEquals(duration, 5, 0.0);
		
	}
	
	@Test
	public void testListShiftLocation() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		String loc = shift.getLocation();
		assertEquals(loc, "KFC");
		
	}
	
	@Test
	public void testListShiftStaffAllocated() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		int staff = shift.getStaffAllocated();
		assertEquals(staff, 1);
		
	}
	
	@Test
	public void testListShiftStatus() {
		Shift shift = dao.getShiftAllocationHistory("1").get(0);
		int status = shift.getStatus();
		assertEquals(status, 1);
	}
	
	@After
	public void teraDown() {
		
	}

}

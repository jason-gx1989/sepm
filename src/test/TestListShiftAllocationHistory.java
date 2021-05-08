package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void test() {
		fail("Not yet implemented");
	}
	
	@After
	public void teraDown() {
		
	}

}

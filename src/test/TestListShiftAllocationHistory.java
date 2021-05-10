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

	// TODO
	// 测试查询功能，需要在脚本中初始化测试数据，要不然换个机器或者数据库就全跑不过了。另外这么写脚本太啰嗦了，可以Google一下assertAll方法。

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

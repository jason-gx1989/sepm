package test;

import static org.junit.Assert.*;
import org.junit.*;
import common.junitUtils.NoticeTestDao;
import entity.Notice;
import notice.*;


public class NoticeTest {
	
	NoticeService service;
	NoticeTestDao dao;
	
	String type;
	int from;
	int to;
	

	@Before
	public void setUp() throws Exception {
		
		service = new NoticeService();
		dao = new NoticeTestDao();
		
		type = "1";
		from = 1;
		to = 2;
	}
	

	@After
	public void tearDown() throws Exception {
		
		dao.deleteLatestNotice();
	}
	

	@Test
	public void insertNotice() {
		
		service.insertNotice(type, from, to);
		
		Notice latestNotice = dao.getLatestNotice();
		
		assertEquals(type, latestNotice.getType());
		assertEquals(from, latestNotice.getFrom());
		assertEquals(to, latestNotice.getTo());
	}

	
	@Test
	public void getNotice() {
		
		service.insertNotice(type, from, to);
		
		Notice notice = service.getNotice(to, type);
		
		assertEquals(type, notice.getType());
		assertEquals(from, notice.getFrom());
		assertEquals(to, notice.getTo());
	}
}

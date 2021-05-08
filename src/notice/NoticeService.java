package notice;

import java.util.ArrayList;

import entity.Notice;


public class NoticeService {

	NoticeDao dao = new NoticeDao();
	
	
	public void insertNotice(String type, int from, int to) {
		
		dao.insertNotice(type, from, to);
	}
	
	
	public ArrayList<Notice> getNoticeList(int to) {
		
		return dao.getNoticeList(to);
	}
	
	
	
	
	
	public void updateStatus(int id, String status) {
	
		dao.updateStatus(id, status);
	}
}

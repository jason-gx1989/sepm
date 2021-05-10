package notice;

import entity.Notice;

public class NoticeService {

	NoticeDao dao = new NoticeDao();

	public void insertNotice(String type, int from, int to) {

		dao.insertNotice(type, from, to);
	}

	public Notice getNotice(int to, String type) {

		return dao.getNotice(to, type);
	}

	public void updateStatus(int id, String status) {

		dao.updateStatus(id, status);
	}
}

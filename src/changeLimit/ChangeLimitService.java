package changeLimit;

import entity.Staff;
import java.util.ArrayList;

public class ChangeLimitService {

	ChangeLimitDao dao = new ChangeLimitDao();

	public void changeLimit(int id, double newLimit) {
		// TODO 判断id是否在数据库中存在。double不可为负数。
		// TODO When the manger changes the limit, the tool should reminder them to
		// check whether the staff member is eligible to have this increase.
		// --参照product backlog第5号。
		// TODO 补充junit和文档中的testcase，所有判断条件的每一个分支都要涵盖到。

		dao.changeLimit(id, newLimit);
	}

	public ArrayList<Staff> getStaffList() {

		return dao.getStaffList();
	}
}

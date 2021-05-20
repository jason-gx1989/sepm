package allocateShift;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Shift;
import entity.Staff;

public class AllocateShiftService {
	AllocateShiftDao dao = new AllocateShiftDao();

	public int allocateShift(int shiftId, int staffId) throws SQLException {
		// TODO 判断两个入参id存在于shift表与staff表中。
		// TODO The tool should auto-check whether a staff member already has the max
		// allowed workload as per their limit. If the manager would like to allocate
		// more shifts to a staff member, they have to change the limit.
		// --参照product backlog第3号，文档在teams上。
		// TODO 补充junit和文档中的testcase，所有判断条件的每一个分支都要涵盖到。
        if(!dao.isInStaff(staffId))
        	return 0;
        if(dao.isExceedWorkload(shiftId, staffId))
        	return -1;
		return dao.allocateShift(shiftId, staffId);
	}

	public ArrayList<Staff> getStaffList() {
		return dao.getStaffList();
	}

	public ArrayList<Shift> getShiftList() {
		return dao.getShiftList();
	}

}

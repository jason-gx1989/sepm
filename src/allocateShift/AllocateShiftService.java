package allocateShift;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Shift;
import entity.Staff;

public class AllocateShiftService {
	AllocateShiftDao dao = new AllocateShiftDao();

	public int allocateShift(int shiftId, int staffId) throws SQLException {
		// Check whether work limit is exceeded.
		// If the manager would like to allocate more shifts to a staff member,
		// they have to change the limit.
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

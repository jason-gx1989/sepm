package allocateShift;

import java.util.ArrayList;
import entity.Shift;
import entity.Staff;

public class AllocateShiftService {
	AllocateShiftDao dao = new AllocateShiftDao();
	

	public void allocateShift(int shiftId, int staffId) {	
		
		dao.allocateShift(shiftId, staffId);
	}
	
	
	public ArrayList<Staff> getStaffList() {
		return dao.getStaffList();
	}
	
	public ArrayList<Shift> getShiftList() {
		return dao.getShiftList();
	}

}

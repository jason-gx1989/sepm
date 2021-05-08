package emergencyCancelShift;

import java.util.ArrayList;

import entity.Shift;

public class CancelShiftService {
	CancelShiftDao dao = new CancelShiftDao();
	public int cancelShift(int shiftId) {
		
		return dao.cancelShift(shiftId);
	}
    
	public ArrayList<Shift> getStaffShiftList(int staffId) {
		return dao.getStaffShiftList(staffId);
	}
}

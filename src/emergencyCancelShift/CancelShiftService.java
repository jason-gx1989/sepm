package emergencyCancelShift;

import java.util.ArrayList;

import entity.Shift;
import entity.ShiftManager;

public class CancelShiftService {
	CancelShiftDao dao = new CancelShiftDao();
	public int cancelShift(int shiftId) {
		
		return dao.cancelShift(shiftId);
	}
    
	public ArrayList<Shift> getStaffShiftList(int staffId) {
		return dao.getStaffShiftList(staffId);
	}
	public ArrayList<ShiftManager> getShiftManagerList() {
		return dao.getShifManagertList();
	}
}

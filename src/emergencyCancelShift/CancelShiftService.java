package emergencyCancelShift;

import java.util.ArrayList;

import common.email.EmailUtiils;
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
	public void emailShiftManager(int shiftId,int staffId)
	{
		ArrayList<ShiftManager> shiftmanagers = getShiftManagerList();
		for (ShiftManager shiftmanager : shiftmanagers) {
			String address = shiftmanager.getEmail();
			String head = "shift cancellation notification";
			String content = "staffId" + staffId + "has cancelled shiftId" + shiftId + "due to emergency";
			EmailUtiils.sendEmail(address, head, content);
		}
		
	}
}

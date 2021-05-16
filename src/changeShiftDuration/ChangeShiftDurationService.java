package changeShiftDuration;

import java.util.ArrayList;

import entity.Shift;

public class ChangeShiftDurationService {
	ChangeShiftDurationDao dao = new ChangeShiftDurationDao();
	public int changeShiftDuration(int shiftId,double duration)
	{
		return dao.changeShiftDuration(shiftId, duration);
	}

	public ArrayList<Shift> getShiftList() {
		return dao.getShiftList();
	} 
}

package listShiftAllocationHistory;

import java.util.ArrayList;

import entity.Shift;

public class listShiftAllocationHistoryService {

	listShiftAllocationHistoryDao dao = new listShiftAllocationHistoryDao();
	
	public ArrayList<Shift> listShiftAllocationHistory(int staffID) {
		ArrayList<Shift> shift = dao.getShiftAllocationHistory(staffID);
		
		return shift;
	}
	
}

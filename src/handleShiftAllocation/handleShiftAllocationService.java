package handleShiftAllocation;

import entity.Shift;
import entity.Staff;

import java.util.ArrayList;


public class handleShiftAllocationService {

	handleShiftAllocationDao handleShiftAllocationDao = new handleShiftAllocationDao();

	
	public void AcceptAllocation(int id, int staffId) {
		
		handleShiftAllocationDao.changeShiftStatus(id, staffId, 2);
	}

	public void RejectAllocation(int id, int staffId) {

		handleShiftAllocationDao.changeShiftStatus(id, staffId, 3);
	}

	public ArrayList<Shift> getShiftList() {

		return handleShiftAllocationDao.getShiftList();
	}

}

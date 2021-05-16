package deactiveAccount;

import java.util.ArrayList;

import entity.ShiftManager;
import entity.Staff;

public class DeactiveAccountService {
	
	DeactiveAccountDao dao = new DeactiveAccountDao();
	
	public void deactiveManagerAccount(int id) {
		
		dao.deactiveManagerAccount(id);
	}
	
	public void deactiveStaffAccount(int id) {
		
		dao.deactiveStaffAccount(id);
	}
	
	public ArrayList<Staff> getStaffList() {

		return dao.getStaffList();
	}

	public ArrayList<ShiftManager> getShiftManagerList(){
		return dao.getShiftManagerList();
	}
}

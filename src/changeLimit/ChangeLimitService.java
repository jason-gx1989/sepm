package changeLimit;

import entity.Staff;
import java.util.ArrayList;


public class ChangeLimitService {
	
	ChangeLimitDao dao = new ChangeLimitDao();
	

	public void changeLimit(int id, double newLimit) {	
		
		dao.changeLimit(id, newLimit);
	}
	
	
	public ArrayList<Staff> getStaffList() {
		
		return dao.getStaffList();
	}
}

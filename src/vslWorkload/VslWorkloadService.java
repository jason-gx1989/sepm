package vslWorkload;

import java.util.HashMap;


public class VslWorkloadService {
	
	private VslWorkloadDao dao = new VslWorkloadDao();
	

	/**
	 * @param timeFrame 1 - weekly; 2 - monthly
	 */
	public HashMap<String, Double> getWorkloadByStaff(int timeFrame) {
		
		return dao.getWorkloadByStaff(timeFrame);
	}
}

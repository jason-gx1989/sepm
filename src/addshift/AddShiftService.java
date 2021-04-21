package addshift;

import java.util.Date;

public class AddShiftService {

	AddShiftDao dao = new AddShiftDao();

	public void addShift(Date startTime, Date endTime,double duration,String location,int staffAllocated, int status, String remark) {

		dao.addShift(startTime, endTime, duration, location, staffAllocated, status, remark);

	}

}

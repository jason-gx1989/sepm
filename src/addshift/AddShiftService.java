package addshift;

import java.util.Date;

import common.configration.StaticRes;
import common.utils.Utils;

public class AddShiftService {

	AddShiftDao dao = new AddShiftDao();

	public String addShift(String input_startTime, String input_endTime, String input_duration, String input_location,
			String input_staffAllocated, String input_remark) {

		Date startTime = Utils.timeFormat(input_startTime);
		if (null == startTime) {
			return "01";
		}

		Date endTime = Utils.timeFormat(input_endTime);
		if (null == endTime) {
			return "02";
		}

		double duration = Double.valueOf(input_duration);
		String location = input_location;
		int status = Integer.valueOf(StaticRes.SHITF_STATUS_1);
		String remark = input_remark;

		dao.addShift(startTime, endTime, duration, location, StaticRes.SHITF_STAFF_INI, status, remark);
		return "00";

	}

}

package addshift;

import common.configration.StaticRes;
import common.utils.Utils;

public class AddShiftService {

	AddShiftDao dao = new AddShiftDao();

	public String addShift(String input_startTime, String input_endTime, String input_duration, String input_location,
			String input_remark) {

		// TODO 判断input_startTime一定在input_endTime之前。
		// TODO 判断input_duration只能为数字（包括小数）
		// TODO 判断input_location不能为空。
		// TODO 补充junit和文档中的testcase，所有判断条件的每一个分支都要涵盖到。
		

		java.sql.Date startTime = Utils.timeFormat(input_startTime);
		if (null == startTime) {
			return "01";
		}

		java.sql.Date endTime = Utils.timeFormat(input_endTime);
		if (null == endTime) {
			return "02";
		}
		
		//判断input_duration只能为数字（包括小数）
		double duration;
		if(Utils.isNumeric(input_duration) == true) {
			duration = Double.valueOf(input_duration);
			
		}
		else {
			return "03";
		}
		
		//判断input_location不能为空
		String location = input_location;
		if(location == null) {
			return "04";
		}
		
		String remark = input_remark;

		dao.addShift(startTime, endTime, duration, location, StaticRes.SHITF_STAFF_INI, StaticRes.SHITF_STATUS_1,
				remark);
		return "00";

	}

}

package staffdetail.calendar;

import java.util.List;

import common.utils.Utils;

public class StaffCalendarService {

	StaffCalendarDao dao = new StaffCalendarDao();

	public String getCalendarStr(int staffId, int year, int month) {

		String result = ",";

		List<StaffCalendarPojo> staffCalendarPojoList = dao.get(staffId, year, month);

		for (StaffCalendarPojo pojo : staffCalendarPojoList) {

			int startMonth = pojo.getStartMonth();
			int startDate = pojo.getStartDate();
			int endMonth = pojo.getEndMonth();
			int endDate = pojo.getEndDate();

			int firstDate = startDate;
			int lastDate = endDate;

			// 第一天与最后一天夸月
			if (startMonth < month) {
				firstDate = 1;
			}
			if (endMonth > month) {
				if (month == 2) {
					if (year % 4 == 0) {
						lastDate = 29;
					} else {
						lastDate = 28;
					}

				}

				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
					lastDate = 31;
				}

				if (month == 4 || month == 6 || month == 9 || month == 11) {
					lastDate = 30;
				}

			}

			System.out.println("firstDate >> " + firstDate);

			System.out.println("lastDate >> " + lastDate);

			for (int i = firstDate; i <= lastDate; i++) {
//				String date = String.valueOf(firstDate);
				result = buildDateString(String.valueOf(i), result);
				System.out.println("result >> " + result);
			}

			System.out.println();

		}

		return result;

	}

	private String buildDateString(String date, String dateStr) {

		if (isExist(date, dateStr)) {
			return dateStr;
		}

		if (Utils.isNull(date)) {

			return dateStr;
		}

		return dateStr = dateStr + date + ",";

	}

	private boolean isExist(String date, String dateStr) {

		if (dateStr.contains(date)) {

			return true;

		}

		return false;

	}

}

package common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	final static String TIME_FORMART1 = "yyyy-MM-dd hh:mm:ss";

	public static Date timeFormat(String s) {

		DateFormat formatter = new SimpleDateFormat(TIME_FORMART1);
		try {
			Date date = formatter.parse(s);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getCurrentTime() {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String res = sdf.format(date);
		return res;
	}

	public static boolean beginWith(String tempString, String firstLetter) {

		String s = tempString.substring(0, 1);

		if (s.equals(firstLetter)) {
			return true;

		}

		return false;

	}

	public static boolean isNull(String s) {

		if ("".equals(s)) {

			return true;

		}
		if (null == s) {
			return true;
		}

		return false;

	}

}

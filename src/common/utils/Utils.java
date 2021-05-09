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
			Date dateDB = new Date(date.getTime());
			return dateDB;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static boolean isNumeric(final String str) {
		// null or empty

		if (str == null || str.length() == 0) {
			return false;

		}

		try {
			Integer.parseInt(str);

			return true;

		} catch (NumberFormatException e) {
			try {
				Double.parseDouble(str);

				return true;

			} catch (NumberFormatException ex) {
				try {
					Float.parseFloat(str);

					return true;

				} catch (NumberFormatException exx) {
					return false;

				}

			}

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

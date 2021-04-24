package common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
	

	public static String getCurrentTime(){

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

package edu.nf.hansen.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date calDate(int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + day);
		Date newDate = c.getTime();
		return newDate;
	}
	
	public static String getEffectiveDate(String effectiveDateString, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			Date date = myFormatter.parse(effectiveDateString);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}
	
	public static String nowDate() {
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createdate = sdf.format(date);
        return createdate;
	}
	
	public static String effectiveDate(Date effectiveDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String newdate = sdf.format(effectiveDate);
        return newdate;
	}
}

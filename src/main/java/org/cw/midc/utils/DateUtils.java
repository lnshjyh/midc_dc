package org.cw.midc.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static String dateToStr_new1(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	
	public static String timeToStr_new1(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
}

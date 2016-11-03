package com.cqut.tool.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTool {
	static Calendar  calendar = new GregorianCalendar();
	
	public static Date getDate(int year, int month, int date) {
		calendar.set(year, month - 1, date);
		return calendar.getTime();
	}
	
	public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) {
		calendar.set(year, month - 1, date, hourOfDay, minute, second);
		return calendar.getTime();
	}
	
		

}

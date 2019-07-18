package mtu.yc.sm;

import java.util.Calendar;
import java.util.Date;

public class GetYearMonth {
	static Calendar cal = Calendar.getInstance();
	
	public static int getYear(Date date) {
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		cal.setTime(date);
		return (cal.get(Calendar.MONTH) + 1);
	}
}

package com.year2021.Feb;

import java.util.Calendar;
import java.util.Date;

public class PregDateTicker {

  public static void main(String[] args) {
	Date date = new Date();
	long timeMilli = 1612502900100l; // start time Feb 4
	int startWeeks = 24;
	System.out.println("Current Time "+timeMilli);

	long currentTime = date.getTime();
//	currentTime = 1619101849174l;


	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(timeMilli);

	int mYear = calendar.get(Calendar.YEAR);
	int mMonth = calendar.get(Calendar.MONTH);
	int mDay = calendar.get(Calendar.DAY_OF_MONTH);

	System.out.println("Year "+mYear+" mMonth "+mMonth+" mday "+mDay);
	long difference = currentTime-timeMilli;
	long perDayMilliSecs = 60*60*24*1000;


	int numberofDays = (int) (difference / perDayMilliSecs);
	int numberOfWeeks =  (numberofDays / 7);
	System.out.println("Number of Days "+numberofDays);
	System.out.println("Current Week "+(numberOfWeeks + startWeeks)+" and days "+(numberofDays - (numberOfWeeks*7)));

  }

}

/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * Util class for Date, GregorianCalendar, SimpleDateFormat.
 * @author TobyLee
 * @author Whiteship
 */
public class DateUtils {

	public static Date makeDate(int year, int month, int day) {
		return new GregorianCalendar(year, month - 1, day).getTime();
	}

	public static Date makeDateTime(int year, int month, int day, int hour, int minute, int second) {
		return new GregorianCalendar(year, month - 1, day, hour, minute, second).getTime();
	}

	public static String makeYYYYMMDD(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(date);
	}

	public static String makeYYYYMMDDWithoutDelim(Date date) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}

	public static String makeYYMMDDWithoutDelim(Date date) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date).substring(2);
	}

	public static String makeYYYYMMWithHypon(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		return format.format(date);
	}

	/**
	 * 1/1/2005 0:0:0 -> 1/1/2005 23:59:59
	 * @param date
	 * @return
	 */
	public static Date getLastDateTimeOf(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, 23);
		cal.add(Calendar.MINUTE, 59);
		cal.add(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date addDate(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date getTimeOnly(Date date) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		try {
			return format.parse(format.format(date));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Date getDateOnly(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return format.parse(format.format(date));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Timestamp getStartTimeStampOfDate(Date date) {
		if (date == null)
			return null;
		String yyyymmdd = makeYYYYMMDD(date);
		StringTokenizer tokenizer = new StringTokenizer(yyyymmdd, "/");
		int year = Integer.parseInt(tokenizer.nextToken());
		int month = Integer.parseInt(tokenizer.nextToken());
		int day = Integer.parseInt(tokenizer.nextToken());
		return new Timestamp(makeDateTime(year, month, day, 0, 0, 0).getTime());
	}

	public static Date getEndTimeStampOfDate(Date date) {
		if (date == null)
			return null;
		String yyyymmdd = makeYYYYMMDD(date);
		StringTokenizer tokenizer = new StringTokenizer(yyyymmdd, "/");
		int year = Integer.parseInt(tokenizer.nextToken());
		int month = Integer.parseInt(tokenizer.nextToken());
		int day = Integer.parseInt(tokenizer.nextToken());
		return new Timestamp(makeDateTime(year, month, day, 23, 59, 59).getTime());
	}

	public static Date parseYYYYMMDD(String yyyymmdd) {
		SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");
		try {
			return sformat.parse(yyyymmdd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Date parseYYYYMMDDWithHypon(String yyyymmdd) {
		SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sformat.parse(yyyymmdd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Date getEndDateOfMonth(String yyyymmdd) {
		SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");

		String yyyymm = yyyymmdd.substring(0, 7);
		int year = Integer.parseInt(yyyymm.substring(0, 4));
		int month = Integer.parseInt(yyyymm.substring(5));

		String endDate = "31";
		if (month == 2)
			if (year % 4 == 0)
				endDate = "29";
			else
				endDate = "28";
		else if (month % 2 == 0)
			endDate = "30";

		Date date = null;
		try {
			date = sformat.parse(yyyymm + "-" + endDate);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	public static Date getStartDateOfMonth(String yyyymm) {
		SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sformat.parse(yyyymm + "-01");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Date addMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.MONTH, months);

		return cal.getTime();
	}

	public static Date getStartDateOfMonth(Date date) {
		return getStartDateOfMonth(makeYYYYMMWithHypon(date));
	}

	public static Date getEndDateOfMonth(Date date) {
		return getEndDateOfMonth(makeYYYYMMWithHypon(date));
	}
}

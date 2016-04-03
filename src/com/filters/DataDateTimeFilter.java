package com.filters;

import java.time.LocalDateTime;

import com.enumerators.CountDatetime;

public final class DataDateTimeFilter extends AbstractDateTime {
	
	private static long previous = 0;
	
	public static void filterLargestTimeInterval(String stringDateTime) {
		LocalDateTime dateTime = convertStringDateTimeInLocalDateTime(stringDateTime, FORMATTER);
		
		if(previous == 0) {
			previous = convetLocalDateTimeInMillis(dateTime);
			return;
		}
		
		long actualDateTimeInMillis = convetLocalDateTimeInMillis(dateTime);
		long interval = calcTimeIntervalUsingMillis(previous, actualDateTimeInMillis);
		
		if(interval > CountDatetime.FIRST.getTime()) {
			feedCountDateTimeEnum(CountDatetime.FIRST, interval, actualDateTimeInMillis);
			return;
		}
		if(interval > CountDatetime.SECOND.getTime()) {
			feedCountDateTimeEnum(CountDatetime.SECOND, interval, actualDateTimeInMillis);
			return;
		}
		if(interval > CountDatetime.THIRD.getTime()) {
			feedCountDateTimeEnum(CountDatetime.THIRD, interval, actualDateTimeInMillis);
			return;
		}
	}
	
	private static void feedCountDateTimeEnum(CountDatetime countDatetime, long interval, long actual) {
		changePreviousValue(actual);
		CountDatetime.valueOf(countDatetime.name()).setTime(interval);
	}

	private static void changePreviousValue(long previous) {
		DataDateTimeFilter.previous = previous;
	}
}

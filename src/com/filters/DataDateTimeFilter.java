package com.filters;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.enumerators.CountDatetime;

public final class DataDateTimeFilter {
	
	private static long last = 0;
	
	public static void filterBiggestTimeInterval(String dateTimeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH);
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
		
		long timeToCalc = (dateTime.toInstant(ZoneOffset.ofHours(-03)).toEpochMilli());
		long interval = timeToCalc - last;
		
		if(last == 0) {
			last = timeToCalc;
			return;
		}
		if(interval > CountDatetime.first.getTime()) {
			last = timeToCalc;
			CountDatetime.first.setTime(interval);
			return;
		}
		if(interval > CountDatetime.second.getTime()) {
			last = timeToCalc;
			CountDatetime.second.setTime(interval);
			return;
		}
		if(interval > CountDatetime.third.getTime()) {
			last = timeToCalc;
			CountDatetime.third.setTime(interval);
			return;
		}
	}
}

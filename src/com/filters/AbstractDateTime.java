package com.filters;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class AbstractDateTime {
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH);
	
	public static long calcTimeIntervalUsingMillis(long previous, long posterior) {
		return posterior - previous;
	}
	
	public static long convetLocalDateTimeInMillis(LocalDateTime dateTime) {
		return dateTime.toInstant(ZoneOffset.ofHours(-03)).toEpochMilli();
	}
	
	public static LocalDateTime convertStringDateTimeInLocalDateTime(String stringDateTime, DateTimeFormatter formatter) {
		return LocalDateTime.parse(stringDateTime, formatter);
	}
}

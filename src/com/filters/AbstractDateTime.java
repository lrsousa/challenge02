package com.filters;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class AbstractDateTime {
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH);
	
	public long calcTimeIntervalUsingMillis(long previous, long posterior) {
		return posterior - previous;
	}
	
	public long convetLocalDateTimeInMillis(LocalDateTime dateTime) {
		return dateTime.toInstant(ZoneOffset.ofHours(-03)).toEpochMilli();
	}
	
	public LocalDateTime convertStringDateTimeInLocalDateTime(String stringDateTime, DateTimeFormatter formatter) {
		return LocalDateTime.parse(stringDateTime, formatter);
	}
	
	public String extractStringDateFromLine(String line) {
		String[] dados = line.split(" - - ", 2);
		return dados[1].substring(1, 21);
	}
	
	
}

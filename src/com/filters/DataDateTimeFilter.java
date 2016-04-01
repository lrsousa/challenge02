package com.filters;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.toolbox.Impressora;

public class DataDateTimeFilter {

	public static void filterDateTime(String dateTimeString) {
		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss").withLocale(Locale.ENGLISH);
		LocalDateTime datetime = LocalDateTime.parse(dateTimeString, fomatter);
		
		
		Duration intervalo = Duration.between(LocalDateTime.now(), datetime);
		Impressora.imprimir(intervalo.toMillis());
		Calendar cal = new GregorianCalendar();
		cal.setTimeInMillis(intervalo.toMillis());
		
//		LocalDateTime novo = Instant.ofEpochMilli(intervalo.toMillis());
		
		
//		LocalDateTime intervalo = Period.between(datetime, LocalDateTime.now());
//		LocalDateTime local = LocalDateTime.from(intervalo.toMillis());
		
		System.out.println(cal);
		
		
		System.out.println();
	}
	
}

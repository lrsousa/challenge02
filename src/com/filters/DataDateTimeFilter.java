package com.filters;

import java.time.LocalDateTime;

import com.enumerators.CountDatetime;
import com.interfaces.DataFilter;
import com.toolbox.Impressora;

public final class DataDateTimeFilter extends AbstractDateTime implements DataFilter {
	
	private static long previous = 0;
	
	@Override
	public boolean filterInit(String line) {
		try {
			filterLargestTimeInterval(extractStringDateFromLine(line));
			return true;
		} catch (Exception e) {
			Impressora.imprimir(e.getMessage());
			return false;
		}
	}
	
	private void filterLargestTimeInterval(String stringDateTime) {
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
		changePreviousValue(actualDateTimeInMillis);
	}
	
	private void feedCountDateTimeEnum(CountDatetime countDatetime, long interval, long actual) {
		changePreviousValue(actual);
		countDatetime.setTime(interval);
	}

	private void changePreviousValue(long previous) {
		DataDateTimeFilter.previous = previous;
	}

	@Override
	public String toString() {
		return CountDatetime.getFormatedResult();
	}
	
	
}

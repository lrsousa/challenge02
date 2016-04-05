package com.filters;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public final class DataIpFilter extends AbstractDateTime {

	private static final long EXPECTEDRANGE = TimeUnit.MINUTES.toMillis(30); //1.800.000 millis;
	
	private static long currentTime = 0;
	private static int countDistinctVisit = 0;
	
	private static HashMap<String, Long> ipMap = new HashMap<String, Long>();
	
	public static void calcDistinctVisit(String linhaIps, String stringDateTime) {
		currentTime = convetLocalDateTimeInMillis(convertStringDateTimeInLocalDateTime(stringDateTime, FORMATTER));
		String ip = getLastIpInLine(linhaIps);
		
		if(ipMap.get(ip) == null) {
			ipMap.put(ip, currentTime);
			return;
		}
		if(!((ipMap.get(ip) + EXPECTEDRANGE) < currentTime)) {
			countDistinctVisit++;
			return;
		}
		ipMap.put(ip, currentTime);
	}
	
	public static int getCountDistinctVisit() {
		return countDistinctVisit;
	}

	private static String getLastIpInLine(String linhaIps) {
		String[] ips = linhaIps.split(" ");
		return ips[ips.length - 1];
	}
}

package com.filters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.modelo.IP;

public final class DataIpFilter extends AbstractDateTime {

	private static final long EXPECTEDRANGE = TimeUnit.MINUTES.toMillis(30); //1.800.000 millis;
	
	private static long startInterval = 0;
	private static long endInterval = 0;
	private static long currentTime = 0;
	private static int countDistinctVisit = 0;
	
	private static Set<IP> ipList = new HashSet<IP>();
	HashMap<IP, Long> ipMap = new HashMap<IP, Long>();
	
	public static void calcDistinctVisit(String linhaIps, String stringDateTime) {
		currentTime = convetLocalDateTimeInMillis(convertStringDateTimeInLocalDateTime(stringDateTime, FORMATTER));
		
		
		
		
		if(startInterval == 0 || currentTime > endInterval) {
			startFromZero(linhaIps);
			return;
		}
		if(!ipList.add(new IP(getLastIpInLine(linhaIps)))) {
			countDistinctVisit++;
		}
	}
	
	public static int getCountDistinctVisit() {
		return countDistinctVisit;
	}

	private static void startFromZero(String linhaIps) {
		startInterval = currentTime;
		endInterval = startInterval + EXPECTEDRANGE;
		ipList.clear();
		ipList.add(new IP(getLastIpInLine(linhaIps)));
	}
	
	private static String getLastIpInLine(String linhaIps) {
		String[] ips = linhaIps.split(" ");
		return ips[ips.length - 1];
//		return Arrays.asList(ips).get(ips.length - 1);
	}
}

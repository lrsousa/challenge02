package com.filters;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.interfaces.DataFilter;
import com.toolbox.Impressora;

public final class DataIpFilter extends AbstractDateTime implements DataFilter {

	private static final long EXPECTEDRANGE = TimeUnit.MINUTES.toMillis(30); //1.800.000 millis;
	
	private static long currentTime = 0;
	private static int countDistinctVisit = 0;
	private static HashMap<String, Long> ipMap = new HashMap<String, Long>();
	
	@Override
	public boolean filterInit(String line) {
		try {
			String[] dados = line.split(" - - ", 2);
			calcDistinctVisit(dados[0], extractStringDateFromLine(line));
			return true;
		} catch (Exception e) {
			Impressora.imprimir(e.getMessage());
			return false;
		}
	}
	
	private void calcDistinctVisit(String linhaIps, String stringDateTime) {
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
	
	private int getCountDistinctVisit() {
		return countDistinctVisit;
	}

	private static String getLastIpInLine(String linhaIps) {
		String[] ips = linhaIps.split(" ");
		return ips[ips.length - 1];
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Total visitas distintas: ").append(getCountDistinctVisit()).toString();
	}
	
	
}

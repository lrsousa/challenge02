package com.filters;

import java.util.Arrays;

public final class DataIpFilter {

	public static String filterIps(String string) {
		String[] ips = string.split(" ");
		return Arrays.asList(ips).get(ips.length - 1);
	}
}

package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.enumerators.CountOSType;
import com.modelo.OS;

public final class DataOSFilter {

	public static void filterOS(String linha) {
		for (CountOSType countOSType : CountOSType.values()) {
			if(linha.indexOf(countOSType.name()) > -1) {
				countOSType.countIncrementer();
			}
		}
	}

	public static Set<OS> getOrdenatedOSs() {
		SortedSet<OS> oss = new TreeSet<OS>(Comparator.comparing(OS::getCount).reversed());
		for (CountOSType countOSType : CountOSType.values()) {
			oss.add(new OS(countOSType.name(), countOSType.getCount()));
		}
		return oss;
	}
}

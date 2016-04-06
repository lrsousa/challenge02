package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.enumerators.CountOSType;
import com.interfaces.DataFilter;
import com.modelo.OS;
import com.toolbox.Impressora;

public final class DataOSFilter implements DataFilter {

	@Override
	public boolean filterInit(String line) {
		try {
			filterOS(line);
			return true;
		} catch (Exception e) {
			Impressora.imprimir(e.getMessage());
			return false;
		}
	}
	
	private void filterOS(String line) {
		for (CountOSType countOSType : CountOSType.values()) {
			if(line.indexOf(countOSType.name()) > -1) {
				countOSType.countIncrementer();
			}
		}
	}

	private Set<OS> getOrdenatedOSs() {
		SortedSet<OS> oss = new TreeSet<OS>(Comparator.comparing(OS::getCount).reversed());
		for (CountOSType countOSType : CountOSType.values()) {
			oss.add(new OS(countOSType.name(), countOSType.getCount()));
		}
		return oss;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (OS os : getOrdenatedOSs()) {
			result.append(os.toString()).append("\n");
		}
		return result.toString();
	}
}

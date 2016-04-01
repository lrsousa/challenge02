package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.enumerators.CountFileType;
import com.modelo.Archive;
import com.toolbox.Numerics;

public final class DataFileTypeFilter {
	public static void filterTypes(String linha) {
		CountFileType.callIncrementer(getFirstType(linha));
	}

	public static Set<Archive> getOrdenatedTypes() {
		SortedSet<Archive> archives = new TreeSet<Archive>(Comparator.comparing(Archive::getSize).reversed());
		for (CountFileType countFileType : CountFileType.values()) {
			archives.add(new Archive(countFileType.name(), countFileType.getBanda()));
		}
		return archives;
	}
	
	private static Archive getFirstType(String linha) {
		for(CountFileType type : CountFileType.values()) {
			int typeFilePosition = linha.indexOf("." + type.name());
			String sizeOfFile = linha.substring(typeFilePosition + (16 + type.name().length())).split(" ")[0];
			if(linha.indexOf(type.toString()) > 0 && Numerics.isNumeric(sizeOfFile)) {
				return new Archive(type.name(), Double.parseDouble(sizeOfFile));
			}
		}
		return null;
	}
}

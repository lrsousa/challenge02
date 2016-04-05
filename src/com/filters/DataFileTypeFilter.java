package com.filters;

import java.util.HashSet;
import java.util.Set;

import com.enumerators.CountFileType;
import com.modelo.Archive;
import com.toolbox.Numerics;

public final class DataFileTypeFilter {
	public static void filterTypes(String linha) {
		CountFileType.callIncrementer(getFirstType(linha));
	}

	public static Set<Archive> getOrdenatedTypes() {
		Set<Archive> archives = new HashSet<Archive>();
		for (CountFileType countFileType : CountFileType.values()) {
			archives.add(new Archive(countFileType.name(), countFileType.getBanda()));
		}
		return archives;
	}
	
	private static Archive getFirstType(String linha) {
		for(CountFileType type : CountFileType.values()) {
			int typeFilePosition = linha.indexOf("." + type.name());
			String sizeOfFile = linha.substring(typeFilePosition + (16 + type.getSizeOfTypeName())).split(" ", 2)[0];
			if(linha.indexOf(type.name()) > 0 && Numerics.isNumeric(sizeOfFile)) {
				return new Archive(type.name(), Double.parseDouble(sizeOfFile));
			}
			if(linha.indexOf(type.name()) > 0 && !Numerics.isNumeric(sizeOfFile)) {
				return null;
			}
		}
		return null;
	}
}

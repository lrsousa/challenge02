package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.enumerators.CountFileType;
import com.interfaces.DataFilter;
import com.modelo.Archive;
import com.toolbox.Impressora;
import com.toolbox.Numerics;

public final class DataFileTypeFilter implements DataFilter {
	
	@Override
	public boolean filterInit(String linha) {
		try {
			CountFileType.callIncrementer(getFirstType(linha));
			return true;
		} catch (Exception e) {
			Impressora.imprimir(e.getMessage());
			return false;
		}
	}
	
	private Archive getFirstType(String linha) {
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
	
	private Set<Archive> getOrdenatedTypes() {
		Set<Archive> archives = new TreeSet<Archive>(Comparator.comparing(Archive::getSize).reversed());
		for (CountFileType countFileType : CountFileType.values()) {
			archives.add(new Archive(countFileType.name(), countFileType.getBanda()));
		}
		return archives;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Archive archive : getOrdenatedTypes()) {
			result.append(archive.toString()).append("\n");
		}
		return result.toString();
	}
}

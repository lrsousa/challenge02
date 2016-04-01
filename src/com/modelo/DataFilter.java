package com.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.enumerators.CountFileType;
import com.toolbox.ToolBox;

public final class DataFilter {
	List<String> types;
	
	public DataFilter() {
		types = new ArrayList<String>();
	}
	
	public void addType(String type) {
		types.add(type);
	}

	public static void filterTypes(String linha) {
		CountFileType.callIncrementer(getFirstType(linha));
	}
	
	private static Archive getFirstType(String linha) {
		for(CountFileType tipo : CountFileType.values()) {
			int typeFilePosition = linha.indexOf("." + tipo.name());
			String sizeOfFile = linha.substring(typeFilePosition + (16 + tipo.name().length())).split(" ")[0];
			if(linha.indexOf(tipo.toString()) > 0 && ToolBox.isNumeric(sizeOfFile)) {
				return new Archive(tipo.name(), Double.parseDouble(sizeOfFile));
			}
		}
		return null;
	}

	public static Set<Archive> getOrdenatedTypes() {
		SortedSet<Archive> archives = new TreeSet<Archive>(Comparator.comparing(Archive::getSize).reversed());
		for (CountFileType countFileType : CountFileType.values()) {
			archives.add(new Archive(countFileType.name(), countFileType.getBanda()));
		}
		return archives;
	}
	
	
}

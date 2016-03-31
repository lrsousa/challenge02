package com.modelo;

import java.util.ArrayList;
import java.util.List;

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

	public static List<CountFileType> filterTypes(String linha) {
		
		
		System.out.println(getFirstType(linha));
		
		
//		CountFileType.callIncrementer(typeJpg);
		
		return null;
	}
	
	private static Archive getFirstType(String linha) {
		for(CountFileType tipo : CountFileType.values()) {
			int typeFilePosition = linha.indexOf("." + tipo.name());
			String sizeOfFile = linha.substring(typeFilePosition + (16 + tipo.name().length())).split(" ")[0];
			System.out.println(sizeOfFile);
			if(linha.indexOf(tipo.toString()) > 0 && ToolBox.isNumeric(sizeOfFile)) {
				return new Archive(tipo.name(), Double.parseDouble(sizeOfFile));
			}
		}
		return null;
	}
	
	
}

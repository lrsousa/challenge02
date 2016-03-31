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
		
		getFirstType(linha);
		
		
//		CountFileType.callIncrementer(typeJpg);
		
		return null;
	}
	
	private static String getFirstType(String linha) {
		int typeFilePosition;
		
		for(CountFileType tipo : CountFileType.values()) {
			typeFilePosition = linha.indexOf(tipo.name());
			String sizeOfFile = linha.substring(typeFilePosition + (15 + tipo.name().length())).split(" ")[0];
			
			if(linha.indexOf(tipo.toString()) > 0 && ToolBox.isNumeric(sizeOfFile)) {
				Impressora.imprimir(typeFilePosition);
				Impressora.imprimir(sizeOfFile);
				
			}
			
			
		}
		
//		typeFilePosition = linha.indexOf(".txt") > 0 ? CountFileType.callIncrementer("txt") : -1;
//		typeFilePosition = linha.indexOf(".csv") > 0 ? CountFileType.callIncrementer("csv") : -1;
//		typeFilePosition = linha.indexOf(".png") > 0 ? CountFileType.callIncrementer("csv") : -1;
//		typeFilePosition = linha.indexOf(".jpg") > 0 ? CountFileType.callIncrementer("csv") : -1;
//		typeFilePosition = linha.indexOf(".gif") > 0 ? CountFileType.callIncrementer("csv") : -1;
//		typeFilePosition = linha.indexOf(".js") > 0 ? CountFileType.callIncrementer("csv") : -1;
//		typeFilePosition = linha.indexOf(".css") > 0 ? CountFileType.callIncrementer("csv") : -1;
//		
//		String typeJpg = linha.substring(typeFilePosition + 1, typeFilePosition + 4);
//		Impressora.imprimir(typeJpg);
		
		
		return linha;
	}
	
	
}

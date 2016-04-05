package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//	private static Pattern pattern = Pattern.compile("\\.jpg|\\.png|\\.gif|\\.js|\\.txt|\\.csv|\\.css");
	private static Archive getFirstType(String linha) {
//		Matcher matcher = pattern.matcher(linha);
//		if(matcher.find()) {
//			String sizeOfFile = linha.substring(matcher.end() + 15).split(" ", 2)[0];
//			if(sizeOfFile.matches("\\d+")) {
//				return new Archive(matcher.group().substring(1), Double.parseDouble(sizeOfFile));
//				
////				System.out.println("OPA: " + matcher.start() + " - " + matcher.end() + " - " + linha.substring(matcher.start(), matcher.end()) + " - " + sizeOfFile);
//			}
//		}
		
		for(CountFileType type : CountFileType.values()) {
			int typeFilePosition = linha.indexOf("." + type.name());
//			System.out.print("TAM: " + linha.substring(typeFilePosition + (16 + type.name().length())).split(" ", 2).length + " - ");
			String sizeOfFile = linha.substring(typeFilePosition + (16 + type.getSizeOfTypeName())).split(" ", 2)[0];
//			if(linha.indexOf(type.name()) > 0 && sizeOfFile.matches("\\d+")) {
			if(linha.indexOf(type.name()) > 0 && Numerics.isNumeric(sizeOfFile)) {
//				System.out.println(type.name() + " - " + linha.substring(typeFilePosition + (16 + type.name().length())));
				return new Archive(type.name(), Double.parseDouble(sizeOfFile));
			}
		}
		
		
//		for(CountFileType type : CountFileType.values()) {
//			int typeFilePosition = linha.indexOf("." + type.name());
//			
//			System.out.println(type.name());
//			System.out.println(linha.substring(typeFilePosition + (16 + type.name().length())));
//			System.out.println(linha.substring(typeFilePosition + (16 + type.name().length())).split(" ")[0].matches("\\d+"));
//			
//			String sizeOfFile = linha.substring(typeFilePosition + (16 + type.name().length())).split(" ")[0];
//			if(linha.indexOf(type.name()) > 0 && sizeOfFile.matches("\\d+")) {
//				return new Archive(type.name(), Double.parseDouble(sizeOfFile));
//			}
//		}
		return null;
	}
}

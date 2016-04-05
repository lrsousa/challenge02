package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.enumerators.CountFileType;
import com.modelo.Archive;

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
	private static Pattern pattern = Pattern.compile("\\.jpg|\\.png|\\.gif|\\.js|\\.txt|\\.csv|\\.css");
	private static Archive getFirstType(String linha) {
		Matcher matcher = pattern.matcher(linha);
		if(matcher.find()) {
			String sizeOfFile = linha.substring(matcher.end() + 15).split(" ", 2)[0];
			if(sizeOfFile.matches("\\d+")) {
				return new Archive(matcher.group().substring(1), Double.parseDouble(sizeOfFile));
			}
		}
		return null;
	}
}

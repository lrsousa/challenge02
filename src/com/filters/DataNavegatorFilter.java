package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.enumerators.CountNavegatorsType;
import com.modelo.Navegator;

public final class DataNavegatorFilter {

	public static void filterNavegators(String linha) {
		for (CountNavegatorsType countNavegatorsType : CountNavegatorsType.values()) {
			if(linha.indexOf(countNavegatorsType.name()) > -1) {
				countNavegatorsType.countIncrementer();
			}
		}
	}
	
	public static Set<Navegator> getOrdenatedNavegators() {
		SortedSet<Navegator> navegators = new TreeSet<Navegator>(Comparator.comparing(Navegator::getCount).reversed());
		for (CountNavegatorsType countNavegatorsType : CountNavegatorsType.values()) {
			navegators.add(new Navegator(countNavegatorsType.name(), countNavegatorsType.getCount()));
		}
		return navegators;
	}
	
}

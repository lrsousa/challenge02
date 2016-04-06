package com.filters;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.enumerators.CountNavegatorsType;
import com.interfaces.DataFilter;
import com.modelo.Navegator;
import com.toolbox.Impressora;

public final class DataNavegatorFilter implements DataFilter {

	@Override
	public boolean filterInit(String line) {
		try {
			filterNavegators(line);
			return true;
		} catch (Exception e) {
			Impressora.imprimir(e.getMessage());
			return false;
		}
	}
	
	private void filterNavegators(String line) {
		for (CountNavegatorsType countNavegatorsType : CountNavegatorsType.values()) {
			if(line.indexOf(countNavegatorsType.name()) > -1) {
				countNavegatorsType.countIncrementer();
			}
		}
	}
	
	private Set<Navegator> getOrdenatedNavegators() {
		SortedSet<Navegator> navegators = new TreeSet<Navegator>(Comparator.comparing(Navegator::getCount).reversed());
		for (CountNavegatorsType countNavegatorsType : CountNavegatorsType.values()) {
			navegators.add(new Navegator(countNavegatorsType.name(), countNavegatorsType.getCount()));
		}
		return navegators;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Navegator navegator : getOrdenatedNavegators()) {
			stringBuilder.append(navegator.toString()).append("\n");
		}
		return stringBuilder.toString();
	}
}

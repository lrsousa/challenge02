package com.modelo;

import java.util.ArrayList;
import java.util.List;

import com.enumerators.CountFileType;

public final class DataFilter {
	List<String> types;
	
	public DataFilter() {
		types = new ArrayList<String>();
	}
	
	public void addType(String type) {
		types.add(type);
	}

	public List<CountFileType> filterTypes(String linha) {
		
		
		return null;
	}
	
//	private 
}

package com.toolbox;

public final class Numerics {
	public static boolean isNumeric(String number) {
		try {  
			Double.parseDouble(number);  
		} catch(NumberFormatException nfe) {  
			return false;
		} 
		return true;
	}
}

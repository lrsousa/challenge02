package com.toolbox;

public final class ToolBox {
	public static boolean isNumeric(String number) {
		try {  
			Double.parseDouble(number);  
		} catch(NumberFormatException nfe) {  
			return false;  
		} 
		return true;
	}
}

package com.modelo;

public class Archive {
	private final String type;
	private final double size;
	
	public Archive(String type, double size) {
		this.type = type;
		this.size = size;
	}
	
	public String getType() {
		return type;
	}
	public double getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Archive [type=" + type + ", size=" + size + "]";
	}
	
	
}

package com.modelo;

public class OS {
	private final String name;
	private final int count;
	
	public OS(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Os [name=" + name + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		if (count != other.count)
			return false;
		return true;
	}
}

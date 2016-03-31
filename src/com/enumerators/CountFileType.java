package com.enumerators;

public enum CountFileType {
	jpg {
		@Override
		public int incrementCountType() {
			return 0;
		}
		
	},
	png {

		public int incrementCountType() {
			return 0;
		}
		
	};
	
	abstract int incrementCountType();
	
	int countJpg = 0;
	
	public static final void callIncrementer(String tipo) {
		try {
			CountFileType fileType = CountFileType.valueOf(tipo);
			fileType.incrementCountType();
		} catch (Exception e) {
			System.out.println("Tipo ausdhauhsduhasd nao enasuhdauhsduh");
		}
	}
	
}

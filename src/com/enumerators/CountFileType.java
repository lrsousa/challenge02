package com.enumerators;

public enum CountFileType {
	jpg {
		@Override
		public void incrementCountType() {
		}
		
	},
	png {

		public void incrementCountType() {
		}
		
	},
	txt {

		@Override
		void incrementCountType() {
		}
		
	},
	csv {

		@Override
		void incrementCountType() {
		}
		
	},
	gif {

		@Override
		void incrementCountType() {
		}
		
	},
	css {

		@Override
		void incrementCountType() {
		}
		
	},
	js {

		@Override
		void incrementCountType() {
		}
	};
	
	
	abstract void incrementCountType();
	
	static double countTxt = 0;
	static double countCsv = 0;
	static double countPng = 0;
	static double countJpg = 0;
	static double countGif = 0;
	static double countCss = 0;
	static double countJs = 0;
	
	public static final int callIncrementer(String tipo, double value) {
		try {
			CountFileType fileType = CountFileType.valueOf(tipo);
			fileType.incrementCountType();
		} catch (Exception e) {
			System.out.println("Tipo ausdhauhsduhasd nao enasuhdauhsduh");
		}
		return 0;
	}
	
}

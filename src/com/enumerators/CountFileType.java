package com.enumerators;

import com.modelo.Archive;

public enum CountFileType {
	jpg(3) {
		@Override
		public void incrementCountType(double banda) {
			CountFileType.bandaJpg += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaJpg;
		}
	},
	png(3) {
		@Override
		public void incrementCountType(double banda) {
			CountFileType.bandaPng += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaPng;
		}
	},
	gif(3) {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaGif += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaGif;
		}
	},
	js(2) {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaJs += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaJs;
		}
	},
	css(3) {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaCss += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaCss;
		}
	},
	txt(3) {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaTxt += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaTxt;
		}
	},
	csv(3) {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaCsv += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaCsv;
		}
	};
	
	private int sizeOfTypeName;
	private CountFileType(int sizeOfTypeName) {
		this.sizeOfTypeName = sizeOfTypeName;
	}
	
	abstract void incrementCountType(double banda);
	public abstract double getBanda();
	
	public int getSizeOfTypeName() {
		return sizeOfTypeName;
	}
	
	public static final void callIncrementer(Archive archive) {
		try {
			CountFileType fileType = CountFileType.valueOf(archive.getType());
			fileType.incrementCountType(archive.getSize());
		} catch (Exception e) {
//			System.out.println("Tipo ausdhauhsduhasd nao enasuhdauhsduh");
		}
	}
	
	private static double bandaTxt = 0;
	private static double bandaCsv = 0;
	private static double bandaPng = 0;
	private static double bandaJpg = 0;
	private static double bandaGif = 0;
	private static double bandaCss = 0;
	private static double bandaJs = 0;
	
	public static String getAsString() {
		return  "BandaTxt : " + txt.getBanda()
				+ "\nBandaCsv : " + csv.getBanda()
				+ "\nBandaPng : " + png.getBanda()
				+ "\nBandaJpg : " + jpg.getBanda()
				+ "\nBandaGif : " + gif.getBanda()
				+ "\nBandaCss : " + css.getBanda()
				+ "\nBandaJs : " + js.getBanda(); 
	}
}

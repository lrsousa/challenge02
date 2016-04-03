package com.enumerators;

import com.modelo.Archive;

public enum CountFileType {
	jpg {
		@Override
		public void incrementCountType(double banda) {
			CountFileType.bandaJpg += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaJpg;
		}
	},
	png {
		@Override
		public void incrementCountType(double banda) {
			CountFileType.bandaPng += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaPng;
		}
	},
	txt {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaTxt += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaTxt;
		}
	},
	csv {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaCsv += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaCsv;
		}
	},
	gif {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaGif += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaGif;
		}
	},
	css {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaCss += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaCss;
		}
	},
	js {
		@Override
		void incrementCountType(double banda) {
			CountFileType.bandaJs += banda;
		}
		@Override
		public double getBanda() {
			return CountFileType.bandaJs;
		}
	};
	
	abstract void incrementCountType(double banda);
	public abstract double getBanda();
	
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

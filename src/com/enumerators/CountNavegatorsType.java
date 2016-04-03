package com.enumerators;

public enum CountNavegatorsType {
	Chrome {
		@Override
		public void countIncrementer() {
			CountNavegatorsType.countChrome++;			
		}

		@Override
		public int getCount() {
			return CountNavegatorsType.countChrome;
		}
	},
	Safari {
		@Override
		public void countIncrementer() {
			CountNavegatorsType.countSafari++;
		}

		@Override
		public int getCount() {
			return CountNavegatorsType.countSafari;
		}
		
	},
	MSIE {
		@Override
		public void countIncrementer() {
			CountNavegatorsType.countMsie++;
		}

		@Override
		public int getCount() {
			return CountNavegatorsType.countMsie;
		}
		
	},
	Firefox {
		@Override
		public void countIncrementer() {
			CountNavegatorsType.countFirefox++;
		}

		@Override
		public int getCount() {
			return CountNavegatorsType.countFirefox;
		}
	};
	
	public abstract void countIncrementer();
	public abstract int getCount();
	
	private static int countChrome = 0;
	private static int countSafari = 0;
	private static int countMsie = 0;
	private static int countFirefox = 0;
	
}

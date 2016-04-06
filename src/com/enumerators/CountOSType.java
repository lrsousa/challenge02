package com.enumerators;

public enum CountOSType {
	Windows {
		@Override
		public void countIncrementer() {
			CountOSType.countWindows++;
		}

		@Override
		public int getCount() {
			return CountOSType.countWindows;
		}
	},
	Linux {
		@Override
		public void countIncrementer() {
			CountOSType.countLinux++;
		}

		@Override
		public int getCount() {
			return CountOSType.countLinux;
		}
	},
	Android {
		@Override
		public void countIncrementer() {
			CountOSType.countAndroid++;
		}

		@Override
		public int getCount() {
			return CountOSType.countAndroid;
		}
	},
	Macintosh {
		@Override
		public void countIncrementer() {
			CountOSType.countMacintosh++;
		}

		@Override
		public int getCount() {
			return CountOSType.countMacintosh;
		}
	},
	iPhone {
		@Override
		public void countIncrementer() {
			CountOSType.countiPhone++;
		}

		@Override
		public int getCount() {
			return CountOSType.countiPhone;
		}
	};
	
	private static int countMacintosh = 0;
	private static int countWindows = 0;
	private static int countAndroid = 0;
	private static int countLinux = 0;
	private static int countiPhone = 0;
	
	
	public abstract void countIncrementer();
	public abstract int getCount();
}

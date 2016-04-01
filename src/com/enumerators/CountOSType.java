package com.enumerators;

public enum CountOSType {
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
	iPhone {
		@Override
		public void countIncrementer() {
			CountOSType.countiPhone++;
		}

		@Override
		public int getCount() {
			return CountOSType.countiPhone;
		}
	},
	Ubuntu {
		@Override
		public void countIncrementer() {
			CountOSType.countUbuntu++;
		}

		@Override
		public int getCount() {
			return CountOSType.countUbuntu;
		}
	};
	
	private static int countMacintosh = 0;
	private static int countWindows = 0;
	private static int countAndroid = 0;
	private static int countLinux = 0;
	private static int countiPhone = 0;
	private static int countUbuntu = 0;
	
	
	public abstract void countIncrementer();
	public abstract int getCount();
}

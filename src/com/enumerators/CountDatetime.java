package com.enumerators;

public enum CountDatetime {
	FIRST {
		@Override
		public long getTime() {
			return firstTime;
		}
		@Override
		public void setTime(long time) {
			thirdTime = secondTime;
			secondTime = firstTime;
			firstTime = time;
		}
	},
	SECOND {
		@Override
		public long getTime() {
			return secondTime;
		}
		@Override
		public void setTime(long time) {
			thirdTime = secondTime;
			secondTime = time;
		}
	},
	THIRD {
		@Override
		public long getTime() {
			return thirdTime;
		}

		@Override
		public void setTime(long time) {
			thirdTime = time;
		}
	};
	private static long firstTime = 0;
	private static long secondTime = 0;
	private static long thirdTime = 0;

	public static String getFormatedResult() {
		StringBuilder result = new StringBuilder()
				.append("First: ").append(mountIntervalTimeLine(CountDatetime.FIRST))
				.append("\nSecond: ").append(mountIntervalTimeLine(CountDatetime.SECOND))
				.append("\nThird: ").append(mountIntervalTimeLine(CountDatetime.THIRD))
				;
		return result.toString();
	}
	
	private static String mountIntervalTimeLine(CountDatetime position) {
//		TimeUnit.MILLISECONDS.toMinutes(position.getTime())
		return new StringBuilder()
				.append((position.getTime() / (1000 * 60 * 60)) % 24)
				.append(":").append((position.getTime() / (1000 * 60)) % 60)
				.append(":").append((position.getTime() / 1000) % 60)
				.toString();
	}
	public abstract long getTime();
	public abstract void setTime(long time);
}

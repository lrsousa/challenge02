package com.enumerators;

import java.time.Duration;

public enum CountDatetime {
	first {
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
	second {
		@Override
		public long getTime() {
			return secondTime;
		}
		@Override
		public void setTime(long time) {
			secondTime = time;
		}
		
	},
	third {
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
		Duration duration = Duration.ofMillis(firstTime);
		StringBuilder result = new StringBuilder()
				.append("First interval:")
				.append("\nHours: ").append(duration.toHours() % 24)
				.append("\nMinutes: ").append(duration.toMinutes() % 60)
				.append("\nSeconds: ").append(duration.getSeconds() % 60);
		
		duration = Duration.ofMillis(secondTime);
		result.append("\nSecond interval:")
				.append("\nHours: ").append(duration.toHours() % 24)
				.append("\nMinutes: ").append(duration.toMinutes() % 60)
				.append("\nSeconds: ").append(duration.getSeconds() % 60)
				;

		duration = Duration.ofMillis(thirdTime);
		result.append("\nThird interval:")
				.append("\nHours: ").append(duration.toHours() % 24)
				.append("\nMinutes: ").append(duration.toMinutes() % 60)
				.append("\nSeconds: ").append(duration.getSeconds() % 60)
				;
		
		return result.toString();
	}
	
	public abstract long getTime();
	public abstract void setTime(long time);
	
	
}

package com.enumerators;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

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
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(position.getTime()), ZoneOffset.ofHours(-03));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
		
		localDateTime.format(formatter);
		
		return new StringBuilder()
				.append(localDateTime.getHour())
				.append(":").append(localDateTime.getMinute())
				.append(":").append(localDateTime.getSecond())
				.toString();
	}
	public abstract long getTime();
	public abstract void setTime(long time);
}

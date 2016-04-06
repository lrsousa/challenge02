package com.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import com.filters.DataDateTimeFilter;
import com.filters.DataFileTypeFilter;
import com.filters.DataIpFilter;
import com.filters.DataNavegatorFilter;
import com.filters.DataOSFilter;
import com.interfaces.DataFilter;

public class LogReaderThread {
	
	LinkedList<DataFilter> tasks;
	
	public static void main(String[] args) throws Exception {
		new LogReaderThread();
	}
	
	public LogReaderThread() throws Exception {
		tasks = new LinkedList<DataFilter>();
		tasks.add(new DataIpFilter());
		tasks.add(new DataDateTimeFilter());
		tasks.add(new DataNavegatorFilter());
		tasks.add(new DataOSFilter());
		tasks.add(new DataFileTypeFilter());
		
		Path log = Paths.get("access.log");
		final List<String> lines = Files.readAllLines(log);
		
		printCurrentTime("Inicio");
		
		for (DataFilter dataFilter : tasks) {
			new Thread(() -> {
				lines.forEach(line -> {
					dataFilter.filterInit(line);
				});
				printCurrentTime(dataFilter.getClass().getName());
			}).start();
		}
	}

	private void printCurrentTime(String string) {
		System.out.println(LocalTime.now() +" - " + string);
	}
}

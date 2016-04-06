package com.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;

import com.filters.DataDateTimeFilter;
import com.filters.DataFileTypeFilter;
import com.filters.DataIpFilter;
import com.filters.DataNavegatorFilter;
import com.filters.DataOSFilter;
import com.interfaces.DataFilter;
import com.toolbox.Impressora;

public class LogReader {
	
	LinkedList<DataFilter> tasks;
	
	public static void main(String[] args) throws IOException {
		LocalTime start = LocalTime.now();
		new LogReader();
		LocalTime finish = LocalTime.now();
		System.out.print("Execucao levou(segundos): ");
		System.out.println(Duration.between(start, finish));
	}
	
	int count = 0;
	public LogReader() throws IOException {
		tasks = new LinkedList<DataFilter>();
		tasks.add(new DataIpFilter());
		tasks.add(new DataDateTimeFilter());
		tasks.add(new DataNavegatorFilter());
		tasks.add(new DataOSFilter());
		tasks.add(new DataFileTypeFilter());
		
		Path log = Paths.get("access.log");
		Files.readAllLines(log, StandardCharsets.ISO_8859_1).forEach(line -> {
			for (DataFilter dataFilter : tasks) {
				dataFilter.filterInit(line);
			}
		});
		
		Impressora.imprimir("=======Final Result=======");
		for (DataFilter dataFilter : tasks) {
			Impressora.imprimir(dataFilter.toString());
		}
	}
}

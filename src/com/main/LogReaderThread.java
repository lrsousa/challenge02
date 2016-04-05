package com.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

import com.filters.DataDateTimeFilter;
import com.filters.DataFileTypeFilter;
import com.filters.DataIpFilter;
import com.filters.DataNavegatorFilter;
import com.filters.DataOSFilter;

public class LogReaderThread {
	public static void main(String[] args) throws Exception {
		new LogReaderThread();
	}
	
	public LogReaderThread() throws Exception {
		Path log = Paths.get("access.log");
		
		printCurrentTime("Inicio");
		
		final List<String> lines = Files.readAllLines(log);

		new Thread(() -> {
			lines.forEach(line -> {
				String[] dados = line.split(" - - ", 2);
				DataFileTypeFilter.filterTypes(dados[1]);
			});
			printCurrentTime("Banda utilizada por arquivos");
		}).start();
		
		new Thread(() -> {
			lines.forEach(line -> {
				String[] dados = line.split(" - - ", 2);
				String stringDateTime = dados[1].substring(1, 21); 
				DataDateTimeFilter.filterLargestTimeInterval(stringDateTime);
			});
			printCurrentTime("Intervalo de acesso");
		}).start();
		
		new Thread(() -> {
			lines.forEach(line -> {
				String[] dados = line.split(" - - ", 2);
				String stringDateTime = dados[1].substring(1, 21); 
				DataIpFilter.calcDistinctVisit(dados[0], stringDateTime);
			});
			printCurrentTime("Visitas distintas");
		}).start();

		new Thread(() -> {
			lines.forEach(line -> {
				String[] dados = line.split(" - - ", 2);
				DataNavegatorFilter.filterNavegators(dados[1]);
			});
			printCurrentTime("Navegadores");
		}).start();
		
		new Thread(() -> {
			lines.forEach(line -> {
				String[] dados = line.split(" - - ", 2);
				DataOSFilter.filterOS(dados[1]);
			});
			printCurrentTime("Sistemas operacionais");
		}).start();
		
	}

	private void printCurrentTime(String string) {
		System.out.println(LocalTime.now() +" - " + string);
	}
}

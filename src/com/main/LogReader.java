package com.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;

import com.enumerators.CountDatetime;
import com.filters.DataDateTimeFilter;
import com.filters.DataFileTypeFilter;
import com.filters.DataIpFilter;
import com.filters.DataNavegatorFilter;
import com.filters.DataOSFilter;
import com.toolbox.Impressora;

public class LogReader {
	
	public static void main(String[] args) throws IOException {
		LocalTime start = LocalTime.now();
		new LogReader();
		LocalTime finish = LocalTime.now();
		System.out.print("Segundos: ");
		System.out.println(Duration.between(start, finish).getSeconds());
		
	}
	
	public LogReader() throws IOException {
		Path log = Paths.get("access.log");
		Files.readAllLines(log, StandardCharsets.ISO_8859_1).forEach(linha -> {
			String[] dados = linha.split(" - - ");
			String stringDateTime = dados[1].substring(1, 21); 
		
			DataIpFilter.calcDistinctVisit(dados[0], stringDateTime);
			DataDateTimeFilter.filterLargestTimeInterval(stringDateTime);
			DataNavegatorFilter.filterNavegators(dados[1]);
			DataOSFilter.filterOS(dados[1]);
			DataFileTypeFilter.filterTypes(dados[1]);
		});
		Impressora.imprimir("=======Final Result=======");
		Impressora.imprimir("Item 1");
		Impressora.imprimir(DataIpFilter.getCountDistinctVisit());
		Impressora.imprimir("\nItem 2");
		Impressora.imprimir(DataNavegatorFilter.getOrdenatedNavegators());
		Impressora.imprimir("\nItem 3");
		Impressora.imprimir(CountDatetime.getFormatedResult());
		Impressora.imprimir("\nItem 4");
		Impressora.imprimir(DataOSFilter.getOrdenatedOSs());
		Impressora.imprimir("\nItem 5");
		Impressora.imprimir(DataFileTypeFilter.getOrdenatedTypes());
	}
}

package com.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.enumerators.CountDatetime;
import com.filters.DataDateTimeFilter;
import com.filters.DataFileTypeFilter;
import com.filters.DataIpFilter;
import com.filters.DataNavegatorFilter;
import com.filters.DataOSFilter;
import com.toolbox.Impressora;

public class LogReader {
	
	public static void main(String[] args) throws IOException {
		new LogReader();
	}
	
	int contadorLinha = 0;
	public LogReader() throws IOException {
		Path log = Paths.get("access500Linhas.log");
		Files.readAllLines(log, StandardCharsets.ISO_8859_1).forEach(linha -> {
			String[] dados = linha.split(" - - ");
			
			DataIpFilter.filterIps(dados[0]);
			DataDateTimeFilter.filterBiggestTimeInterval(dados[1].substring(1, 21));
			
			Impressora.imprimir(CountDatetime.getFormatedResult());
			
			DataNavegatorFilter.filterNavegators(dados[1]);
			DataOSFilter.filterOS(dados[1]);
			DataFileTypeFilter.filterTypes(dados[1]);
			
			
		});
		Impressora.imprimir("=================================");
		Impressora.imprimir("Item 2");
		Impressora.imprimir(DataNavegatorFilter.getOrdenatedNavegators());
		Impressora.imprimir("Item 3");
		Impressora.imprimir(CountDatetime.getFormatedResult());
		Impressora.imprimir("Item 4");
		Impressora.imprimir(DataOSFilter.getOrdenatedOSs());
		Impressora.imprimir("Item 5");
		Impressora.imprimir(DataFileTypeFilter.getOrdenatedTypes());
	}
}

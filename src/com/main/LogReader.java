package com.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.enumerators.CountFileType;
import com.modelo.DataFilter;
import com.modelo.Impressora;

public class LogReader {
	
	public static void main(String[] args) throws IOException {
		new LogReader();
	}
	
	public LogReader() throws IOException {
		Path log = Paths.get("access500Linhas.log");
		Files.readAllLines(log, StandardCharsets.ISO_8859_1).forEach(linha -> {
			String ip = linha.substring(16, 33).replace(" ", "").replace("-", "");
			
			String[] dados = linha.split(" - - ");
			String dataHora = dados[1].substring(1, 21);

			DataFilter.filterTypes(dados[1]);
			
			for (String dado : dados) {
//				Impressora.imprimir(dado);
			}
			Impressora.imprimir("============================");
		});
		
	}
}

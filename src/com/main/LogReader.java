package com.main;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.enumerators.CountFileType;
import com.modelo.DataFilter;

public class LogReader {
	
	public static void main(String[] args) throws IOException {
		new LogReader();
	}
	
	public LogReader() throws IOException {
		Path log = Paths.get("access500Linhas.log");
		DataFilter dataFilter = new DataFilter();
		
		Files.readAllLines(log, StandardCharsets.ISO_8859_1).forEach(linha -> {
			String ip = linha.substring(16, 33).replace(" ", "").replace("-", "");
			
			String[] dados = linha.split(" - - ");
			String dataHora = dados[1].substring(1, 21);
			
			int typeFilePosition = dados[1].indexOf(".jpg");
			String typeJpg = dados[1].substring(typeFilePosition + 1, typeFilePosition + 4);
			System.out.println(typeJpg);
			
//			String tamArquivo = 
			
			
			System.out.println("IP: " + ip
					+ "\nDataHora: " + dataHora
					+ "\nTipo: " + typeJpg
					+ "\n");
			
			for (String dado : dados) {
				System.out.println(dado);
			}
			System.out.println("============================");
		});
		
	}
}

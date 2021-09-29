package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream entraArquivo =
				new FileInputStream(new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\arquivo.txt"));
	
		Scanner lerArquivo = new Scanner(entraArquivo, "UTF-8");
		
		
		while(lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) {
				
				System.out.println(linha);
			}
		}
	}
}

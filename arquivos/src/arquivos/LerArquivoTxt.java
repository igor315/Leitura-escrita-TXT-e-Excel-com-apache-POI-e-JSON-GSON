package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream entraArquivo =
				new FileInputStream(new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\src\\arquivos\\arquivo.csv"));
	
		Scanner lerArquivo = new Scanner(entraArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while(lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) {
				
				String[] dados = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				pessoa.setTelefone(dados[3]);
				
				pessoas.add(pessoa);
			}
		}
		
		System.out.println("-----------------/Dados Pessoais/----------------- \n");
		for (Pessoa pessoa : pessoas) {/*Poderia gravar no banco de dados, enviar E-mail, gerar boletos*/
			System.out.println(pessoa);
		}
	}
}

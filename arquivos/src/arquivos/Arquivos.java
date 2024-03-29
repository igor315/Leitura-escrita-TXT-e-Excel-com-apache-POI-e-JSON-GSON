package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
		Pessoa p1 = new Pessoa("Jose");
		p1.setEmail("jose@gmail.com");
		p1.setIdade(30);
		p1.setTelefone("51981125413");
		
		Pessoa p2 = new Pessoa("Joao");
		p2.setEmail("joao123@hotmail.com");
		p2.setIdade(25);
		p2.setTelefone("61996601832");
		
		Pessoa p3 = new Pessoa("Tiago");
		p3.setEmail("tiagatinho100%@gmail.com.br");
		p3.setIdade(30);
		p3.setTelefone("31996601753");
		
		Pessoa p4 = new Pessoa("Maria", "mariajose@gmail.com", 45, "619956309");
		
		/*Essa lista pode vir de um banco de dados ou qualquer fonte de dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		
		
		File arquivo = new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\arquivo.csv");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + ";" + p.getTelefone() + "; \n");
		}
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}

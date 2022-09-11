package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * 
 * @author Area de estudo
 *
 *
 */

//Essa dependencia Apache poi serve para trabalhar com planilhas do excel
public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\arquivo_excel.xls");
	
		if(!file.exists()) {
			file.createNewFile();
		}
		
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
		
		Pessoa p4 = new Pessoa("Maria", "mariajose@gmail.com", 45, "71983125412");
		
		/*Essa lista pode vir de um banco de dados ou qualquer fonte de dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		
		/*vai ser usado para escrever planilha*/
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		/*cria a planilha*/
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento");
		
		int numeroLinha = 0;
		
		for (Pessoa pessoa : pessoas) {
			
			//criando a linha na planilha
			Row linha = linhaPessoa.createRow(numeroLinha ++);/*Criando a linha da planilha*/
			
			int celula = 0;
			
//			para cada pessoa cria uma celula e adiciona seus valores
			Cell celNome = linha.createCell(celula ++);
			celNome.setCellValue(pessoa.getNome());
			
			Cell celEmail = linha.createCell(celula ++);
			celEmail.setCellValue(pessoa.getEmail());
			
			Cell celIdade = linha.createCell(celula ++);
			celIdade.setCellValue(pessoa.getIdade());
			
			Cell celTelefone = linha.createCell(celula ++);
			celTelefone.setCellValue(pessoa.getTelefone());
			
		}/*Termino de montar a planilha*/
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);/*escreve a planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada!");
	}
}

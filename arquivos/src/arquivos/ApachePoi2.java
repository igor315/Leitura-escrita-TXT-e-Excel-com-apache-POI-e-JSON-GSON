package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/* Nessa Classe lemos a planilha*/

public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\src\\arquivos\\arquivo_excel.xls"));
	
		/*Prepara a entrada do arquivo excel para ler*/
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		
//		pega a primeira planilha do nosso arquivo excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		/*Enquanto tiver linha no arquivo excel*/
		while (linhaIterator.hasNext()) {
			
//			Dados da pessoa na linha
			Row linha = linhaIterator.next();
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			/*percorre as celulas*/
			while(celulas.hasNext()) {
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				case 3:
					pessoa.setTelefone(cell.getStringCellValue());
					break;
				}
			}/*Fim das celulas da linha*/
			
			pessoas.add(pessoa);
		}
		
//		Terminou de ler o arquivo excel
		entrada.close();
		
//		Poderia gravar no banco de dados, mandar e-mail
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}
}

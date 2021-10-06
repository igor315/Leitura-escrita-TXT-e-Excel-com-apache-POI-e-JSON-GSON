package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws Exception {
		
		
		File file = new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\src\\arquivos\\arquivo_excel.xls");

		FileInputStream entrada = new FileInputStream(file);
		
		/*Prepara a entrada do arquivo xls excel*/
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*Pegando a planilha*/
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) {/*Enquanto tiver linha*/
			Row linha = linhaIterator.next();/*Dados da pessoa na linha*/
			
			int numeroCelulas = linha.getPhysicalNumberOfCells(); /*quantidade de celula na linha*/
			
			Cell cell = linha.createCell(numeroCelulas);/*cria uma nova linha*/
			cell.setCellValue("5.487,25");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
		
	}
}

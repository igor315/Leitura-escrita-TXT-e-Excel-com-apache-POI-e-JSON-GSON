package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando2 {

	public static void main(String[] args) throws Exception {
		
		
		File file = new File("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\src\\arquivos\\arquivo_excel.xls");

		FileInputStream entrada = new FileInputStream(file);
		
		/*Prepara a entrada do arquivo xls excel*/
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		
		/*Pegando a planilha*/
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); 
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		/*Enquanto tiver linha*/
		while(linhaIterator.hasNext()) {
			
			/*Dados da pessoa na linha*/
			Row linha = linhaIterator.next();
			
			/*quantidade de celula na linha*/
			int numeroCelulas = linha.getPhysicalNumberOfCells(); 
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + " * Valor gravado na aula **");
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
		
	}
}

package arquivos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class LendoArquivoJSON {

	public static void main(String[] args) throws IOException {
		
		FileReader fileReader = new FileReader("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\src\\arquivos\\filjson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listUsuarios = new ArrayList<>();
		
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);
		}
		
		System.out.println("Leitura do arquivo JSON: " + listUsuarios);

	}

}

package arquivos;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJSON {

	public static void main(String[] args) throws IOException {

		Usuario usuario1 = new Usuario();
		usuario1.setCpf("54934107187");
		usuario1.setNome("João");
		usuario1.setLogin("jaoao");
		usuario1.setSenha("05030108");
		
		Usuario usuario2 = new Usuario();
		usuario2.setSenha("54509207178");
		usuario2.setNome("Matheus Moraes");
		usuario2.setSenha("@MatMoraes");
		usuario2.setLogin("matheus123");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		/*Organiza o nosso arquivo json deixando mais bonito*/
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonUser = gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		OutputStreamWriter escrever_no_arquivo = new OutputStreamWriter(new FileOutputStream ("C:\\Users\\Area de estudo\\git\\Leitura-escrita-TXT-e-Excel-com-apache-POI-e-JSON-GSON\\arquivos\\src\\arquivos\\filjson.json"), "UTF-8");
	
		escrever_no_arquivo.write(jsonUser);
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}

package br.pessoal.menus;

import java.util.HashMap;
import java.util.Map;

import br.pessoal.utils.Utils;

public class Ajuda {

	private Utils utils = new Utils();
	private Map<Integer, String> arquivos = new HashMap<>() ;
	private String[]arquivosAjuda;
	
	public Ajuda() {
		
		arquivosAjuda = utils.lerArquivos(utils.getConfigProperty("br.pessoal.caminho.arquivo.ajuda"));
	}
	
	public void telaAjuda() {				
		
		
	}

	public void listarArquivos() {
				
		int index = 0;
		
		
		while (arquivosAjuda.length > index) {
			
			
		}
	}

}

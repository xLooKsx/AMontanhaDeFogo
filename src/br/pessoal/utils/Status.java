package br.pessoal.utils;

import br.pessoal.to.JogadorTO;

public interface Status {
	
	void atualizarDados(JogadorTO jogadorTO);
	void preencherInterface(JogadorTO jogadorTO);
	int lancarDados();
	void usarSorte();
	String usarItem(String nome);
}

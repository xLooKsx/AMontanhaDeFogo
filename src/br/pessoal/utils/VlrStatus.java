package br.pessoal.utils;

import br.pessoal.to.JogadorTO;

public interface VlrStatus {
	
	default void atualizarDados(JogadorTO jogadorTO) {}
	public static int definirVlrStatus() {return 0;}

}

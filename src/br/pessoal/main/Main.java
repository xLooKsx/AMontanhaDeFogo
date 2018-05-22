package br.pessoal.main;


import br.pessoal.jogo.Jogo;
import br.pessoal.menus.Menu;

public class Main {

	public static void main(String[] args) {

//		 Menu menu = new Menu();
//		 menu.telaInicial();           
		
		Jogo jogo = new Jogo();
		jogo.criacaoPersonagem();
	}

}

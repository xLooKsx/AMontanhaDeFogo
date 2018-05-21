package br.pessoal.menus;

import java.util.Scanner;

import br.pessoal.utils.Utils;

public class Sobre {

	private Scanner scanner = new Scanner(System.in);
	
	private Utils utils = new Utils();
	
	private int opcaoEscolhida;
	private String opcaoEscolhidaAUX;
	private boolean	escolhaFeita = false;
	
	public void telaSobre() {
		
		utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.sobre"));
		utils.transicao(10);
		do {
			System.out.print(utils.getMessageProperty("br.pessoal.menu.opcao.desejada.mensagem.2P"));
			opcaoEscolhidaAUX = scanner.nextLine();
			utils.transicao(10);

			if (utils.inputIsNumber(opcaoEscolhidaAUX)) {
				
				opcaoEscolhida = Integer.parseInt(opcaoEscolhidaAUX);
				switch (opcaoEscolhida) {
				case 1:
					Menu menu = new Menu();
					utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.mensagem.carregando"));						
					utils.transicao(20);
					menu.telaInicial();
					utils.transicao(20);
					escolhaFeita = true;
					break;

				default:
					System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
					break;
				}
			}else {
				System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
			}


		} while (!escolhaFeita);
	}
}

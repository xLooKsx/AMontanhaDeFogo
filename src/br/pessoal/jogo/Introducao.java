package br.pessoal.jogo;

import java.util.Scanner;

import br.pessoal.menus.Menu;
import br.pessoal.utils.Utils;

public class Introducao {
	
	Utils utils = new Utils();
	Scanner scanner = new Scanner(System.in);
	
	private int opcaoEscolhida;
	
	private boolean escolhaFeita;
	
	private String opcaoEscolhidaAUX;
	
	public void telaInicio() {
		
		utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.jogo.lore"));
		utils.fazerTransicaoComDelay(10);
		do {
			System.out.print(utils.getMessageProperty("br.pessoal.menu.opcao.desejada.mensagem.2P"));
			opcaoEscolhidaAUX = scanner.nextLine();
			utils.fazerTransicaoComDelay(10);

			if (utils.inputIsNumber(opcaoEscolhidaAUX)) {
				
				opcaoEscolhida = Integer.parseInt(opcaoEscolhidaAUX);
				switch (opcaoEscolhida) {
				case 1:
					Menu menu = new Menu();
					utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.mensagem.carregando"));						
					utils.fazerTransicaoComDelay(20);
					menu.telaInicial();
					utils.fazerTransicaoComDelay(20);
					escolhaFeita = true;
					break;
					
				case 2:
					Jogo jogo = new Jogo();
					utils.fazerTransicaoComDelay(20);
					jogo.criacaoPersonagem();
					utils.fazerTransicaoComDelay(10);
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

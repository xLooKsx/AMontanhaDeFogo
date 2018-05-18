package br.pessoal.menus;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.pessoal.utils.Utils;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	
	private Utils utils = new Utils();
	
	private int opcaoEscolhida;
	private String opcaoEscolhidaAUX;
	private boolean	escolhaFeita = false;

	public void telaInicial() {

		try {
			
			utils.transicao(10);
			utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.menu"));
			utils.transicao(10);

			do {
				System.out.print(utils.getMessageProperty("br.pessoal.menu.opcao.desejada.mensagem.2P"));
				opcaoEscolhidaAUX = scanner.nextLine();

				if (utils.inputIsNumber(opcaoEscolhidaAUX)) {
					
					opcaoEscolhida = Integer.parseInt(opcaoEscolhidaAUX);
					switch (opcaoEscolhida) {
					case 1:
						Start opcaoStart = new Start();
						System.out.println("opcaoStart");
						utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.mensagem.carregando"));						
						utils.transicao(20);
						escolhaFeita = true;
						break;

					case 2:
						Ajuda opcaoAjuda = new Ajuda();
						utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.mensagem.carregando"));						
						utils.transicao(20);
						opcaoAjuda.telaAjuda();
						escolhaFeita = true;
						break;
						
					case 3:
						Sobre opcaoSobre = new Sobre();
						utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.mensagem.carregando"));						
						utils.transicao(20);
						opcaoSobre.telaSobre();
						escolhaFeita = true;
						break;

					case 4:
						utils.transicao(30);
						utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.mensagem.final"));
						System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.sair.mensagem"));
						utils.transicao(10);
						System.exit(0);
						break;

					default:
						System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
						escolhaFeita = true;
						break;
					}
				}else {
					System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
				}


			} while (!escolhaFeita);
		} catch (Exception e) {
			Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, utils.getMessageProperty("br.pessoal.menu.erro.mensagem"), e);
		}
		

	}
}

package br.pessoal.jogo;

import java.util.Scanner;

import br.pessoal.to.JogadorTO;
import br.pessoal.utils.Status;
import br.pessoal.utils.Utils;

public class Pocoes implements Status{

	private Utils utils = new Utils();
	private Scanner scanner = new Scanner(System.in);
	
	private int opcaoEscolhida;	
	private boolean escolhaFeita;	
	private String opcaoEscolhidaAUX;
	
	public void escolherPocaoInicial(JogadorTO jogadorTO) {
		
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
					jogadorTO.addInventario("HABILIDADE");
					escolhaFeita = true;
					break;
					
				case 2:
					jogadorTO.addInventario("FORÇA");
					escolhaFeita = true;
					break;
					
				case 3:
					jogadorTO.addInventario("SORTE");
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

	@Override
	public void atualizarDados(JogadorTO jogadorTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preencherInterface(JogadorTO jogadorTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int lancarDados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void usarSorte() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String usarItem(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}

package br.pessoal.menus;

import java.util.Scanner;

import br.pessoal.utils.Utils;

public class Ajuda {

	private Utils utils = new Utils();
//	private Map<Integer, String> arquivos = new HashMap<>() ;
	private String[]arquivosAjuda;
	private Scanner scanner = new Scanner(System.in);
	
	private String opcaoEscolhidaAUX;
	
	private int opcaoEscolhida; 
	
	private boolean	escolhaFeita = false;
	
	private int pgInicial;
	private int pgFinal;
	private int pgAtual;
	private int pgProxima;
	private int pgAnterior;
	
	public Ajuda() {
		
		arquivosAjuda = utils.lerArquivos(utils.getConfigProperty("br.pessoal.caminho.arquivo.ajuda"));
		pgInicial = 0;
		pgFinal = arquivosAjuda.length;
		pgAtual = 0;
		pgProxima = pgAtual + 1;		
		pgAnterior = pgAtual - 1;		
	}
	
	public void telaAjuda() {				
		
		utils.fazerTransicaoComDelay(10);
		System.out.println(arquivosAjuda[pgAtual]);
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
					proximaPagina();
					break;
					
				case 3:
					proximaAnterior();
					break;


				default:
					utils.fazerTransicaoComDelay(20);			
					System.out.println(arquivosAjuda[pgAtual]);
					utils.fazerTransicaoComDelay(5);
					break;
				}
			}else {
				utils.fazerTransicaoComDelay(20);			
				System.out.println(arquivosAjuda[pgAtual]);
				utils.fazerTransicaoComDelay(5);
			}


		} while (!escolhaFeita);
		
	}

	private void proximaAnterior() {

		
		if (pgAnterior > pgInicial -1) {
			utils.fazerTransicaoComDelay(20);			
			System.out.println(arquivosAjuda[pgAnterior]);
			pgAnterior--;			
			pgAtual--;
			pgProxima--;
			utils.fazerTransicaoComDelay(5);
			
		}else {
			utils.fazerTransicaoComDelay(20);			
			System.out.println(arquivosAjuda[pgAtual]);
			utils.fazerTransicaoComDelay(5);
		}
		
	}

	private void proximaPagina() {
		
		
		if (pgProxima < pgFinal + 1) {
			utils.fazerTransicaoComDelay(20);
			System.out.println(arquivosAjuda[pgProxima]);
			pgAnterior++;			
			pgAtual++;
			pgProxima++;
			utils.fazerTransicaoComDelay(5);
			
		}else {
			utils.fazerTransicaoComDelay(20);			
			System.out.println(arquivosAjuda[pgAtual]);
			utils.fazerTransicaoComDelay(5);
		}
		
		
	}



}

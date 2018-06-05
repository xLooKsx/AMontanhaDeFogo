package br.pessoal.jogo;

import java.util.Scanner;

import br.pessoal.to.InimigoTO;
import br.pessoal.to.JogadorTO;
import br.pessoal.utils.Utils;
import br.pessoal.utils.Status;

public class Batalha implements Status {

	Utils utils = new Utils();
	private JogadorTO jogadorTO;
	private Scanner scanner = new Scanner(System.in);

	private int vlrDado1;
	private int vlrDado2;

	private int vlrAtkInimigo;
	private int vlrAtkJogador;

	private int opcaoEscolhida;
	private int totalSorte;

	private int danoCausado;
	private int danoSofrido;

	private String opcaoEscolhidaAUX;

	private boolean escolhaFeita = false;

	public Batalha(JogadorTO jogadorTO) {
		this.jogadorTO = jogadorTO;
	}

	public JogadorTO batalha(InimigoTO inimigoTO) {

		try {

			do {
				// 1º passo
				System.out.println(utils.getMessageProperty("br.pessoal.jogo.batalha.turno.inimigo"));
				vlrDado1 = utils.getValorDado();
				vlrDado2 = utils.getValorDado();
				vlrAtkInimigo = vlrDado1 + vlrDado2;
				System.out.println(
						utils.getMessageProperty("br.pessoal.jogo.batalha.inimigo.label") + " " + inimigoTO.getNome() + utils.getMessageProperty("br.pessoal.jogo.batalha.lanca.ataque.label") + " " + vlrAtkInimigo + " " + utils.getMessageProperty("br.pessoal.jogo.batalha.de.dano.label"));

				Thread.sleep(100);

				// 2º passo
				System.out.println(utils.getMessageProperty("br.pessoal.jogo.batalha.turno.jogador"));
				vlrDado1 = lancarDados();
				vlrDado2 = utils.getValorDado();
				vlrAtkJogador = vlrDado1 + vlrDado2;
				System.out.println(utils.getMessageProperty("br.pessoal.jogo.batalha.jogador.lanca.ataque.label") + " " + vlrAtkJogador + " " + utils.getMessageProperty("br.pessoal.jogo.batalha.de.dano.label"));

				// 3º passo
				if (vlrAtkJogador > vlrAtkInimigo) {

					System.out.println(utils.getMessageProperty("br.pessoal.jogo.batalha.causou.dano.label"));
					escolherCritico(utils.getMessageProperty("br.pessoal.jogo.batalha.causar.critico.label"));
					inimigoTO.setEnergia(inimigoTO.getEnergia() - danoCausado);

				} else if (vlrAtkInimigo > vlrAtkJogador) {

					System.out.println(utils.getMessageProperty("br.pessoal.jogo.batalha.receber.dano.label"));
					escolherCritico(utils.getMessageProperty("br.pessoal.jogo.batalha.reduzir.dano.label"));
					jogadorTO.setEnergia(jogadorTO.getEnergia() - danoSofrido);

				} else {

					System.out.println(utils.getMessageProperty("br.pessoal.jogo.batalha.dano.igual.label"));
				}

			} while (inimigoTO.getEnergia() > 0);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}

		return this.jogadorTO;
	}

	private void escolherCritico(String mensagem) {

		do {
			System.out.print(utils.getMessageProperty("br.pessoal.jogo.batalha.usar.dano.label") + " " + mensagem + " " + utils.getMessageProperty("br.pessoal.jogo.acao.escolher.sim.nao.label"));
			opcaoEscolhidaAUX = scanner.nextLine();

			if (utils.inputIsNumber(opcaoEscolhidaAUX)) {

				opcaoEscolhida = Integer.parseInt(opcaoEscolhidaAUX);
				switch (opcaoEscolhida) {
				case 1:
					
					System.out.println(utils.getMessageProperty("br.pessoal.jogo.acao.lancar.primeiro.dado.label"));
					vlrDado1 = lancarDados();
					System.out.println(utils.getMessageProperty("br.pessoal.jogo.acao.lancar.segundo.dado.label"));
					vlrDado2 = lancarDados();
					totalSorte = vlrDado1 + vlrDado2;
					usarSorte();
					escolhaFeita = true;
					break;

				case 2:

					danoCausado = 2;
					escolhaFeita = true;
					break;

				default:
					System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
					escolhaFeita = true;
					break;
				}
			} else {
				System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
			}

		} while (!escolhaFeita);
	}

	@Override
	public void atualizarDados(JogadorTO jogadorTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public int lancarDados() {

		String vlrOpcao;

		do {

			System.out.print(utils.getMessageProperty("br.pessoal.jogo.acao.lancar.dados.2P"));
			vlrOpcao = scanner.nextLine();

			while (!utils.inputIsNumber(vlrOpcao)) {

				System.out.print(utils.getMessageProperty("br.pessoal.jogo.acao.lancar.dados.2P"));
				vlrOpcao = scanner.nextLine();
			}

		} while (Integer.parseInt(vlrOpcao) != 1);

		return utils.getValorDado();
	}

	@Override
	public void preencherInterface(JogadorTO jogadorTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void usarSorte() {

		if (totalSorte <= jogadorTO.getSorte()) {

			danoSofrido = 1;
			danoCausado = 4;
			jogadorTO.setSorte(jogadorTO.getSorte() - 1);
		} else {

			danoSofrido = 3;
			danoCausado = 1;
			jogadorTO.setSorte(jogadorTO.getSorte() - 1);
		}
	}

	@Override
	public String usarItem(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}

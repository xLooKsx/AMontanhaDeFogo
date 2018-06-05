package br.pessoal.jogo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import br.pessoal.menus.Ajuda;
import br.pessoal.menus.Menu;
import br.pessoal.menus.Sobre;
import br.pessoal.to.JogadorTO;
import br.pessoal.utils.Utils;
import br.pessoal.utils.Status;

public class Jogo implements Status{

	private Scanner scanner = new Scanner(System.in);
	
	private String[] configLvl = new String[8];
	private StringBuilder mapa = new StringBuilder();
	
	private JogadorTO jogadorTO;
	private Pocoes pocao = new Pocoes();
	private Utils utils = new Utils();		
	
	private int opcaoEscolhida;
	private String opcaoEscolhidaAUX;
	private boolean	escolhaFeita = false;
	
	private Map<String, List<Integer>> itens = new HashMap<>();
	private Map<String, List<Integer>> pocoes = new HashMap<>();

	
	
	public Jogo() {
	
	}



	public void criacaoPersonagem() {

		jogadorTO = new JogadorTO();
		jogadorTO.setQtdProvicoes(10);
		jogadorTO.addInventario(utils.getMessageProperty("br.pessoal.jogo.nome.itens.espada"));
		jogadorTO.addInventario(utils.getMessageProperty("br.pessoal.jogo.nome.itens.escudo"));		
		jogadorTO.addInventario(utils.getMessageProperty("br.pessoal.jogo.nome.itens.armadura.couro"));	
		jogadorTO.addInventario(utils.getMessageProperty("br.pessoal.jogo.nome.itens.lanterna"));	
		
		preencherInterface(jogadorTO);
		utils.fazerTransicaoComDelay(10);
		
		//INSERINDO O NOME
		System.out.print(utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.insira.nome.label.2P"));
		jogadorTO.setNome(scanner.nextLine());
		atualizarDados(jogadorTO);
		
		//DEFININDO O NIVEL DA HABILIDADE
		System.out.println(utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.escolher.nivel.habilidade.label"));
		jogadorTO.setHabilidadeInicial(lancarDados() + 6);	
		jogadorTO.setHabilidade(jogadorTO.getHabilidadeInicial());
		atualizarDados(jogadorTO);
						
		//DEFININDO A QUANTIDADE DE ENERGIA
		System.out.println(utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.escolher.nivel.energia.pt1.label"));
		jogadorTO.setEnergiaInicial(lancarDados());
		
		System.out.println(utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.escolher.nivel.energia.pt2.label"));
		jogadorTO.setEnergiaInicial(lancarDados() + (jogadorTO.getEnergiaInicial()+12));
		jogadorTO.setEnergia(jogadorTO.getEnergiaInicial());
		atualizarDados(jogadorTO);
		
		//DEFININDO A QUANTIDADE DE SORTE
		System.out.println(utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.escolher.qtd.sorte.label"));
		jogadorTO.setSorteInicial(lancarDados() + 6);	
		jogadorTO.setSorte(jogadorTO.getSorteInicial());		
		atualizarDados(jogadorTO);
		
		do {
			System.out.println(utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.corfirmar.escolha"));
			opcaoEscolhidaAUX = scanner.nextLine();
			if (utils.inputIsNumber(opcaoEscolhidaAUX)) {
				opcaoEscolhida = Integer.parseInt(opcaoEscolhidaAUX);
				switch (opcaoEscolhida) {
				case 1:
					try {
						utils.fazerTransicaoSemDelay(20);
						pocao.escolherPocaoInicial(jogadorTO);
						atualizarDados(jogadorTO);
						Thread.sleep(5000);
						mapa.append("|   ");
						mapa.append("\n");
						carregarLvl("001");
						escolhaFeita = true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 2:
					utils.fazerTransicaoComDelay(10);
					criacaoPersonagem();
					escolhaFeita = true;
					break;

				case 3:
					Menu menu = new Menu();
					menu.telaInicial();
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
	
	private void carregarFases() {
		
		do {
			System.out.print(utils.getMessageProperty("br.pessoal.menu.opcao.desejada.mensagem.2P"));
			opcaoEscolhidaAUX = scanner.nextLine();
			utils.fazerTransicaoComDelay(10);

			if (configLvl[0].toString().contains(opcaoEscolhidaAUX) || configLvl[2].toString().contains(opcaoEscolhidaAUX)) {				
				
				if (configLvl[0].toString().contains(opcaoEscolhidaAUX)) {
					
					mapa.append(configLvl[3].toString());					
				}else if (configLvl[2].toString().contains(opcaoEscolhidaAUX)) {
					
					mapa.append(configLvl[3].toString());
				}				
			}else {
				System.out.println(utils.getMessageProperty("br.pessoal.menu.opcao.invalida.mensagem"));
			}


		} while (!escolhaFeita);
	}
	
	@Override
	public void atualizarDados(JogadorTO jogadorTO) {
		
		utils.fazerTransicaoSemDelay(20);		
		preencherInterface(jogadorTO);
		utils.fazerTransicaoSemDelay(10);
	}

	@Override
	public void preencherInterface(JogadorTO jogadorTO) {

		try {
			StringWriter writer = new StringWriter();
			VelocityContext context = new VelocityContext();
			VelocityEngine ve = new VelocityEngine();
			Properties props = new Properties();   
			
			props.put("file.resource.loader.path", System.getProperty("user.dir"));

			ve.init(props);

			context.put("lblNome", utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.nome.label.2P"));
			context.put("lblHabilidade",
					utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.habilidade.label.2P"));
			context.put("lblEnergia", utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.energia.label.2P"));
			context.put("lblSorte", utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.sorte.label.2P"));
			context.put("lblQtdProvicoes",
					utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.qtd.provicoes.label.2P"));
			context.put("lblOuro", utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.ouro.label.2P"));
			context.put("lblLista", utils.getMessageProperty("br.pessoal.jogo.criacao.personagem.lista.itens.label"));

			context.put("vlrNome", jogadorTO.getNome());
			context.put("vlrHabilidade", jogadorTO.getHabilidade());
			context.put("vlrEnergia", jogadorTO.getEnergia());
			context.put("vlrSorte", jogadorTO.getSorte());
			context.put("vlrQtdProv", jogadorTO.getQtdProvicoes());
			context.put("vlrOuro", jogadorTO.getOuro());
			context.put("vlrListIntens", jogadorTO.getInventario());

			Template t = ve.getTemplate(utils.getConfigProperty("br.pessoal.caminho.arquivo.jogo.criacao.personagem"));
			
			t.merge(context, writer);
			System.out.println(writer.toString());			
			writer.close();
		} catch (IOException e) {			 
			e.printStackTrace();
		}
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

	private void carregarLvl(String lvl) {
		
		utils.lerArquivo(utils.getConfigProperty("br.pessoal.caminho.arquivo.lvl.jogo")+lvl+".txt");
		carregarConfigLvl(lvl);
		carregarFases();
	}
	
private void carregarConfigLvl(String lvl) {
				
		configLvl = utils.carregarConfigLvl(utils.getConfigProperty("br.pessoal.caminho.arquivo.config.lvl.jogo")+lvl+".txt");
		for (int i = 0; i < configLvl.length; i++) {
			System.out.println(configLvl[i]);
		}
		
	}
	
	@Override
	public void usarSorte() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String usarItem(String nome) {
		
		
		return null;
	}
}

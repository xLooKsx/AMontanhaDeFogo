package br.pessoal.jogo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import br.pessoal.menus.Menu;
import br.pessoal.to.JogadorTO;
import br.pessoal.utils.Utils;
import br.pessoal.utils.Status;

public class Jogo implements Status{

	private Scanner scanner = new Scanner(System.in);
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
		jogadorTO.addInventario("ESPADA");
		jogadorTO.addInventario("ESCUDO");		
		jogadorTO.addInventario("ARMADURA DE COURO");	
		jogadorTO.addInventario("LANTERNA");	
		
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
			System.out.println(" PRESSIONE 1 PARA CONTINUAR \n PRESSIONE 2 PARA CRIAR O PERSONAGEM NOVAMENTE \n PRESSIONE 3 PARA VOLTAR AO MENU ");
			opcaoEscolhidaAUX = scanner.nextLine();
			if (utils.inputIsNumber(opcaoEscolhidaAUX)) {
				opcaoEscolhida = Integer.parseInt(opcaoEscolhidaAUX);
				switch (opcaoEscolhida) {
				case 1:
					utils.fazerTransicaoSemDelay(20);	
					pocao.escolherPocaoInicial(jogadorTO);
					atualizarDados(jogadorTO);					
					escolhaFeita = true;
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

	@Override
	public void usarSorte() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public String usarItem(String nome) {
		
		
		return null;
	}
}

package br.pessoal.jogo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Scanner;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import br.pessoal.to.JogadorTO;
import br.pessoal.utils.Utils;

public class Jogo {

	private Scanner scanner = new Scanner(System.in);

	private Utils utils = new Utils();		

	public void criacaoPersonagem() {

		JogadorTO jogadorTO = new JogadorTO();
		jogadorTO.addEquipamento("ESPADA");
		jogadorTO.addEquipamento("ESCUDO");		
		
		preencherMenu(jogadorTO);
		utils.fazerTransicaoComDelay(10);
		
		//INSERINDO O NOME
		System.out.print("INSIRA O SEU NOME: ");
		jogadorTO.setNome(scanner.nextLine());
		atualizarDados(jogadorTO);
		
		//DEFININDO O NIVEL DA HABILIDADE
		System.out.println("HORA DE ESCOLHER O SEU NIVEL DE HABILIDADE !");
		jogadorTO.setHabilidadeInicial(definirVlrStatus() + 6);	
		jogadorTO.setHabilidade(jogadorTO.getHabilidadeInicial());
		atualizarDados(jogadorTO);
						
		//DEFININDO A QUANTIDADE DE ENERGIA
		System.out.println("HORA DE ESCOLHER O SEU NIVEL DE ENERGIA, 1º Lançamento \\(*o*)/!");
		jogadorTO.setEnergiaInicial(definirVlrStatus());
		
		System.out.println("HORA DE ESCOLHER O SEU NIVEL DE ENERGIA, 2º Lançamento ( - .-)!");
		jogadorTO.setEnergiaInicial(definirVlrStatus() + (jogadorTO.getEnergiaInicial()+12));
		jogadorTO.setEnergia(jogadorTO.getEnergiaInicial());
		atualizarDados(jogadorTO);
		
		//DEFININDO A QUANTIDADE DE SORTE
		System.out.println("HORA DE ESCOLHER A SUA QUANTIDADE DE SORTE =D");
		jogadorTO.setSorteInicial(definirVlrStatus() + 6);	
		jogadorTO.setSorte(jogadorTO.getSorteInicial());		
		atualizarDados(jogadorTO);
		
	}
	
	private void atualizarDados(JogadorTO jogadorTO) {
		
		utils.fazerTransicaoSemDelay(20);		
		preencherMenu(jogadorTO);
		utils.fazerTransicaoSemDelay(10);
	}

	private void preencherMenu(JogadorTO jogadorTO) {

		try {
			StringWriter writer = new StringWriter();
			VelocityContext context = new VelocityContext();
			VelocityEngine ve = new VelocityEngine();
			
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();

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
			context.put("vlrListIntens", jogadorTO.getEquipamentos());

			Template t = ve.getTemplate(utils.getConfigProperty("br.pessoal.caminho.arquivo.jogo.criacao.personagem"));
			t.merge(context, writer);
			System.out.println(writer.toString());			
			writer.close();
		} catch (IOException e) {			 
			e.printStackTrace();
		}
	}
	
	private int definirVlrStatus() {
				
		String vlrOpcao;
		
		do {
			
			System.out.print("PRESSIONE 1 PARA LANÇAR OS DADOS: ");
			vlrOpcao = scanner.nextLine();
			
			while (!utils.inputIsNumber(vlrOpcao)) {
				
				System.out.print("PRESSIONE 1 PARA LANÇAR OS DADOS: ");
				vlrOpcao = scanner.nextLine();
			}
			
			
		} while (Integer.parseInt(vlrOpcao) != 1);
					
		return utils.lancarDados();
	}
}

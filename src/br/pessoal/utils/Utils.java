package br.pessoal.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.pessoal.to.JogadorTO;

public class Utils {
	

	public static void desenharAsc(String palavra) {

		int width = 300;
		int height = 30;

		// BufferedImage image = ImageIO.read(new
		// File("/Users/mkyong/Desktop/logo.jpg"));
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 14));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(palavra, 10, 20);

		// save this image
		// ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {

				sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

			}

			if (sb.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(sb);
		}

	}

	private static ResourceBundle getConfig() {

		ResourceBundle bundle = ResourceBundle.getBundle("br.pessoal.resources.Config");
		return bundle;
	}

	public String getConfigProperty(String key) {
		return getConfig().getString(key);
	}

	private static ResourceBundle getMessage() {

		ResourceBundle bundle = ResourceBundle.getBundle("br.pessoal.resources.Message");
		return bundle;
	}

	public String getMessageProperty(String key) {

		String text;
		try {

			// Locale locale = Locale.getDefault();
			text = getMessage().getString(key);
		} catch (MissingResourceException e) {
			text = String.format("%s não econtrado.", key);
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
		}
		return text;
	}

	public Map<String, List<Integer>> getItens(String arquivo) {

		
		Map<String, List<Integer>> registros = new HashMap<>();		 
		try {
		StringBuilder conteudo = new StringBuilder();
		FileReader arq = new FileReader(arquivo);
		BufferedReader lerArq = new BufferedReader(arq);
		String linha = lerArq.readLine();
		
			while (linha != null) {
				
				String nome = linha.substring(0, linha.indexOf('-')).replaceAll("_", " ");
				List<Integer> atributos = adicionarAtributo(linha);

				registros.put(nome, atributos);
				linha = lerArq.readLine();
			}
			arq.close();
			System.out.println(conteudo.toString());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return registros;
	}

	/*
	 * A sequencia dos atributos são:
	 * 1º DANO
	 * 2º ENERGIA
	 * 3º HABILIDADE
	 * 4º PERMITE QUE OS STATUS INICIAIS AUMENTEM
	 */
	private List<Integer> adicionarAtributo(String linha) {

		List<Integer> atributos = new ArrayList<>();
		String atributoAux;
		int indexAux = linha.lastIndexOf('-');
		
		//DANO
		int posInicial = indexAux-2;		
		int posFinal = indexAux;				
		atributoAux = linha.substring(posInicial, posFinal);
		atributos.add(Integer.parseInt(atributoAux));
		
		//ENERGIA
		posInicial = indexAux+1;		
		posFinal = linha.lastIndexOf(':');	
		atributoAux = linha.substring(posInicial, posFinal);
		atributos.add(Integer.parseInt(atributoAux));
		
		//HABILIDADE
		posInicial = indexAux-5;		
		posFinal = posInicial+2;
		atributoAux = linha.substring(posInicial, posFinal);
		atributos.add(Integer.parseInt(atributoAux));
			
		//CAMPO ESPECIAL
		atributoAux = linha.substring(linha.lastIndexOf(':')+1);
		atributos.add(Integer.parseInt(atributoAux));
		
		return atributos;
	}

	public void lerArquivo(String arquivo) {

		try {
			StringBuilder conteudo = new StringBuilder();
			FileReader arq = new FileReader(arquivo);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			while (linha != null) {
				conteudo.append(linha + "\n");

				linha = lerArq.readLine();
			}
			arq.close();
			System.out.println(conteudo.toString());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public String[] lerArquivos(String arquivo) {

		File dir = new File(arquivo);
		int index = 0;
		StringBuilder conteudo = new StringBuilder();
		String[] arquivos = new String[dir.listFiles().length];

		try {
			for (File file : dir.listFiles()) {				
				FileReader arq = new FileReader(file.getPath());
				BufferedReader lerArq = new BufferedReader(arq);

				String linha = lerArq.readLine();
				while (linha != null) {
					conteudo.append(linha + "\n");

					linha = lerArq.readLine();
				}
				lerArq.close();
				arquivos[index] = conteudo.toString();
				index++;
				conteudo.delete(0, conteudo.length());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arquivos;
	}
	
	public void usarProvicao(JogadorTO jogadorTO) {
		
		int transbordo = 0;
		
		if (jogadorTO.getQtdProvicoes() > 0 && jogadorTO.getEnergia() < jogadorTO.getEnergiaInicial()) {
			
			jogadorTO.setQtdProvicoes(jogadorTO.getQtdProvicoes()-1);			
			jogadorTO.setEnergia(jogadorTO.getEnergia() +4);
			transbordo = jogadorTO.getEnergiaInicial() - jogadorTO.getEnergia();			
			
			if (transbordo < 0) {
				jogadorTO.setEnergia(jogadorTO.getEnergia() + (transbordo));
			}
			
		}			
	}
	
	public void restaurarSorte(JogadorTO jogadorTO, int VlrAumento) {
		
		int transbordo = 0;
		
		if (jogadorTO.getSorte() < jogadorTO.getSorteInicial()) {
								
			jogadorTO.setSorte(jogadorTO.getSorte() + VlrAumento);
			transbordo = jogadorTO.getSorteInicial() - jogadorTO.getSorte();			
			
			if (transbordo < 0) {
				jogadorTO.setSorte(jogadorTO.getSorte() + (transbordo));
			}
			
		}			
	}
	
	public void restaurarEnergia(JogadorTO jogadorTO, int VlrAumento) {
		
		int transbordo = 0;
		
		if (jogadorTO.getEnergia() < jogadorTO.getEnergiaInicial()) {
								
			jogadorTO.setEnergia(jogadorTO.getEnergia() + VlrAumento);
			transbordo = jogadorTO.getEnergiaInicial() - jogadorTO.getEnergia();			
			
			if (transbordo < 0) {
				jogadorTO.setEnergia(jogadorTO.getEnergia() + (transbordo));
			}
			
		}			
	}

	public boolean inputIsNumber(String input){
		
		if (input.matches("[0-9]")) {
			return true;
		}
		
		return false;
	}
	
	public int getValorDado() {
		return (int)(Math.random() * 6)+1;
	}
	
	public void fazerTransicaoComDelay(int espacamento) {

		try {
			for (int i = 0; i < espacamento; i++) {
				System.out.println("");
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void fazerTransicaoSemDelay(int espacamento) {

		try {
			for (int i = 0; i < espacamento; i++) {
				System.out.println("");				
			}
		} catch (Exception e) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

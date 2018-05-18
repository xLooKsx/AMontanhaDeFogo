package br.pessoal.utils;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

//	private static final Logger logger = Logger.getLogger(Utils.class.getName());

	public static void desenharAsc(String palavra) {

		int width = 300;
		int height = 30;

		// BufferedImage image = ImageIO.read(new
		// File("/Users/mkyong/Desktop/logo.jpg"));
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));

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

	public boolean inputIsNumber(String input){
		
		if (input.matches("[0-9]")) {
			return true;
		}
		
		return false;
	}
	
	public void transicao(int espacamento) {

		try {
			for (int i = 0; i < espacamento; i++) {
				System.out.println("");
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}

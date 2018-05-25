package br.pessoal.to;

public class Pocoes {

	private String nome;
	private int qtdUso;
	private int vlrBonus;
	
	
	public Pocoes() {
		this("", 0, 0);
	}


	public Pocoes(String nome, int qtdUso, int vlrBonus) {
		super();
		this.nome = nome;
		this.qtdUso = qtdUso;
		this.vlrBonus = vlrBonus;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQtdUso() {
		return qtdUso;
	}


	public void setQtdUso(int qtdUso) {
		this.qtdUso = qtdUso;
	}


	public int getVlrBonus() {
		return vlrBonus;
	}


	public void setVlrBonus(int vlrBonus) {
		this.vlrBonus = vlrBonus;
	}	
	
}

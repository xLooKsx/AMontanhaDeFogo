package br.pessoal.to;

public class InimigoTO {
	
	private String nome;
	private int habilidade;
	private int energia;
	
		
	public InimigoTO() {
		this("", 0, 0);
	}


	public InimigoTO(String nome, int habilidade, int energia) {
		super();
		this.nome = nome;
		this.habilidade = habilidade;
		this.energia = energia;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getHabilidade() {
		return habilidade;
	}


	public void setHabilidade(int habilidade) {
		this.habilidade = habilidade;
	}


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
}

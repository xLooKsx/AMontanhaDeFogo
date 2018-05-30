package br.pessoal.to;

public class ArmaTO {

	private String nome;
	private int habilidadeAdicional;
	private int danoAdicional;
	private String tipo;
	
		
	public ArmaTO() {
		this("", 0, 0, "");
	}


	public ArmaTO(String nome, int habilidadeAdicional, int danoAdicional, String tipo) {
		super();
		this.nome = nome;
		this.habilidadeAdicional = habilidadeAdicional;
		this.danoAdicional = danoAdicional;
		this.tipo = tipo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getHabilidadeAdicional() {
		return habilidadeAdicional;
	}


	public void setHabilidadeAdicional(int habilidadeAdicional) {
		this.habilidadeAdicional = habilidadeAdicional;
	}


	public int getDanoAdicional() {
		return danoAdicional;
	}


	public void setDanoAdicional(int danoAdicional) {
		this.danoAdicional = danoAdicional;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}			
		
}

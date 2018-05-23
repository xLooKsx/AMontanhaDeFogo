package br.pessoal.to;

public class ArmaTO {

	private String nome;
	private int habilidadeAdicional;
			
	public ArmaTO() {
		this("", 0);
	}

	public ArmaTO(String nome, int habilidadeAdicional) {
		super();
		this.nome = nome;
		this.habilidadeAdicional = habilidadeAdicional;
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

	@Override
	public String toString() {
		return "ArmaTO [nome=" + nome + ", habilidadeAdicional=" + habilidadeAdicional + "]";
	}
		
}

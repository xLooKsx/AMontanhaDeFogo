package br.pessoal.to;

import java.util.ArrayList;
import java.util.List;

public class JogadorTO {

	private String nome;

	private int habilidade;
	private int habilidadeInicial;
	private int energia;
	private int energiaInicial;
	private int sorte;
	private int sorteInicial;
	private int qtdProvicoes;
	private int ouro;

	private List<String> inventario = new ArrayList<>();
	private List<ArmaTO> equipamentos = new ArrayList<>();
	private List<JoiaTO> joias = new ArrayList<>();
	private List<PocoesTO> pocoes = new ArrayList<>();
	private List<InimigoTO> bestiario = new ArrayList<>();
	
	
	public JogadorTO() {
		this("", 0, 0, 0, 0, 0, 0, 0, 0);
	}

	
	public JogadorTO(String nome, int habilidade, int habilidadeInicial, int energia, int energiaInicial, int sorte,
			int sorteInicial, int qtdProvicoes, int ouro) {
		
		this.nome = nome;
		this.habilidade = habilidade;
		this.habilidadeInicial = habilidadeInicial;
		this.energia = energia;
		this.energiaInicial = energiaInicial;
		this.sorte = sorte;
		this.sorteInicial = sorteInicial;
		this.qtdProvicoes = qtdProvicoes;
		this.ouro = ouro;		
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


	public int getHabilidadeInicial() {
		return habilidadeInicial;
	}


	public void setHabilidadeInicial(int habilidadeInicial) {
		this.habilidadeInicial = habilidadeInicial;
	}


	public int getEnergia() {
		return energia;
	}


	public void setEnergia(int energia) {
		this.energia = energia;
	}


	public int getEnergiaInicial() {
		return energiaInicial;
	}


	public void setEnergiaInicial(int energiaInicial) {
		this.energiaInicial = energiaInicial;
	}


	public int getSorte() {
		return sorte;
	}


	public void setSorte(int sorte) {
		this.sorte = sorte;
	}


	public int getSorteInicial() {
		return sorteInicial;
	}


	public void setSorteInicial(int sorteInicial) {
		this.sorteInicial = sorteInicial;
	}


	public int getQtdProvicoes() {
		return qtdProvicoes;
	}


	public void setQtdProvicoes(int qtdProvicoes) {
		this.qtdProvicoes = qtdProvicoes;
	}


	public int getOuro() {
		return ouro;
	}


	public void setOuro(int ouro) {
		this.ouro = ouro;
	}


	public List<String> getInventario() {
		return inventario;
	}


	public void setInventario(List<String> inventario) {
		this.inventario = inventario;
	}


	public List<ArmaTO> getEquipamentos() {
		return equipamentos;
	}


	public void setEquipamentos(List<ArmaTO> equipamentos) {
		this.equipamentos = equipamentos;
	}


	public List<JoiaTO> getJoias() {
		return joias;
	}


	public void setJoias(List<JoiaTO> joias) {
		this.joias = joias;
	}


	public List<PocoesTO> getPocoes() {
		return pocoes;
	}


	public void setPocoes(List<PocoesTO> pocoes) {
		this.pocoes = pocoes;
	}


	public List<InimigoTO> getBestiario() {
		return bestiario;
	}


	public void setBestiario(List<InimigoTO> bestiario) {
		this.bestiario = bestiario;
	}


	public void addInventario(String equipamento) {
		this.inventario.add(equipamento);
	}

	public String listarInventario() {

		StringBuilder builder = new StringBuilder();

		if (!this.equipamentos.isEmpty()) {
			for (String equipamentoDaVez : inventario) {
				builder.append("- "+equipamentoDaVez);
			}
		}else {
			builder.append("Iventario Vazio");
		}
		
		return builder.toString();
	}

	public void removeEquipamento(String equipamento) {
		for (String equipamentoDaVez : inventario) {
			if (equipamentoDaVez.equals(equipamento)) {
				this.equipamentos.remove(equipamentoDaVez);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "JogadorTO [nome=" + nome + ", habilidade=" + habilidade + ", habilidadeInicial=" + habilidadeInicial
				+ ", energia=" + energia + ", energiaInicial=" + energiaInicial + ", sorte=" + sorte + ", sorteInicial="
				+ sorteInicial + ", qtdProvicoes=" + qtdProvicoes + ", ouro=" + ouro + ", equipamentos=" + equipamentos
				+ ", joias=" + joias + ", pocoes=" + pocoes + ", bestiario=" + bestiario + "]";
	}

	

}

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

	private List<String> equipamentos = new ArrayList<>();
	private List<String> joias = new ArrayList<>();
	private List<String> pocoes = new ArrayList<>();
	private List<InimigoTO> bestiario = new ArrayList<>();


	

	public JogadorTO() {
		this("", 0, 0, 0, 0, 0, 0, 0, 0, null, null, null);
	}

	public JogadorTO(String nome, int habilidade, int habilidadeInicial, int energia, int energiaInicial, int sorte,
			int sorteInicial, int qtdProvicoes, int ouro, List<String> joias, List<String> pocoes,
			List<InimigoTO> bestiario) {
		super();
		this.nome = nome;
		this.habilidade = habilidade;
		this.habilidadeInicial = habilidadeInicial;
		this.energia = energia;
		this.energiaInicial = energiaInicial;
		this.sorte = sorte;
		this.sorteInicial = sorteInicial;
		this.qtdProvicoes = qtdProvicoes;
		this.ouro = ouro;
		this.joias = joias;
		this.pocoes = pocoes;
		this.bestiario = bestiario;
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

	public List<String> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<String> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public List<String> getJoias() {
		return joias;
	}

	public void setJoias(List<String> joias) {
		this.joias = joias;
	}

	public List<String> getPocoes() {
		return pocoes;
	}

	public void setPocoes(List<String> pocoes) {
		this.pocoes = pocoes;
	}

	public List<InimigoTO> getBestiario() {
		return bestiario;
	}

	public void setBestiario(List<InimigoTO> bestiario) {
		this.bestiario = bestiario;
	}
	
	public void addEquipamento(String equipamento) {
		this.equipamentos.add(equipamento);
	}

	public String listarEquipamentos() {

		StringBuilder builder = new StringBuilder();

		if (!this.equipamentos.isEmpty()) {
			for (String equipamentoDaVez : equipamentos) {
				builder.append("- "+equipamentoDaVez);
			}
		}else {
			builder.append("Iventario Vazio");
		}
		
		return builder.toString();
	}

	public void removeEquipamento(String equipamento) {
		for (String equipamentoDaVez : equipamentos) {
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

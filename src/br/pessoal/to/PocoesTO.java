package br.pessoal.to;

public class PocoesTO {

	private String nome;
	private static int QTD_USO = 2;
	private int vlrHabilidade;
	private int vlrEnergia;
	private int vlrSorte;
	private boolean aumentaAtributo;
	
		
	public PocoesTO() {
		
		this("", 0, 0, 0, false);
	}


	public PocoesTO(String nome, int vlrHabilidade, int vlrEnergia, int vlrSorte, boolean aumentaAtributo) {		
		this.nome = nome;		
		this.vlrHabilidade = vlrHabilidade;
		this.vlrEnergia = vlrEnergia;
		this.vlrSorte = vlrSorte;
		this.aumentaAtributo = aumentaAtributo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public static int getQTD_USO() {
		return QTD_USO;
	}


	public static void setQTD_USO(int qTD_USO) {
		QTD_USO = qTD_USO;
	}


	public int getVlrHabilidade() {
		return vlrHabilidade;
	}


	public void setVlrHabilidade(int vlrHabilidade) {
		this.vlrHabilidade = vlrHabilidade;
	}


	public int getVlrEnergia() {
		return vlrEnergia;
	}


	public void setVlrEnergia(int vlrEnergia) {
		this.vlrEnergia = vlrEnergia;
	}


	public int getVlrSorte() {
		return vlrSorte;
	}


	public void setVlrSorte(int vlrSorte) {
		this.vlrSorte = vlrSorte;
	}


	public boolean isAumentaAtributo() {
		return aumentaAtributo;
	}


	public void setAumentaAtributo(boolean aumentaAtributo) {
		this.aumentaAtributo = aumentaAtributo;
	}	
}

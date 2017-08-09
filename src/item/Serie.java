package item;

import java.util.ArrayList;
import java.util.List;

public class Serie extends BluRay {

	private List<Integer> colecao;
	private String descricao;
	private Genero genero;
	private int temporada;
	private final String LN = System.lineSeparator();
	
	public Serie(String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		super(nomeItem, preco, duracao, classificacao);
		this.descricao = descricao;
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
		colecao = new ArrayList<>();
	}

	@Override
	public void adicionarBluRay(int duracao) {
		colecao.add(duracao);
		super.setDuracao(super.getDuracao() + duracao);
	}
	
	@Override
	public int getDuracao() {
		int duracao = 0;
		for (int episodio : colecao) {
			duracao += episodio;
		}
		return duracao;
	}
	
	public String getGenero() {
		return genero.getGenero();
	}

	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero);
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + genero.getGenero() + " - " + temporada + ":" + getDuracao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + temporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (temporada != other.temporada)
			return false;
		return true;
	}


}

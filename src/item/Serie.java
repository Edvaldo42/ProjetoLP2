package item;

import java.util.ArrayList;
import java.util.List;

public class Serie extends BluRay {

	private List<Integer> colecao;
	private Genero genero;
	private int temporada;
	private final String LN = System.lineSeparator();
	
	public Serie(String nomeDoItem, double valor, int duracao, String classificacao, String genero, int temporada) {
		super(nomeDoItem, valor, duracao, classificacao);
		
		validaGenero(genero);
		if (temporada < 1) {
			throw new IllegalArgumentException("Temporada nao pode ser menor do que 1");
		}
		
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
		colecao = new ArrayList<>();
	}

	/*public String listaColecao() {
		String msg = "";
		int contador = 1;
		
		for (int episodio : colecao) {
			msg += contador + " - " + bluRay.toString() + LN;
		}
		
		return msg;
	}*/
	
	@Override
	public void adicionarBluRay(int duracao) {
		colecao.add(duracao);		
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
		validaGenero(genero);
		this.genero = Genero.valueOf(genero);
	}

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	
	private void validaGenero(String genero) {
		if (genero == null || genero.trim().equals("")) {
			throw new IllegalArgumentException("Genero nao pode ser nula ou vazia");
		}
		try {
			Genero.valueOf(genero);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Genero invalida");
		}
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

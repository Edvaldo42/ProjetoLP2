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
		
		validaGenero(genero);
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Descricao nao pode ser nula ou vazia");
		}
		if (temporada < 1) {
			throw new IllegalArgumentException("Temporada nao pode ser menor do que 1");
		}
		this.descricao = descricao;
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
		super.setDuracao(super.getDuracao());
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
		if (temporada >= 1) {
			this.temporada = temporada;			
		}
		else {
			throw new IllegalArgumentException("Temporada nao pode ser menor do que 1");
		}
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
		return "SERIE: " + super.toString() + ", " + genero.getGenero() + ", Temporada " + temporada;
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

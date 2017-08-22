package item;

import java.util.ArrayList;
import java.util.List;

import exceptionsItem.GeneroNuloOuVazioException;
import exceptionsItem.TemporadaMenorQue1Exception;

public class Serie extends BluRay {

	private List<Integer> colecao;
	private String descricao;
	private Genero genero;
	private int temporada;
	private final String LN = System.lineSeparator();
	
	/**
	 * Creator de Serie
	 * 
	 * @param nomeItem O nome da serie
	 * @param preco O preco da serie
	 * @param descricao A descricao da serie
	 * @param duracao A duracao da serie
	 * @param classificacao A classificacao etaria da serie
	 * @param genero O genero da serie
	 * @param temporada A temporada da serie
	 */
	public Serie(String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		super(nomeItem, preco, duracao, classificacao);
		this.descricao = descricao;
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
		colecao = new ArrayList<>();
	}

	/**
	 * Adiciona um BluRay
	 */
	@Override
	public void adicionarBluRay(int duracao) {
		colecao.add(duracao);
		super.setDuracao(super.getDuracao());
	}
	
	/**
	 * Retorna a duracao de uma serie
	 * 
	 * @return A duracao de uma serie
	 */
	@Override
	public int getDuracao() {
		int duracao = 0;
		for (int episodio : colecao) {
			duracao += episodio;
		}
		return duracao;
	}
	
	/**
	 * Retora o genero de uma serie
	 * 
	 * @return O genero de uma serie
	 */
	public String getGenero() {
		return genero.getGenero();
	}

	/**
	 * Estabelece o genero de uma serie
	 */
	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero);
	}
	
	/**
	 * Retorna a temporada de uma serie
	 * @return A temporada de uma serie
	 */
	public int getTemporada() {
		return temporada;
	}
	
	/**
	 * Estabelece a temporada de uma serie
	 */
	public void setTemporada(int temporada) throws TemporadaMenorQue1Exception {
		if (temporada >= 1) {
			this.temporada = temporada;			
		}
		else {
			throw new TemporadaMenorQue1Exception();
		}
	}
	
	/**
	 * Valida o genro de uma serie
	 * 
	 * @param genero O genero a ser validado
	 * @throws GeneroNuloOuVazioException Caso o genero seja nulo ou vazio
	 */
	private void validaGenero(String genero) throws GeneroNuloOuVazioException {
		if (genero == null || genero.trim().equals("")) {
			throw new GeneroNuloOuVazioException();
		}
		try {
			Genero.valueOf(genero);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Genero invalida");
		}
	}

	/**
	 * Retorna a representacao textual de serie
	 */
	@Override
	public String toString() {
		return "SERIE: " + super.toString() + ", " + genero.getGenero() + ", Temporada " + temporada;
	}

	/**
	 * HashCode de Serie
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + temporada;
		return result;
	}

	/**
	 * Equal de Serie
	 */
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

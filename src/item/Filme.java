package item;

/**
 * 
 *
 */
public class Filme extends BluRay {
	
	private Genero genero;
	private int anoLancamento;
	
	/**
	 * Construtor do Filme BluRay
	 * 
	 * @param nomeItem O nome do filme
	 * @param preco O preco do filme
	 * @param duracao A duracao do filme
	 * @param genero O genero do filme
	 * @param classificacao A classificacao do filme
	 * @param anoLancamento O ano de lancamento do filme
	 */
	public Filme(String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		super(nomeItem, preco, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.anoLancamento = anoLancamento;
		}

	/**
	 * Retorna o genero do filme
	 * 
	 * @return O genero do filme
	 */
	public String getGenero() {
		return genero.getGenero();
	}

	/**
	 * Estabelece o genero do filme
	 */
	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero);
	}

	/**
	 * Retorna o ano de lancamento do filme
	 * 
	 * @return O ano de lancamento do filme
	 */
	public int getAnoLancamento() {
		return anoLancamento;
	}

	/**
	 * Estabelece o ano de lancamento do filme
	 */
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	/**
	 * Retorna a representacao textual de um filme
	 */
	@Override
	public String toString() {
		return "FILME: " + super.toString() + ", " + this.genero.getGenero() + ", " + this.anoLancamento;
	}

}
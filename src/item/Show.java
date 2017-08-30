package item;

/**
 * 
 *
 */
public class Show extends BluRay {

	private String artista;
	private int numeroFaixas;	
	
	/**
	 * Creator de Show
	 * 
	 * @param nomeItem O nome do BluRay de show
	 * @param preco O preco do BluRay de show
	 * @param duracao A duracao do BluRay de show
	 * @param numeroFaixas O numero de faixas do BluRay de show
	 * @param artista O artista do BluRay de show
	 * @param classificacao A classificacao etaria do BluRay de show
	 */
	public Show(String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		super(nomeItem, preco, duracao, classificacao);
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
	}

	/**
	 * Retorna o artista do BluRay de show
	 * 
	 * @return O artista do BluRay de show
	 */
	public String getNomeArtista() {
		return artista;
	}

	/**
	 * Estabelece o nome do artista
	 * 
	 * @param artista O nome do artista
	 */
	public void setNomeDoArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * Retorna o numero de faixas 
	 * 
	 * @return O numero de faixas
	 */
	public int getFaixas() {
		return numeroFaixas;
	}

	/**
	 * Estabelece o numero de faixas
	 * 
	 * @param faixas O numero de faixas
	 */
	public void setFaixas(int faixas) {
		this.numeroFaixas = faixas;
	}

	/**
	 * Retorna a representacao textual de show
	 */
	@Override
	public String toString() {
		return "SHOW: " + super.toString() + ", " + this.artista + ", " + this.numeroFaixas + " faixas";
	}

}
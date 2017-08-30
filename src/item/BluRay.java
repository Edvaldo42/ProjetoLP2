package item;

/**
 * 
 *
 */
public abstract class BluRay extends Item {
	
	private int duracao;
	private Classificacao classificacao;
	
	/** Construtor de BluRay
	 * 
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param duracao A duracao
	 * @param classificacao A classificacao etaria
	 */
	public BluRay(String nomeItem, double preco, int duracao, String classificacao) {
		super(nomeItem, preco);
		this.duracao = duracao;
		this.classificacao = Classificacao.valueOf(classificacao);
 
	}
	
	/**
	 * Retorna a duracao do BluRay
	 * 
	 * @return A duracao de um BluRay
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * Estabelece a duracao de um BluRay
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	/**
	 * Retorna a classificacao do BluRay
	 * 
	 * @return A classificacao do BluRay
	 */
	public String getClassificacao() {
		return classificacao.getClassificacao();
	}
	
	/**
	 * Estabelece a classificacao de um BluRay
	 */
	public void setClassificacao(String classificacao) {
		this.classificacao = Classificacao.valueOf(classificacao);
	}
	
	/**
	 * Retorna a descricao do bluray
	 */
	public String getDescricao() {
		return "";
	}
	
	/**
	 * Retorna a representacao textual de um BluRay
	 */
	@Override
	public String toString() {
		return super.toString() + ", " + this.duracao + " min, " +
				this.classificacao.getClassificacao();
	}
}

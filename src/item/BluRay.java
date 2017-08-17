package item;

public abstract class BluRay extends Item {

	private int duracao;
	private Classificacao classificacao;
	
/** construtor de BluRay
 * 
 * @param nomeItem
 * @param preco
 * @param duracao
 * @param classificacao
 */
	public BluRay(String nomeItem, double preco, int duracao, String classificacao) {
		super(nomeItem, preco);
		this.duracao = duracao;
		this.classificacao = Classificacao.valueOf(classificacao);
 
	}
	
	/**
	 * Retorna a duracao de um BluRay
	 * 
	 * @return
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * Atualiza a duracao de um BluRay
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	/**
	 * Retorna a classificacao de um BluRay
	 * @return
	 */

	public String getClassificacao() {
		return classificacao.getClassificacao();
	}
	
	/**
	 * Atualiza a classificacao de um Bluray
	 */

	public void setClassificacao(String classificacao) {
		this.classificacao = Classificacao.valueOf(classificacao);
	}
	
	/**
	 * Atualiza o método to String de BluRay
	 */
	@Override
	public String toString() {
		return super.toString() + ", " + this.duracao + " min, " + this.classificacao.getClassificacao();
	}
	
	
}

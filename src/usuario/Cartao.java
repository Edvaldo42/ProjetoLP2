package usuario;

/**
 * 
 *
 */
public enum Cartao {
	
	NOOB("Noob"),
	CALOTEIRO("Caloteiro"),
	BOM_AMIGO("BomAmigo"),
	FREE_RYDER("FreeRyder");
	
	private String cartao;
	
	/**
	 * Creator de cartao
	 * 
	 * @param cartao O cartao
	 */
	private Cartao(String cartao) {
		this.cartao = cartao;
	}
	
	/**
	 * Retorna o cartao de um usuario
	 * 
	 * @return O cartao de um usuario
	 */
	public String getCartao() {
		return this.cartao; 
	}
	
	/**
	 * Retorna a representacao textual de cartao
	 */
	@Override
	public String toString() {
		return this.cartao;
	}

}

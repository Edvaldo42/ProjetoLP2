package item;

/**
 * 
 *
 */
public enum Classificacao {
	
	LIVRE ("LIVRE"),
	DEZ_ANOS ("DEZ_ANOS"),
	DOZE_ANOS ("DOZE_ANOS"),
	QUATORZE_ANOS ("QUATORZE_ANOS"),
	DEZESSEIS_ANOS ("DEZESSEIS_ANOS"),
	DEZOITO_ANOS ("DEZOITO_ANOS");
	
	private String classificacao;

	/**
	 * Contrutor de Classificacao
	 * @param classificacao A classificacao etaria de um BluRay
	 */
	private Classificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	/**
	 * 
	 * @return A classificacao etaria em String
	 */
	public String getClassificacao() {
		return this.classificacao; 
	}
	
}



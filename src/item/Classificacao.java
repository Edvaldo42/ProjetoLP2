package item;

public enum Classificacao {
	
	LIVRE ("LIVRE"),
	DEZ_ANOS ("DEZ_ANOS"),
	DOZE_ANOS ("DOZE_ANOS"),
	QUATORZE_ANOS ("QUATORZE_ANOS"),
	DEZESSEIS_ANOS ("DEZESSEIS_ANOS"),
	DEZOITO_ANOS ("DEZOITO_ANOS");
	
	private String classificacao;
	
	private Classificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	public String getClassificacao() {
		return this.classificacao; 
	}
	
}



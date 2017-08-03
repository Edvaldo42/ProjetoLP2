package item;

public enum Classificacao {
	
	LIVRE ("LIVRE"),
	DEZ_ANOS ("DEZ_ANOS"),
	DOZE_ANOS ("DOZE_ANOS"),
	QUARTOZE_ANOS ("QUARTOZE_ANOS"),
	DEZESSEIS_ANOS ("DEZESSEIS_ANOS"),
	DEZOITO_ANOS ("DEZOITO_ANOS");
	
	private String classificacao;
	
	private Classificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	public String getClassificacao() {
		return this.classificacao; 
	}
	
	/*
	  
	 
		if (classificacao.equalsIgnoreCase("LIVRE")) {
			return Classificacao.LIVRE;
		}
		else if (classificacao.equals("10")) {
			return Classificacao.DEZ_ANOS;
		}
		else if (classificacao.equals("12")) {
			return Classificacao.DOZE_ANOS;
		}
		else if (classificacao.equals("14")) {
			return Classificacao.QUARTOZE_ANOS;
		}
		else if (classificacao.equals("16")) {
			return Classificacao.DEZESSEIS_ANOS;
		}
		else if (classificacao.equals("18")) {
			return Classificacao.DEZOITO_ANOS;
		}
		else {
			throw new IllegalArgumentException("Classificacao invalida");
		}
	}
	*/
}



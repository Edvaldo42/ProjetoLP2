package item;

public enum Classificacao {
	
	LIVRE ("Livre"),
	DEZ_ANOS ("10"),
	DOZE_ANOS ("12"),
	QUARTOZE_ANOS ("14"),
	DEZESSEIS_ANOS ("16"),
	DEZOITO_ANOS ("18");
	
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



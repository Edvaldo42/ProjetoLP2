package item;

public abstract class BluRay extends Item {

	private int duracao;
	private Classificacao classificacao;

	public BluRay(String nomeItem, double preco, int duracao, String classificacao) {
		super(nomeItem, preco);
		
		if (duracao < 0) {
			throw new IllegalArgumentException("Duracao nao pode ser menor do que 0");
		}
		validaPlataforma(classificacao);
		
		this.duracao = duracao;
		this.classificacao = Classificacao.valueOf(classificacao);
 
	}
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getClassificacao() {
		return classificacao.getClassificacao();
	}

	public void setClassificacao(String classificacao) {
		validaPlataforma(classificacao);
		this.classificacao = Classificacao.valueOf(classificacao);
	}

	private void validaPlataforma(String classificacao) {
		if (classificacao == null || classificacao.trim().equals("")) {
			throw new IllegalArgumentException("Classificacao nao pode ser nula ou vazia");
		}
		try {
			Classificacao.valueOf(classificacao);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Classificacao invalida");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + this.duracao + " min, " + this.classificacao.getClassificacao();
	}
	
	
}

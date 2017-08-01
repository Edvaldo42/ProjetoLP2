package item;

public class BluRay extends Item {

	private int duracao;
	private Classificacao classificacao;

	public BluRay(String nomeDoItem, double valor, int duracao, String classificacao) {
		super(nomeDoItem, valor);
		if (classificacao == null || classificacao.trim().equals("")) {
			throw new IllegalArgumentException("Classificacao nao pode ser nula ou vazia");
		}
		try {
			Classificacao.valueOf(classificacao);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Classificacao invalida");
		}
		this.duracao = duracao;
		this.classificacao = Classificacao.valueOf(classificacao);
 
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.duracao + " - " + this.classificacao.getClassificacao();
	}
	
	

}

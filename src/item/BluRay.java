package item;

public abstract class BluRay extends Item {

	private int duracao;
	private Classificacao classificacao;

	public BluRay(String nomeItem, double preco, int duracao, String classificacao) {
		super(nomeItem, preco);
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
		this.classificacao = Classificacao.valueOf(classificacao);
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.duracao + " - " + this.classificacao.getClassificacao();
	}
	
	
}

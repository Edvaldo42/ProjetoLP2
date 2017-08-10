package item;

public class Filme extends BluRay {
	
	private Genero genero;
	private int anoLancamento;
	
	public Filme(String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		super(nomeItem, preco, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.anoLancamento = anoLancamento;
		}


	public String getGenero() {
		return genero.getGenero();
	}

	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero);
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	@Override
	public String toString() {
		return "FILME: " + super.toString() + ", " + this.genero.getGenero() + ", " + this.anoLancamento;
	}	
}

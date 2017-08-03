package item;

public class Filme extends BluRay {
	
	private Genero genero;
	private int anoLancamento;
	
	public Filme(String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		super(nomeItem, preco, duracao, classificacao);

		validaGenero(genero);
		if (anoLancamento < 0) {
			throw new IllegalArgumentException("Ano de lancamento nao pode ser menor que 0");
		}
		
		this.genero = Genero.valueOf(genero);
		this.anoLancamento = anoLancamento;
		}


	public String getGenero() {
		return genero.getGenero();
	}

	public void setGenero(String genero) {
		this.genero = Genero.valueOf(genero.toUpperCase());
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	private void validaGenero(String genero) {
		if (genero == null || genero.trim().equals("")) {
			throw new IllegalArgumentException("Genero nao pode ser nulo ou vazio");
		}
		try {
			Genero.valueOf(genero.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Genero invalido");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.genero.getGenero() + " - " + this.anoLancamento;
	}	
}

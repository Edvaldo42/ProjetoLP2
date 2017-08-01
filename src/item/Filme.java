package item;

import java.time.*;

public class Filme extends BluRay {
	
	private Genero genero;
	private String lancamento;
	
	public Filme(String nomeDoItem, double valor, int duracao, String classificacao, String genero, String lancamento) {
		super(nomeDoItem, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		if (genero == null || genero.trim().equals("")) {
			throw new IllegalArgumentException("Genero nao pode ser nula ou vazia");
		}
		try {
			Genero.valueOf(genero);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Genero invalida");
		}
		this.genero = Genero.valueOf(genero);
		// fazer tratamento de lancamento
		this.lancamento = lancamento;
		}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.genero.getGenero() + " - " + this.lancamento;
	}	
}

package item;

import java.time.*;

public class Filme extends BluRay {
	
	private Genero genero;
	private int lancamento;
	
	public Filme(String nomeDoItem, double valor, int duracao, String classificacao, String genero, int lancamento) {
		super(nomeDoItem, valor, duracao, classificacao);

		if (genero == null || genero.trim().equals("")) {
			throw new IllegalArgumentException("Genero nao pode ser nula ou vazia");
		}
		try {
			Genero.valueOf(genero);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Genero invalida");
		}
		this.genero = Genero.valueOf(genero);
		this.lancamento = lancamento;
		}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getLancamento() {
		return lancamento;
	}

	public void setLancamento(int lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.genero.getGenero() + " - " + this.lancamento;
	}	
}

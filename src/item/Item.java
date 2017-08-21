package item;

import java.util.Locale;

/**
 * 
 *
 */
public abstract class Item {

	private String nomeItem;
	private double preco;
	private boolean emprestado;
	private int quantidadeEmprestado;
	
	/**
	 * Construtor de Item
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 */
	public Item(String nomeItem, double preco) {
		this.nomeItem = nomeItem;
		this.preco = preco;
		this.emprestado = false;
		this.quantidadeEmprestado = 0;
	}
	
	/**
	 * adiciona uma vez emprestada a cada vez que o metodo eh chamado
	 */
	public void addVezEmprestada() {
		this.quantidadeEmprestado++;
	}
	
	/**
	 * 
	 * @return Quantas vezes o item foi emprestado
	 */
	public int getVezesEmprestado() {
		return this.quantidadeEmprestado;
	}
	
	/**
	 * Adiciona um BluRay
	 * @param duracao A duracao do BluRay
	 */
	public void adicionarBluRay(int duracao) {
	}
	
	/**
	 * 
	 * @return As pecas perdidas do jogo de tabuleiro
	 */
	public String getPecasPerdidas() {
		return null;
	}
	
	/**
	 * 
	 * @param nomeItem O nome do item
	 */
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	
	/**
	 * 
	 * @return O nome do item
	 */
	public String getNomeDoItem() {
		return nomeItem;
	}

	/**
	 * 
	 * @return O preco do item
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * 
	 * @param preco O preco do item
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * 
	 * @return true se esta emprestado e false caso contrario
	 */
	public boolean isEmprestado() {
		return emprestado;
	}

	/**
	 * 
	 * @param emprestado true se esta emprestado e false caso contrario
	 */
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	/**
	 * 
	 * @param valor A plataforma do jogo
	 */
	public void setPlataforma(String plataforma) {}
	
	/**
	 * 
	 */
	public String getPlataforma() {
		return null;
	}
	
	/**
	 * 
	 * @param duracao A duracao do BluRay
	 */
	public void setDuracao(int duracao) {}

	/**
	 * 
	 */
	public int getDuracao() {
		return -1;
	}
	
	/**
	 * 
	 * @param classificacao A classificacao etaria
	 */
	public void setClassificacao(String classificacao) {}
	
	/**
	 * 
	 */
	public String getClassificacao() {
		return null;
	}

	/**
	 * 
	 * @param valor O genero do BluRay
	 */
	public void setGenero(String genero) {}

	/**
	 * 
	 */
	public String getGenero() {
		return null;
	}
	
	/**
	 * 
	 * @param anoLancamento O ano de lancamento
	 */
	public void setAnoLancamento(int anoLancamento) {}
	
	/**
	 * 
	 */
	public int getAnoLancamento() {
		return -1;
	}
	
	/**
	 * 
	 * @param nomeArtista O nome do artista
	 */
	public void setNomeArtista(String nomeArtista) {}

	/**
	 * 
	 * @param nomeArtista O nome do artista
	 */
	public String getNomeArtista() {
		return null;
	}
	
	/**
	 * 
	 * @param numeroFaixas O numero de faixas
	 */
	public void setNumeroFaixas(int numeroFaixas) {}

	/**
	 * 
	 */
	public int getNumeroFaixas() {
		return -1;
	}

	/**
	 * 
	 * @param descricao A descricao do BluRay
	 */
	public void setDescricao(String descricao) {}
	
	/**
	 * 
	 */
	public String getDescricao() {
		return null;
	}
	
	/**
	 * 
	 * @param temporada A temporada da serie
	 */
	public void setTemporada(int temporada) {}

	/**
	 * 
	 */
	public int getTemporada() {
		return -1;
	}
	/**
	 * Retorna uma representacao textual do Item
	 */
	@Override
	public String toString() {
		String valorRequerido;
		if (this.preco % 1 == 0) {
			valorRequerido = String.format(Locale.ENGLISH, "%.1f", this.preco);
		} else {
			valorRequerido = String.format(Locale.ENGLISH, "%.2f", this.preco);
		}
		
		if (emprestado) {
			return this.nomeItem + ", R$ " + valorRequerido + ", " + "Emprestado";			
		}
			
		return this.nomeItem + ", R$ " + valorRequerido + ", " + "Nao emprestado";
	}

	/**
	 * HashCode do Item
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		return result;
	}

	/**
	 * Equals do Item
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		return true;
	}

}
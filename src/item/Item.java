package item;

import java.util.Locale;

import exceptionsItem.TemporadaMenorQue1Exception;

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
	 * Adiciona um BluRay
	 * 
	 * @param duracao A duracao do BluRay
	 */
	public void adicionarBluRay(int duracao) {
	}
	
	/**
	 * Retorna as percas perdidades de um jogo de tabuleiro
	 * 
	 * @return As pecas perdidas do jogo de tabuleiro
	 */
	public String getPecasPerdidas() {
		return null;
	}
	
	/**
	 * Adiciona uma vez emprestada a cada vez que o metodo eh chamado
	 */
	public void addVezEmprestada() {
		this.quantidadeEmprestado++;
	}
	
	/**
	 * Retorna quantas vezes o item foi emprestado
	 * 
	 * @return Quantas vezes o item foi emprestado
	 */
	public int getVezesEmprestado() {
		return this.quantidadeEmprestado;
	}
	
	/**
	 * Estabelece o nome do item
	 * 
	 * @param nomeItem O nome do item
	 */
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	
	/**
	 * Retorna o nome do item
	 * 
	 * @return O nome do item
	 */
	public String getNomeDoItem() {
		return nomeItem;
	}

	/**
	 * Retorna o preco do item
	 * 
	 * @return O preco do item
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Estabelece o preco do item
	 * 
	 * @param preco O preco do item
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Retorna se o item esta ou nao emprestado
	 * 
	 * @return true se esta emprestado e false caso contrario
	 */
	public boolean isEmprestado() {
		return emprestado;
	}

	/**
	 * Estabelece se um item esta ou nao emprestado
	 * 
	 * @param emprestado true se esta emprestado e false caso contrario
	 */
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	/**
	 * Estabelece a plataforma do jogo
	 * 
	 * @param valor A plataforma do jogo
	 */
	public void setPlataforma(String plataforma) {
	}
	
	/**
	 * Retorna a plataforma em um jogo eletronico
	 */
	public String getPlataforma() {
		return null;
	}
	
	/**
	 * Estabelece a duracao de um BluRay
	 * 
	 * @param duracao A duracao do BluRay
	 */
	public void setDuracao(int duracao) {}

	/**
	 * Retorna a duracao de um item
	 */
	public int getDuracao() {
		return -1;
	}
	
	/**
	 * Estabelece a classificacao etaria
	 * 
	 * @param classificacao A classificacao etaria
	 */
	public void setClassificacao(String classificacao) {}
	
	/**
	 * Retorna a classificacao
	 */
	public String getClassificacao() {
		return null;
	}

	/**
	 * Estabelece o genero
	 * @param valor O genero do BluRay
	 */
	public void setGenero(String genero) {}

	/**
	 * Retorna o genero
	 */
	public String getGenero() {
		return null;
	}
	
	/**
	 * Estabece o ano de lancamento
	 * @param anoLancamento O ano de lancamento
	 */
	public void setAnoLancamento(int anoLancamento) {}
	
	/**
	 * Retorna o ano de lancamento
	 */
	public int getAnoLancamento() {
		return -1;
	}
	
	/**
	 * Estabelece o nome do artista
	 * 
	 * @param nomeArtista O nome do artista
	 */
	public void setNomeArtista(String nomeArtista) {}

	/**
	 * Retorna o nome do artista
	 * 
	 * @param nomeArtista O nome do artista
	 */
	public String getNomeArtista() {
		return null;
	}
	
	/**
	 * Estabelece o numero de faixas
	 * 
	 * @param numeroFaixas O numero de faixas
	 */
	public void setNumeroFaixas(int numeroFaixas) {}

	/**
	 * Retorna o numero de faixas
	 */
	public int getNumeroFaixas() {
		return -1;
	}

	/**
	 * Estabelece a descricao do BluRay
	 *
	 * @param descricao a descricao do BluRay
	 */
	public void setDescricao(String descricao) {}
	
	/**
	 * Retorna a descricao
	 */
	public String getDescricao() {
		return null;
	}
	
	/**
	 * Estabelece a temporada da serie
	 * 
	 * @param temporada a temporada da serie
	 * @throws TemporadaMenorQue1Exception 
	 */
	public void setTemporada(int temporada) throws TemporadaMenorQue1Exception {}

	/**
	 * Retorna a temporada da serie
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
	 * Equals de Item
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
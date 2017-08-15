package item;

import java.util.Locale;

public abstract class Item {

	private String nomeItem;
	private double preco;
	private boolean emprestado;
	private int quantidadeEmprestado;
	
	public Item(String nomeItem, double preco) {
		this.nomeItem = nomeItem;
		this.preco = preco;
		emprestado = false;
		quantidadeEmprestado = 0;
	}

	public String getPecasPerdidas() {
		return "Esse item nao possui pecas";
	}

	public void adicionarBluRay(int duracao) {
	}

	public void setPlataforma(String valor) {
	}

	public void setDuracao(int duracao) {
	}

	public void setClassificacao(String classificacao) {
	}

	public void setGenero(String valor) {
	}

	public void setAnoLancamento(int parseInt) {
	}

	public void setNomeArtista(String valor) {
	}

	public void setNumeroFaixas(int parseInt) {
	}

	public void setDescricao(String descricao) {
	}

	public void setTemporada(int parseInt) {
	}

	public String getNomeDoItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	@Override
	public String toString() {
		if (this.preco % 1 == 0) {
			String valorRequerido = String.format(Locale.ENGLISH, "%.1f", this.preco);
			if (emprestado) {
				return this.nomeItem + ", R$ " + valorRequerido + ", " + "Emprestado";			
			}
			
			return this.nomeItem + ", R$ " + valorRequerido + ", " + "Nao emprestado";
		} else {
			String valorRequerido = String.format(Locale.ENGLISH, "%.2f", this.preco);
			if (emprestado) {
				return this.nomeItem + ", R$ " + valorRequerido + ", " + "Emprestado";			
			}
			
			return this.nomeItem + ", R$ " + valorRequerido + ", " + "Nao emprestado";
		}
}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		return result;
	}

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

	public void addVezEmprestada() {
		this.quantidadeEmprestado++;
	}

}
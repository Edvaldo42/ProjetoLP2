package item;

import java.text.DecimalFormat;
import java.util.Locale;

public abstract class Item {
	
	private String nomeItem;
	private double preco;
	private boolean emprestado;

	public Item(String nomeItem, double preco) {
		
		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new IllegalArgumentException("Nome do item nao pode ser nulo ou vazio");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		
		this.nomeItem = nomeItem;
		this.preco = preco;
		emprestado = false;
	}
	
	public String getPecasPerdidas() {
		return "Esse item nao possui pecas";
	}

	
	public void adicionarBluRay(int duracao) {
	}

	public void setClassificacao(String classificacao) {
	}
		
	public void setDuracao(int duracao) {
	}

	public void setGenero(String valor) {
	}
	
	public void setAnoLancamento(int parseInt) {
	}
		
	public void setNomeArtista(String valor) {
	}
	
	public void setNumeroFaixas(int parseInt) {
	}
	
	public void setTemporada(int parseInt) {
	}
	
	public void setPlataforma(String valor) {
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
		//DecimalFormat formato = new DecimalFormat("#.##"); 
		//this.preco = Double.valueOf(formato.format(preco));
		String valorRequerido = String.format(Locale.ENGLISH, "%.2f", this.preco);
		if (emprestado) {
			return this.nomeItem + ", R$ " + valorRequerido + ", " + "Emprestado";			
		}
		else {
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
	
}
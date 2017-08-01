package item;

public abstract class Item {
	
	private String nomeDoItem;
	private double valor;
	private boolean emprestado;

	public Item(String nomeDoItem, double valor) {
		
		if (nomeDoItem == null || nomeDoItem.trim().equals("")) {
			throw new IllegalArgumentException("Nome do item nao pode ser nulo ou vazio");
		}
		if (valor < 0) {
			throw new IllegalArgumentException("Valor do item nao pode ser menor que zero");
		}
		
		this.nomeDoItem = nomeDoItem;
		this.valor = valor;
		emprestado = false;
	}
	
	public abstract void adicionarPecaPerdida(String nomePeca);

	public String getNomeDoItem() {
		return nomeDoItem;
	}

	public void setNomeDoItem(String nomeDoItem) {
		this.nomeDoItem = nomeDoItem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	@Override
	public String toString() {
		String valorRequerido = String.format("%.2f", this.valor);
		if (emprestado) {
			return this.nomeDoItem + " - R$" + valorRequerido + " - " + "Emprestado(Sim)";			
		}
		else {
			return this.nomeDoItem + " - R$" + valorRequerido + " - " + "Emprestado(Nao)";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDoItem == null) ? 0 : nomeDoItem.hashCode());
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
		if (nomeDoItem == null) {
			if (other.nomeDoItem != null)
				return false;
		} else if (!nomeDoItem.equals(other.nomeDoItem))
			return false;
		return true;
	}
	
	
}
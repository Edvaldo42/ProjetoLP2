package item;

public class JogoEletronico extends Item {
	
	private Plataforma plataforma;
	
	public JogoEletronico(String nomeDoItem, double valor, String plataforma) {
		super(nomeDoItem, valor);
		
		validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}

	private void validaPlataforma(String plataforma) {
		if (plataforma == null || plataforma.trim().equals("")) {
			throw new IllegalArgumentException("Plataforma nao pode ser nula ou vazia");
		}
	
		try {
			Plataforma.valueOf(plataforma);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Plataforma invalida");
		}
	}

	public String getPlataforma() {
		return plataforma.getPlataforma();
	}

	public void setPlataforma(String plataforma) {
		validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}

	@Override
	public String toString() {
		return super.toString() + " - " +  plataforma.getPlataforma();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (plataforma != other.plataforma)
			return false;
		return true;
	}	
	
}

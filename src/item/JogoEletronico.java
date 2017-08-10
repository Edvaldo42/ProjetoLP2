package item;

public class JogoEletronico extends Item {
	
	private Plataforma plataforma;
	
	public JogoEletronico(String nomeItem, double preco, String plataforma) {
		super(nomeItem, preco);
		this.plataforma = Plataforma.valueOf(plataforma);		
	}

	public String getPlataforma() {
		return plataforma.getPlataforma();
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = Plataforma.valueOf(plataforma);
	}
	
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + super.toString() + ", " +  plataforma.getPlataforma();
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

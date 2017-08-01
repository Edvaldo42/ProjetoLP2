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
			throw new IllegalArgumentException("Genero nao pode ser nula ou vazia");
		}
	
		try {
			Genero.valueOf(plataforma);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Genero invalida");
		}
	}

	public String getPlataforma() {
		return plataforma.getPlataforma();
	}

	public void setPlataforma(String plataforma) {
		validaPlataforma(plataforma);
		this.plataforma = Plataforma.valueOf(plataforma);
	}	
}

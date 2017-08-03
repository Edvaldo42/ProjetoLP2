package item;

public class Show extends BluRay {

	private String artista;
	private int numeroFaixas;	
	
	public Show(String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		super(nomeItem, preco, duracao, classificacao);
		
		if (numeroFaixas < 1) { 
			throw new IllegalArgumentException("Faixas nao podem ser menor do que 1");
		}
		if (artista == null || artista.trim().equals("")) {
			 throw new IllegalArgumentException("O nome do artista nao pode ser nulo ou vazio");
		}
		
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
	}

	public String getArtista() {
		return artista;
	}

	public void setNomeDoArtista(String artista) {
		if (artista == null && artista.trim().equals("")) {
			throw new IllegalArgumentException("O nome do artista nao pode ser nulo ou vazio");
		}
		this.artista = artista;
	}

	public int getFaixas() {
		return numeroFaixas;
	}

	public void setFaixas(int faixas) {
		if (numeroFaixas < 1) { 
			throw new IllegalArgumentException("Faixas nao podem ser menor do que 1");
		}
		this.numeroFaixas = faixas;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.artista + " - " + this.numeroFaixas;
	}
	
	

}

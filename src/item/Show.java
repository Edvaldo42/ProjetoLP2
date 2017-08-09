package item;

public class Show extends BluRay {

	private String artista;
	private int numeroFaixas;	
	
	public Show(String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		super(nomeItem, preco, duracao, classificacao);
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
	}

	public String getArtista() {
		return artista;
	}

	public void setNomeDoArtista(String artista) {
		this.artista = artista;
	}

	public int getFaixas() {
		return numeroFaixas;
	}

	public void setFaixas(int faixas) {
		this.numeroFaixas = faixas;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.artista + " - " + this.numeroFaixas;
	}
	
	

}

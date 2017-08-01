package item;

public class Show extends BluRay {

	private String nomeDoArtista;
	private int faixas;	
	
	public Show(String nomeDoItem, double valor, int duracao, String classificacao, int faixas, String nomeDoArtista) {
		super(nomeDoItem, valor, duracao, classificacao);
		
		if (faixas < 1) { 
			throw new IllegalArgumentException("Faixas nao podem ser menor do que 1");
		}
		if (nomeDoArtista == null || nomeDoArtista.trim().equals("")) {
			 throw new IllegalArgumentException("O nome do artista nao pode ser nulo ou vazio");
		}
		
		this.faixas = faixas;
		this.nomeDoArtista = nomeDoArtista;
	}

	public String getNomeDoArtista() {
		return nomeDoArtista;
	}

	public void setNomeDoArtista(String nomeDoArtista) {
		this.nomeDoArtista = nomeDoArtista;
	}

	public int getFaixas() {
		return faixas;
	}

	public void setFaixas(int faixas) {
		this.faixas = faixas;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + this.nomeDoArtista + " - " + this.faixas;
	}
	
	

}

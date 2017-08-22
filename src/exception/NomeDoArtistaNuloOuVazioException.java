package exception;

public class NomeDoArtistaNuloOuVazioException extends StringInvalidaException {

	public NomeDoArtistaNuloOuVazioException() {
		super("Nome do artista nao pode ser nulo ou vazio");
	}

	public NomeDoArtistaNuloOuVazioException(String msg) {
		super(msg + "Nome do artista nao pode ser nulo ou vazio");
	}
}

package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class NomeDoArtistaNuloOuVazioException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 875477225003358141L;

	public NomeDoArtistaNuloOuVazioException() {
		super("Nome do artista nao pode ser nulo ou vazio");
	}

	public NomeDoArtistaNuloOuVazioException(String msg) {
		super(msg + "Nome do artista nao pode ser nulo ou vazio");
	}
}

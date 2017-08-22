package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class NomeDaPecaNuloOuVazioException extends StringInvalidaException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7779649167577887883L;

	public NomeDaPecaNuloOuVazioException() {
		super("Nome da peca nao pode ser nulo ou vazio");
	}

	public NomeDaPecaNuloOuVazioException(String msg) {
		super(msg + "Nome da peca nao pode ser nulo ou vazio");
	}
}

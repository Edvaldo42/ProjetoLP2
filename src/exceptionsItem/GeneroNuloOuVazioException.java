package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class GeneroNuloOuVazioException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3700746558758278245L;

	public GeneroNuloOuVazioException() {
		super ("Genero nao pode ser nulo ou vazio");
	}
	
	public GeneroNuloOuVazioException(String msg) {
		super(msg + "Genero nao pode ser nulo ou vazio");
	}
}

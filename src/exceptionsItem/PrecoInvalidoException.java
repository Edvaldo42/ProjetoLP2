package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class PrecoInvalidoException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1509112816068526862L;

	public PrecoInvalidoException() {
		super("Preco invalido");
	}

	public PrecoInvalidoException(String msg) {
		super(msg + "Preco invalido");
	}
}

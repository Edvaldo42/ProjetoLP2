package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class TelefoneInvalidoException extends StringInvalidaException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3892446430631418791L;

	public TelefoneInvalidoException() {
		super("Telefone invalido");
	}

	public TelefoneInvalidoException(String msg) {
		super (msg + " telefone invalido");
	}
}

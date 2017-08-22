package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class NomeUsuarioException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8620649834535838082L;

	public NomeUsuarioException() {
		super("Usuario invalido");
	}
	
	public NomeUsuarioException(String msg) {
		super(msg + " Usuario invalido");
	}
}

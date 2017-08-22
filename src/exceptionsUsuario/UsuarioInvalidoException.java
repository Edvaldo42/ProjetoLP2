package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class UsuarioInvalidoException extends StringInvalidaException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7429270976466577046L;

	public UsuarioInvalidoException() {
		super("Usuario invalido");
	}
	
	public UsuarioInvalidoException(String msg) {
		super(msg + " Usuario invalido");
	}
}

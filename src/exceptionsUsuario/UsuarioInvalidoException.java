package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class UsuarioInvalidoException extends StringInvalidaException {


	public UsuarioInvalidoException() {
		super("Usuario invalido");
	}
	
	public UsuarioInvalidoException(String msg) {
		super(msg + " Usuario invalido");
	}
}
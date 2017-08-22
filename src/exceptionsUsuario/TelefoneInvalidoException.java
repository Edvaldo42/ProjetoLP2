package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class TelefoneInvalidoException extends StringInvalidaException{

	public TelefoneInvalidoException() {
		super("Telefone invalido");
	}

	public TelefoneInvalidoException(String msg) {
		super (msg + " telefone invalido");
	}
}

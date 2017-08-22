package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class EmailInvalidoException extends StringInvalidaException {

	public EmailInvalidoException() {
		super("Email invalido");
	}
	
	public EmailInvalidoException(String msg){
		super(msg + " Email invalido");
	}

}
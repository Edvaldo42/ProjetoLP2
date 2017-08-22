package exceptionsUsuario;

import exceptionsComplementares.StringInvalidaException;

public class EmailInvalidoException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1624031190449538352L;

	public EmailInvalidoException() {
		super("Email invalido");
	}
	
	public EmailInvalidoException(String msg){
		super(msg + " Email invalido");
	}

}

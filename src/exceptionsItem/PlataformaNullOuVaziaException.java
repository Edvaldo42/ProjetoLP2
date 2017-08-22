package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class PlataformaNullOuVaziaException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5233074890634024867L;

	public PlataformaNullOuVaziaException() {
		super("Plataforma nao pode ser nula ou vazia");
	}

	public PlataformaNullOuVaziaException(String msg) {
		super(msg + "Plataforma nao pode ser nula ou vazia");
	}
}

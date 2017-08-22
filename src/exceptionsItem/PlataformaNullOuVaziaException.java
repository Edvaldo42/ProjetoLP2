package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class PlataformaNullOuVaziaException extends StringInvalidaException {

	public PlataformaNullOuVaziaException() {
		super("Plataforma nao pode ser nula ou vazia");
	}

	public PlataformaNullOuVaziaException(String msg) {
		super(msg + "Plataforma nao pode ser nula ou vazia");
	}
}

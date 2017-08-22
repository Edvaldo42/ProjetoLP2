package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class PrecoInvalidoException extends StringInvalidaException {

	public PrecoInvalidoException() {
		super("Preco invalido");
	}

	public PrecoInvalidoException(String msg) {
		super(msg + "Preco invalido");
	}
}

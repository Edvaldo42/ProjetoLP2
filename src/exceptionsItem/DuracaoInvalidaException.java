package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class DuracaoInvalidaException extends StringInvalidaException {

	public DuracaoInvalidaException() {
		super ("Duracao nao pode ser menor do que 0");
	}
	
	public DuracaoInvalidaException(String msg) {
		super(msg + "Duracao nao pode ser menor do que 0");
	}
}

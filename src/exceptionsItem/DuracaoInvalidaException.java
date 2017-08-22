package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class DuracaoInvalidaException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8956541893479975123L;

	public DuracaoInvalidaException() {
		super ("Duracao nao pode ser menor do que 0");
	}
	
	public DuracaoInvalidaException(String msg) {
		super(msg + "Duracao nao pode ser menor do que 0");
	}
}

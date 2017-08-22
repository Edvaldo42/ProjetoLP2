package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class ClassificacaoInvalidaException extends StringInvalidaException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3193100587750610976L;

	public ClassificacaoInvalidaException() {
		super ("Classificacao invalida");
	}
	
	public ClassificacaoInvalidaException(String msg) {
		super(msg + "Classificacao invalida");
	}
}

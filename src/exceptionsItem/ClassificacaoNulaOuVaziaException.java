package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class ClassificacaoNulaOuVaziaException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4672277351361247073L;

	public ClassificacaoNulaOuVaziaException() {
		super ("Classificacao nao pode ser nula ou vazia");
	}
	
	public ClassificacaoNulaOuVaziaException(String msg) {
		super(msg + "Classificacao nao pode ser nula ou vazia");
	}
}

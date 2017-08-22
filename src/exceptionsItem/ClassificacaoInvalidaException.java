package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class ClassificacaoInvalidaException extends StringInvalidaException{

	public ClassificacaoInvalidaException() {
		super ("Classificacao invalida");
	}
	
	public ClassificacaoInvalidaException(String msg) {
		super(msg + "Classificacao invalida");
	}
}

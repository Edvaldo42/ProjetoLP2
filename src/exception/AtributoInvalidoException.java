package exception;

public class AtributoInvalidoException extends StringInvalidaException {

	public AtributoInvalidoException() {
		super();
	}
	
	public AtributoInvalidoException(String msg) {
		super(msg + "Atributo invalido");
	}
	
}

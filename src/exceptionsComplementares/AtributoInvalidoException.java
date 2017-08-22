package exceptionsComplementares;

public class AtributoInvalidoException extends StringInvalidaException {

	public AtributoInvalidoException() {
		super("Atributo invalido");
	}
	
	public AtributoInvalidoException(String msg) {
		super(msg + "Atributo invalido");
	}
	
}

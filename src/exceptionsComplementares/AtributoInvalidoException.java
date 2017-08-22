package exceptionsComplementares;

public class AtributoInvalidoException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3319928298248760423L;

	public AtributoInvalidoException() {
		super("Atributo invalido");
	}
	
	public AtributoInvalidoException(String msg) {
		super(msg + "Atributo invalido");
	}
	
}

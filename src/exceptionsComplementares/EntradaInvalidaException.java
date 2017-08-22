package exceptionsComplementares;

public abstract class EntradaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4337092917885942281L;

	public EntradaInvalidaException(String msg) {
		super(msg);
	}

	public EntradaInvalidaException() {
		super();
	}
}

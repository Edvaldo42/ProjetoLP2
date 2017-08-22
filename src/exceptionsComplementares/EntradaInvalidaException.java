package exceptionsComplementares;

public abstract class EntradaInvalidaException extends Exception {

	public EntradaInvalidaException(String msg) {
		super(msg);
	}

	public EntradaInvalidaException() {
		super();
	}
}

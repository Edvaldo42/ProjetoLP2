package exception;

public abstract class StringInvalidaException extends EntradaInvalidaException {

	public StringInvalidaException() {
		super ();
	}
	
	public StringInvalidaException(String msg) {
		super(msg);
	}
}

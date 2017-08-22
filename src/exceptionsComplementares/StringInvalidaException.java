package exceptionsComplementares;

public class StringInvalidaException extends EntradaInvalidaException {

	public StringInvalidaException() {
		super ();
	}
	
	public StringInvalidaException(String msg) {
		super(msg);
	}
}

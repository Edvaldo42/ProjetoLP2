package exceptionsComplementares;

public class StringInvalidaException extends EntradaInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2212132082989413526L;

	public StringInvalidaException() {
		super ();
	}
	
	public StringInvalidaException(String msg) {
		super(msg);
	}
}

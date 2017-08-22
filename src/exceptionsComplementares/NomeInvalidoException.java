package exceptionsComplementares;

public class NomeInvalidoException extends StringInvalidaException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4056211022440500270L;

	public NomeInvalidoException() {
		super ("Nome invalido");
	}
	
	public NomeInvalidoException(String msg) {
		super(msg + "Nome invalido");
	}
}

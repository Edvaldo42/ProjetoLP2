package exception;

public class NomeInvalidoException extends StringInvalidaException {

	
	public NomeInvalidoException() {
		super ("Nome invalido");
	}
	
	public NomeInvalidoException(String msg) {
		super(msg + "Nome invalido");
	}
}

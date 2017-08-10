package exception;

public class NomeUsuarioException extends StringInvalidaException {

	public NomeUsuarioException() {
		super("Usuario invalido");
	}
	
	public NomeUsuarioException(String msg) {
		super(msg + " Usuario invalido");
	}
}

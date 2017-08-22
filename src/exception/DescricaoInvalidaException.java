package exception;

public class DescricaoInvalidaException extends StringInvalidaException {
	
	public DescricaoInvalidaException() {
		super ("Descricao nao pode ser nula ou vazia");
	}
	
	public DescricaoInvalidaException(String msg) {
		super(msg + "Descricao nao pode ser nula ou vazia");
	}
}

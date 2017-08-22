package exception;

public class NomeDaPecaNuloOuVazioException extends StringInvalidaException {
	public NomeDaPecaNuloOuVazioException() {
		super("Nome da peca nao pode ser nulo ou vazio");
	}

	public NomeDaPecaNuloOuVazioException(String msg) {
		super(msg + "Nome da peca nao pode ser nulo ou vazio");
	}
}

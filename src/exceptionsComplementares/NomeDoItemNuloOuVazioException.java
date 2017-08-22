package exceptionsComplementares;

public class NomeDoItemNuloOuVazioException extends StringInvalidaException {

	public NomeDoItemNuloOuVazioException() {
		super("Nome do item nao pode ser nulo ou vazio");
	}
	
	public NomeDoItemNuloOuVazioException(String msg) {
		super(msg + "Nome do item nao pode ser nulo ou vazio");
	}
}

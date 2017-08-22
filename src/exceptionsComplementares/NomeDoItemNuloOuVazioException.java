package exceptionsComplementares;

public class NomeDoItemNuloOuVazioException extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779443761090437382L;

	public NomeDoItemNuloOuVazioException() {
		super("Nome do item nao pode ser nulo ou vazio");
	}
	
	public NomeDoItemNuloOuVazioException(String msg) {
		super(msg + "Nome do item nao pode ser nulo ou vazio");
	}
}

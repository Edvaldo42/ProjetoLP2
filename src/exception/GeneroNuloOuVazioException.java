package exception;

public class GeneroNuloOuVazioException extends StringInvalidaException {

	public GeneroNuloOuVazioException() {
		super ("Genero nao pode ser nulo ou vazio");
	}
	
	public GeneroNuloOuVazioException(String msg) {
		super(msg + "Genero nao pode ser nulo ou vazio");
	}
}

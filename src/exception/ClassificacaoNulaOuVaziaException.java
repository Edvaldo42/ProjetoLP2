package exception;

public class ClassificacaoNulaOuVaziaException extends StringInvalidaException {

	public ClassificacaoNulaOuVaziaException() {
		super ("Classificacao nao pode ser nula ou vazia");
	}
	
	public ClassificacaoNulaOuVaziaException(String msg) {
		super(msg + "Classificacao nao pode ser nula ou vazia");
	}
}

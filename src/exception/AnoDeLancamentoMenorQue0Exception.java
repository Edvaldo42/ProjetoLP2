package exception;

public class AnoDeLancamentoMenorQue0Exception extends StringInvalidaException {

	public AnoDeLancamentoMenorQue0Exception() {
		super("Ano de lancamento nao pode ser menor do que 0");
	}

	public AnoDeLancamentoMenorQue0Exception(String msg) {
		super(msg + "Ano de lancamento nao pode ser menor do que 0");
	}
}

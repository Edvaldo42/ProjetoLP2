package exception;

public class NumeroDeFaixasMenorQue1Exception extends StringInvalidaException {

	public NumeroDeFaixasMenorQue1Exception() {
		super("Numero de faixas nao pode ser menor do que 0");
	}

	public NumeroDeFaixasMenorQue1Exception(String msg) {
		super(msg + "Numero de faixas nao pode ser menor do que 0");
	}
}

package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class NumeroDeFaixasMenorQue0Exception extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 714182667547263545L;

	public NumeroDeFaixasMenorQue0Exception() {
		super("Numero de faixas nao pode ser menor do que 0");
	}

	public NumeroDeFaixasMenorQue0Exception(String msg) {
		super(msg + "Numero de faixas nao pode ser menor do que 0");
	}
}

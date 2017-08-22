package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class AnoDeLancamentoMenorQue0Exception extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3739563718528233169L;

	public AnoDeLancamentoMenorQue0Exception() {
		super("Ano de lancamento nao pode ser menor do que 0");
	}

	public AnoDeLancamentoMenorQue0Exception(String msg) {
		super(msg + "Ano de lancamento nao pode ser menor do que 0");
	}
}

package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class DescricaoInvalidaException extends StringInvalidaException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5604251977506795216L;

	public DescricaoInvalidaException() {
		super ("Descricao nao pode ser nula ou vazia");
	}
	
	public DescricaoInvalidaException(String msg) {
		super(msg + "Descricao nao pode ser nula ou vazia");
	}
}

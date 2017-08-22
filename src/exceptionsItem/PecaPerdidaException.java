package exceptionsItem;

public class PecaPerdidaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4735821983892062330L;

	public PecaPerdidaException() {
		super ("Erro ao adicionar peca perdida");
	}

}

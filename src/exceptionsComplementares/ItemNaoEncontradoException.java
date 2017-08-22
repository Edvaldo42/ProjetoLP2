package exceptionsComplementares;

public class ItemNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -422978418698605511L;

	public ItemNaoEncontradoException() {
		super ("Item nao encontrado");
	}
}

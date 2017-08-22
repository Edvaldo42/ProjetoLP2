package exceptionsItem;

public class PecaJaPerdidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7198347397259783933L;

	public PecaJaPerdidaException() {
		super ("Peca perdida ja registrada");
	}
}

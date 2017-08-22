package exceptionsItem;

public class SerieNaoValidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1342057095768043720L;

	public SerieNaoValidaException(){
		super("Esse item nao e uma serie");
	}
}

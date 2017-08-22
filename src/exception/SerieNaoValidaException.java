package exception;

public class SerieNaoValidaException extends Exception {

	public SerieNaoValidaException(){
		super("Esse item nao e uma serie");
	}
}

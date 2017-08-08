package FacadeEMain;

public class MinhaException extends Exception {
	
	public MinhaException() {
		super("Nome invalido");
	}
	
	public MinhaException(String msg) {
		super(msg + "Nome invalido");
	}
	

}

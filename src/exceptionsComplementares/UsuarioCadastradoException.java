package exceptionsComplementares;

public class UsuarioCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3020152269141290249L;

	public UsuarioCadastradoException(){
		super("Usuario ja cadastrado");
	}
}

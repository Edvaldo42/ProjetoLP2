package exceptionsComplementares;

public class ItemCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5446541440247218348L;

	public ItemCadastradoException(){
		super("Item ja cadastrado");
	}
}

package exceptionsComplementares;

public class ItemEmprestadoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7638559367896741438L;

	public ItemEmprestadoException(){
		super ("Item emprestado no momento");
	}

}

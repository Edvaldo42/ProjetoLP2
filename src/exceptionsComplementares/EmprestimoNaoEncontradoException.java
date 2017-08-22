package exceptionsComplementares;

public class EmprestimoNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7773091522923345158L;

	public EmprestimoNaoEncontradoException(){
		super ("Emprestimo nao encontrado");
	}
}

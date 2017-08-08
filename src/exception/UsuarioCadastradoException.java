package exception;

public class UsuarioCadastradoException extends Exception {

	public UsuarioCadastradoException(){
		super("Usuario ja cadastrado");
	}
}

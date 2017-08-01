package usuario;

import java.util.HashSet;
import java.util.Set;

public class ControllerUsuario {
	
	
	public ControllerUsuario() {
		 }

	public static Usuario cadastraUsuario(String nome, String telefone, String email) {
		Usuario usuario = new Usuario(nome, telefone, email);
		return usuario;			
	}
	
	
}
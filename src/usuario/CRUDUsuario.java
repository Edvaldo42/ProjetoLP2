package usuario;

import java.util.Set;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsUsuario.UsuarioInvalidoException;

public class CRUDUsuario {

	public static void cadastraUsuario(String nome, String telefone, String email, Set<Usuario> usuarios)
			throws UsuarioCadastradoException, StringInvalidaException {

		Usuario user = new Usuario(nome, telefone, email);
		if (!usuarios.add(user)) {
			throw new UsuarioCadastradoException();
		}
	}

	public static void removerUsuario(String nome, String telefone, Set<Usuario> usuarios) throws UsuarioInvalidoException {
		Usuario user = buscaUsuario(nome, telefone, usuarios);
		usuarios.remove(user);
	}

	public static void atualizarUsuario(String nome, String telefone, String atributo, String valor, Set<Usuario> usuarios) throws UsuarioInvalidoException, AtributoInvalidoException {
		
		Usuario user = buscaUsuario(nome, telefone, usuarios);

		if (atributo.trim().equalsIgnoreCase("nome")) {
			user.setNome(valor);
		} 
		else if (atributo.trim().equalsIgnoreCase("telefone")) {
			user.setTelefone(valor);
		}
		else if (atributo.trim().equalsIgnoreCase("email")) {
			user.setEmail(valor);
		} 
		else {
			throw new AtributoInvalidoException();
		}
	}

	public static String getInfoUsuario(String nome, String telefone, String atributo, Set<Usuario> usuarios) throws StringInvalidaException {
		Usuario user = buscaUsuario(nome, telefone, usuarios);

		String info = "";
		
		if (atributo.trim().equalsIgnoreCase("nome")) {
			info = user.getNome();
		} 
		else if (atributo.trim().equalsIgnoreCase("telefone")) {
			info = user.getTelefone();
		} 
		else if (atributo.trim().equalsIgnoreCase("email")) {
			info = user.getEmail();
		} 
		else if (atributo.trim().equalsIgnoreCase("reputacao")) {
			info += user.getReputacao();
		}
		else if (atributo.trim().equalsIgnoreCase("cartao")) {
			info += user.getCartao();
		}
		else {
			throw new AtributoInvalidoException();
		}

		return info;
	}

	public static Usuario buscaUsuario(String nome, String telefone, Set<Usuario> usuarios) throws UsuarioInvalidoException {
		for (Usuario usuario: usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
				return usuario;
			}
		}
		
		throw new UsuarioInvalidoException();
	}
	
}

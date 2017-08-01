package FacadeEMain;

import java.util.HashSet;
import java.util.Set;

import usuario.ControllerUsuario;
import usuario.Usuario;

public class Sistema {

	Set<Usuario> usuarios = new HashSet<Usuario>();

	public void cadastrarUsuario(String nome, String telefone, String email) {
		usuarios.add(ControllerUsuario.cadastraUsuario(nome, telefone, email));
	}

	public void removerUsuario(String nome, String telefone) {
		Usuario user = buscaUsuario(nome, telefone);
		usuarios.remove(user);

	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Usuario user = buscaUsuario(nome, telefone);
		if (atributo.trim().equalsIgnoreCase("nome")) {
			if (validaUsarioNome(valor, telefone)) {
				user.setNome(valor);
			}

		}
		if (atributo.trim().equalsIgnoreCase("telefone")) {
			if (validaUsuarioTelefone(nome, valor)) {
				user.setTelefone(valor);
			}
		}
		if (atributo.trim().equalsIgnoreCase("email")) {
			user.setEmail(valor);
		}
	}

	private Usuario buscaUsuario(String nome, String telefone) {
		Usuario user = null;
		for (Usuario usuario : usuarios) {
			if (usuarios.equals(nome) && usuarios.equals(telefone)) {
				user = usuario;
			}
		}
		return user;

	}

	private boolean validaUsarioNome(String valor, String telefone) {
		Usuario user = buscaUsuario(valor, telefone);
		if (user != null) {
			return false;
		}
		return true;
	}

	private boolean validaUsuarioTelefone(String nome, String valor) {
		Usuario user = buscaUsuario(nome, valor);
		if (user != null) {
			return false;
		}
		return true;
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario user = buscaUsuario(nome, telefone);
		String info = null;
		if (atributo.trim().equalsIgnoreCase("nome")) {
			info = user.getNome();
		}
		if (atributo.trim().equalsIgnoreCase("telefone")) {
			info =  user.getTelefone();
		}
		if (atributo.trim().equalsIgnoreCase("email")) {
			info = user.getEmail();
		}
		return info;
	}
}

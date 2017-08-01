package FacadeEMain;

import java.util.HashSet;
import java.util.Set;

import usuario.ControllerUsuario;
import usuario.Usuario;

public class Sistema {

	Set<Usuario> usuarios;
	

	public Sistema() {
		this.usuarios = new HashSet<Usuario>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		if (buscaUsuario(nome, telefone) != null) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		} else {
			usuarios.add(ControllerUsuario.cadastraUsuario(nome, telefone, email));
		}

	}

	public void removerUsuario(String nome, String telefone) {
		Usuario user = buscaUsuario(nome, telefone);
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		} else {
			usuarios.remove(user);
		}
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Usuario user = buscaUsuario(nome, telefone);
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		} else {
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
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario user = buscaUsuario(nome, telefone);
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		} else {
			String info = null;
			if (atributo.trim().equalsIgnoreCase("nome")) {
				info = user.getNome();
			}
			if (atributo.trim().equalsIgnoreCase("telefone")) {
				info = user.getTelefone();
			}
			if (atributo.trim().equalsIgnoreCase("email")) {
				info = user.getEmail();
			}

			return info;
		}
	}

	private Usuario buscaUsuario(String nome, String telefone) {
		Usuario user = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nome) && usuario.getTelefone().equals(telefone)) {
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
	
	public 

}

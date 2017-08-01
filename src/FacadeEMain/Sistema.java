package FacadeEMain;

import java.util.Map.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import item.Item;
import usuario.ControllerUsuario;
import usuario.Usuario;

public class Sistema {

	Set<Usuario> usuarios;
	Map<Usuario, Item> itensCadastrados;
	

	public Sistema() {
		this.usuarios = new HashSet<>();
		this.itensCadastrados = new HashMap<>();
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
	
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco, plataforma);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int nomeroFaixas, String artista, String classificacao) {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, nomeroFaixas, artista, classificacao);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		sistema.removerItem(nome, telefone, nomeItem);
	}
	
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, double preco) {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, preco);
	}
	
	public String getInfoItem(String nome, String telefone, String atributo, double preco) {
		return sistema.getInfoItem(nome, telefone, atributo, preco);
	}
	
	public String pesquisarDetalhesItem(String nomeItem, String nomeDono, String telefoneDono) {
		Usuario user = buscaUsuario(nomeDono, telefoneDono);
		
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		return user.detalhesItem(nomeItem);
	}
}
	
	
	

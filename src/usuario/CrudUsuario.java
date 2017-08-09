package usuario;

import java.util.HashSet;
import java.util.Set;

import FacadeEMain.Validacoes;
import item.Item;

public class CrudUsuario {
	
	private Set<Usuario> usuarios;
	
	public CrudUsuario() {
		usuarios = new HashSet<>();
	}

	public void cadastraUsuario(String nome, String telefone, String email) {
		Validacoes.validaCadastrarUsuario(nome, telefone, email);

		if (buscaUsuario(nome, telefone) != null) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		Usuario usuario = new Usuario(nome, telefone, email);
		usuarios.add(usuario);			
	}
	
	public void removerUsuario(String nome, String telefone) {
		Usuario user = buscaUsuario(nome, telefone);
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		usuarios.remove(user);
	}
	
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Validacoes.validaAtualizarUsuario(atributo, valor);

		Usuario user = buscaUsuario(nome, telefone);
		
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		if (atributo.trim().equalsIgnoreCase("nome")) {
			user.setNome(valor);
		}
		else if (atributo.trim().equalsIgnoreCase("telefone")) {
			user.setTelefone(valor);
		}
		
		else if (atributo.trim().equalsIgnoreCase("email")) {
			user.setEmail(valor);
		}
	}
	
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario user = buscaUsuario(nome, telefone);
		
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		}
		String info = null;
		if (atributo.trim().equalsIgnoreCase("nome")) {
			info = user.getNome();
		}
		else if (atributo.trim().equalsIgnoreCase("telefone")) {
			info = user.getTelefone();
		}
		else if (atributo.trim().equalsIgnoreCase("email")) {
			info = user.getEmail();
		}
		else {
			throw new IllegalArgumentException("Atributo invalido");
		}

		return info;
	}
	
	public void cadastrarEletronico(String nome, String telefone, Item item ) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de jogo eletronico");
		}         
		
		usuario.cadastraEletronico(item);
	}
	
	public void cadastrarJogoTabuleiro(String nome, String telefone,Item item) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		usuario.cadastraJogoTabuleiro(item);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro ao adicionar peca perdida");
		}

		usuario.adicionarPecaPerdida(nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, Item item) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de filme");
		}
		
		usuario.cadastrarBluRayFilme(item);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone,Item item) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de Show");
		}

		usuario.cadastrarBluRayShow(item);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, Item item) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de serie");
		}
		
		usuario.cadastrarBluRaySerie(item);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de serie");
		}
		
		usuario.adicionarBluRay(nomeBlurayTemporada, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de serie");
		}
		
		usuario.removerItem(nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de serie");
		}
		
		Validacoes.validaAtualizarItem(atributo, valor);
		
		usuario.atualizarItem(nomeItem, atributo, valor);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de serie");
		}
		
		return usuario.getInfoItem(nomeItem, atributo);
	}
	
	public String pesquisarDetalhesItem(String nomeItem, String nomeDono, String telefoneDono) {
		Usuario user = buscaUsuario(nomeDono, telefoneDono);
		
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		return user.detalhesItem(nomeItem);
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
	
}
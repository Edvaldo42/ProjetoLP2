package usuario;

import java.util.HashSet;
import java.util.Set;

import item.Item;

public class CrudUsuario {
	
	private Set<Usuario> usuarios;
	
	public CrudUsuario() {
		usuarios = new HashSet<>();
	}

	public void cadastraUsuario(String nome, String telefone, String email) {
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
		else {
			throw new IllegalArgumentException("Atributo invalido");
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
	
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		usuario.cadastraJogoTabuleiro(nomeItem, preco);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro ao adicionar peca perdida");
		}

		usuario.adicionarPecaPerdida(nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de filme");
		}
		
		usuario.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de Show");
		}

		usuario.cadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de BluRay de serie");
		}
		
		usuario.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
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
package FacadeEMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import comparator.ordemAlfabetica;
import comparator.valor;
import item.Item;
import usuario.ControllerUsuario;
import usuario.Usuario;

public class Sistema {

	private Set<Usuario> usuarios;
	private Map<Usuario, Item> itensCadastrados; // n esta sendo usado p nd
	Comparator tipoDeOrdenacao = null;
	
	public Sistema() {
		this.usuarios = new HashSet<>();
		this.itensCadastrados = new HashMap<>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		if (buscaUsuario(nome, telefone) != null) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
		
		usuarios.add(ControllerUsuario.cadastraUsuario(nome, telefone, email));
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

		return info;
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
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro no cadastro de jogo eletronico");
		}
		
		usuario.cadastraEletronico(nomeItem, preco, plataforma);
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

	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Erro ao adicionar BluRay");
		}
		usuario.adicionarBluRay(nomeBlurayTemporada, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Usuario invalido");
		}

		usuario.removerItem(nomeItem);
	}
	
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		usuario.atualizarItem(nomeItem, atributo, valor);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		String info = "";
		Usuario usuario = buscaUsuario(nome, telefone);
		
		if (usuario != null) {
			info = usuario.getInfoItem(nomeItem, atributo);
		}
		
		return info;
	}
	
	public String pesquisarDetalhesItem(String nomeItem, String nomeDono, String telefoneDono) {
		Usuario user = buscaUsuario(nomeDono, telefoneDono);
		
		if (user == null) {
			throw new NullPointerException("Usuario invalido");
		}
		
		return user.detalhesItem(nomeItem);
	}

	public String listarItensOrdenadosPorNome() {
		tipoDeOrdenacao = new ordemAlfabetica();
		List<Item> itens = getItens();
		Collections.sort(itens, tipoDeOrdenacao);
		String retorno = "";
		for (Item item: itens) {
			retorno += item.toString() + "|";
		}
		
		return retorno;
	}
	
	public List<Item> getItens() {
		List<Item> retornoItens = new ArrayList<>();
		for (Usuario usuario: usuarios) {
			List<Item> itens = new ArrayList<>();
			itens = usuario.getItens();
			for (Item item: itens) {
				retornoItens.add(item);
			}
		}
		
		return retornoItens;
	}
	
	public String listarItensOrdenadosPorValor() {
		tipoDeOrdenacao = new valor();
		List<Item> itens = getItens();
		Collections.sort(itens, tipoDeOrdenacao);
		String retorno = "";
		for (Item item: itens) {
			retorno += item.toString() + "|";
		}
		
		return retorno;
	}
}
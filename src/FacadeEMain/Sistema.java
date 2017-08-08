package FacadeEMain;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import comparator.ordemAlfabetica;
import item.CrudItem;
import item.Item;
import usuario.CrudUsuario;
import usuario.Usuario;

public class Sistema {
	
	private CrudUsuario crudUsuario;
	private CrudItem crudItem;	
	private Set<Usuario> usuarios;
	private Map<Usuario, Item> itensCadastrados;
	private Comparator tipoDeOrdenacao = null;
	
	public Sistema() {
		this.crudUsuario = new CrudUsuario();
		this.crudItem = new CrudItem();
		this.usuarios = new HashSet<>();
		this.itensCadastrados = new HashMap<>();
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Validacoes.validaCadastrarUsuario(nome, telefone, email);
		crudUsuario.cadastraUsuario(nome, telefone, email);
	}

	public void removerUsuario(String nome, String telefone) {
		crudUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Validacoes.validaAtualizarUsuario(atributo, valor);
		crudUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}
		
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return crudUsuario.getInfoUsuario(nome, telefone, atributo);
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

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Validacoes.validaCadastrarEletronico(nomeItem, preco, plataforma);
		crudUsuario.cadastrarEletronico(nome, telefone, crudItem.criaEletronico(nomeItem, preco, plataforma));
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
		return "";
	}

	public String listarItensOrdenadosPorValor() {
		return null;
	}
}
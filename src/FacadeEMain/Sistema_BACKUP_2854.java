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

import usuario.ControllerUsuario;
import usuario.Usuario;

public class Sistema {

	private CrudUsuario crudUsuario;
	private CrudItem crudItem;
	private Set<Usuario> usuarios;
	private Map<Usuario, Item> itensCadastrados; // n esta sendo usado p nd
	Comparator tipoDeOrdenacao = null;
	
	private Map<Usuario, Item> itensCadastrados;
	Comparator tipoDeOrdenacao = null;
	
	public Sistema() {
		this.crudUsuario = new CrudUsuario();
		this.crudItem = new CrudItem();
		this.usuarios = new HashSet<>();
		this.itensCadastrados = new HashMap<>();

	}

	public void cadastrarUsuario(String nome, String telefone, String email)
			throws UsuarioCadastradoException, StringInvalidaException {
		crudUsuario.cadastraUsuario(nome, telefone, email);
	}

	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		crudUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws StringInvalidaException {
		crudUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		return crudUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws UsuarioInvalidoException {
		Validacoes.validaCadastrarEletronico(nomeItem, preco, plataforma.toUpperCase());
		crudUsuario.cadastrarEletronico(nome, telefone,
				crudItem.criaEletronico(nomeItem, preco, plataforma.toUpperCase()));
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco)
			throws UsuarioInvalidoException {
		Validacoes.validaCadastrarJogoTabuleiro(nomeItem, preco);
		crudUsuario.cadastrarJogoTabuleiro(nome, telefone, crudItem.criaJogoTabuleiro(nomeItem, preco));
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		Validacoes.validaAdicionarPecaPerdida(nomeItem, nomePeca);
		crudUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Validacoes.validaCadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		crudUsuario.cadastrarBluRayFilme(nome, telefone,
				crudItem.criaBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento));
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		crudUsuario.cadastrarBluRayShow(nome, telefone,
				crudItem.criaBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao));
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		crudUsuario.cadastrarBluRaySerie(nome, telefone,
				crudItem.criaBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada));
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Validacoes.validaAdicionarBluRay(nomeBlurayTemporada, duracao);
		crudUsuario.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		crudUsuario.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		crudUsuario.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		String info = "";

		info = crudUsuario.getInfoItem(nome, telefone, nomeItem, atributo);

		return info;
	}

	public String pesquisarDetalhesItem(String nomeDono, String telefoneDono, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		String info = "";

		info = crudUsuario.pesquisarDetalhesItem(nomeDono, telefoneDono, nomeItem);

		return info;
	}

	public String listarItensOrdenadosPorNome() {
		tipoDeOrdenacao = new ordemAlfabetica();
		List<Item> itens = getItens();
		Collections.sort(itens, tipoDeOrdenacao);
		String retorno = "";
		for (Item item : itens) {
			retorno += item.toString() + "|";
		}

		return retorno;
	}

	private List<Item> getItens() {
		List<Item> retornoItens = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			List<Item> itens = new ArrayList<>();
			itens = usuario.getItens();
			for (Item item : itens) {
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

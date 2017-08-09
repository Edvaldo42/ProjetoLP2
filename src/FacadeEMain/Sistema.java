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
		crudUsuario.cadastraUsuario(nome, telefone, email);
	}

	public void removerUsuario(String nome, String telefone) {
		crudUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		crudUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}
		
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return crudUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Validacoes.validaCadastrarEletronico(nomeItem, preco, plataforma.toUpperCase());
		crudUsuario.cadastrarEletronico(nome, telefone, crudItem.criaEletronico(nomeItem, preco, plataforma.toUpperCase()));
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Validacoes.validaCadastrarJogoTabuleiro(nomeItem, preco);
		crudUsuario.cadastrarJogoTabuleiro(nome, telefone, crudItem.criaJogoTabuleiro(nomeItem, preco));
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Validacoes.validaAdicionarPecaPerdida(nomeItem, nomePeca);
		crudUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		Validacoes.validaCadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		crudUsuario.cadastrarBluRayFilme(nome, telefone, crudItem.criaBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento));
	}
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		Validacoes.validaCadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		crudUsuario.cadastrarBluRayShow(nomeItem, telefone, crudItem.criaBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao));
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		Validacoes.validaCadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		crudUsuario.cadastrarBluRaySerie(nomeItem, telefone, crudItem.criaBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada));
	}

	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) {
		Validacoes.validaAdicionarBluRay(nomeBlurayTemporada, duracao);
		crudUsuario.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		crudUsuario.removerItem(nome, telefone, nomeItem);
	}
	
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		crudUsuario.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		String info = "";
		
		info = crudUsuario.getInfoItem(nome, telefone, nomeItem, atributo);
		
		return info;
	}
	
	public String pesquisarDetalhesItem(String nomeItem, String nomeDono, String telefoneDono) {
		String info = "";
		
		info = crudUsuario.pesquisarDetalhesItem(nomeItem, nomeDono, telefoneDono);
		
		return info;
	}
	
	public String listarItensOrdenadosPorNome() {
		tipoDeOrdenacao = new ordemAlfabetica();
		return "";
	}

	public String listarItensOrdenadosPorValor() {
		return null;
	}
}
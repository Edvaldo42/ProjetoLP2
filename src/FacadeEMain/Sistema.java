package FacadeEMain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import emprestimo.Emprestimo;
import exception.ItemNaoEncontradoException;
import exception.StringInvalidaException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import item.CrudItem;
import usuario.CrudUsuario;

public class Sistema {

	private CrudUsuario crudUsuario;
	private CrudItem crudItem;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	

	public Sistema() {
		this.crudUsuario = new CrudUsuario();
		this.crudItem = new CrudItem();

	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param email
	 * @throws UsuarioCadastradoException
	 * @throws StringInvalidaException
	 */

	public void cadastrarUsuario(String nome, String telefone, String email)
			throws UsuarioCadastradoException, StringInvalidaException {
		crudUsuario.cadastraUsuario(nome, telefone, email);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @throws UsuarioInvalidoException
	 */

	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		crudUsuario.removerUsuario(nome, telefone);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @param valor
	 * @throws StringInvalidaException
	 */

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws StringInvalidaException {
		crudUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @return
	 * @throws StringInvalidaException
	 */

	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		return crudUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param plataforma
	 * @throws UsuarioInvalidoException
	 */

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws UsuarioInvalidoException {
		Validacoes.validaCadastrarEletronico(nomeItem, preco, plataforma.toUpperCase());
		crudUsuario.cadastrarEletronico(nome, telefone,
				crudItem.criaEletronico(nomeItem, preco, plataforma.toUpperCase()));
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @throws UsuarioInvalidoException
	 */

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco)
			throws UsuarioInvalidoException {
		Validacoes.validaCadastrarJogoTabuleiro(nomeItem, preco);
		crudUsuario.cadastrarJogoTabuleiro(nome, telefone, crudItem.criaJogoTabuleiro(nomeItem, preco));
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param nomePeca
	 * @throws Exception
	 */

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		Validacoes.validaAdicionarPecaPerdida(nomeItem, nomePeca);
		crudUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param genero
	 * @param classificacao
	 * @param anoLancamento
	 */

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Validacoes.validaCadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		crudUsuario.cadastrarBluRayFilme(nome, telefone,
				crudItem.criaBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento));
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param numeroFaixas
	 * @param artista
	 * @param classificacao
	 * @throws UsuarioInvalidoException
	 */

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		crudUsuario.cadastrarBluRayShow(nome, telefone,
				crudItem.criaBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao));
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param descricao
	 * @param duracao
	 * @param classificacao
	 * @param genero
	 * @param temporada
	 * @throws UsuarioInvalidoException
	 */

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		crudUsuario.cadastrarBluRaySerie(nome, telefone,
				crudItem.criaBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada));
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeBlurayTemporada
	 * @param duracao
	 * @throws UsuarioInvalidoException
	 * @throws ItemNaoEncontradoException
	 */

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Validacoes.validaAdicionarBluRay(nomeBlurayTemporada, duracao);
		crudUsuario.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @throws UsuarioInvalidoException
	 * @throws ItemNaoEncontradoException
	 */

	public void removerItem(String nome, String telefone, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		crudUsuario.removerItem(nome, telefone, nomeItem);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 * @throws UsuarioInvalidoException
	 * @throws ItemNaoEncontradoException
	 */

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		crudUsuario.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param atributo
	 * @return
	 * @throws UsuarioInvalidoException
	 * @throws ItemNaoEncontradoException
	 */

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		String info = "";

		info = crudUsuario.getInfoItem(nome, telefone, nomeItem, atributo);

		return info;
	}

	/**
	 * 
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeItem
	 * @return
	 * @throws UsuarioInvalidoException
	 * @throws ItemNaoEncontradoException
	 */

	public String pesquisarDetalhesItem(String nomeDono, String telefoneDono, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		String info = "";

		info = crudUsuario.pesquisarDetalhesItem(nomeDono, telefoneDono, nomeItem);

		return info;
	}

	/**
	 * 
	 * @return
	 */

	public String listarItensOrdenadosPorNome() {
		return crudUsuario.listarItensOrdenadosPorNome();
	}

	/**
	 * 
	 * @return
	 */

	public String listarItensOrdenadosPorValor() {
		return crudUsuario.listarItensOrdenadosPorValor();
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ItemNaoEncontradoException, UsuarioInvalidoException {
	    Emprestimo emprestimo =  new Emprestimo(crudUsuario, nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
	    		nomeItem, dataEmprestimo, periodo);
		crudUsuario.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente,
				telefoneRequerente, emprestimo);
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		
	
	}
	
	
	
	
	
	
	
}
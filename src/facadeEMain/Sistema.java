package facadeEMain;

//import java.time.format.DateTimeFormatter;

import emprestimo.Emprestimo;
import exception.ItemNaoEncontradoException;
import exception.StringInvalidaException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import item.CRUDItem;
import usuario.ControllerUsuario;

/**
 * 
 *
 */
public class Sistema {

	private ControllerUsuario controllerUsuario;
	private CRUDItem crudItem;
	//private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/**
	 * Construtor do Sistema
	 */
	public Sistema() {
		this.controllerUsuario = new ControllerUsuario();
		this.crudItem = new CRUDItem();
	}

	/** Envia para o ControllerUsuario as informacoes de um usuario que devera ser cadastrado no sistema 
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param email O email do usuario
	 * @throws UsuarioCadastradoException Caso o usuario ja esteja cadastrado
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 */
	public void cadastrarUsuario(String nome, String telefone, String email)
			throws UsuarioCadastradoException, StringInvalidaException {
		controllerUsuario.cadastraUsuario(nome, telefone, email);
	}

	/** Remove um usuario do Sistema

	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		controllerUsuario.removerUsuario(nome, telefone);
	}

	/** Atualiza um usuario no Sistema
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param atributo O atributo que sera mudado
	 * @param valor O novo valor do atributo
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws StringInvalidaException {
		controllerUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}

	/**
	 * Exibe as informações do usuario solicitado
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param atributo O atributo que sera mudado
	 * @param ordenaPorValor O novo valor do atributo
	 * @return Informacoes do usuario no formato:
	 * "nome, email, telefone"
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		return controllerUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * Cadastra um jogo eletronico
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @param plataforma A plataforma em que o jogo esta
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws UsuarioCadastradoException Caso o usuario nao esteja cadastrado
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws UsuarioInvalidoException {
		Validacoes.validaCadastrarEletronico(nomeItem, preco, plataforma.toUpperCase());
		controllerUsuario.cadastrarItem(nome, telefone,
				crudItem.criaEletronico(nomeItem, preco, plataforma.toUpperCase()));
	}

	/**
	 * Cadastra um jogo de tabuleiro
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco)
			throws UsuarioInvalidoException {
		Validacoes.validaCadastrarJogoTabuleiro(nomeItem, preco);
		controllerUsuario.cadastrarItem(nome, telefone, crudItem.criaJogoTabuleiro(nomeItem, preco));
	}

	/**
	 * Adiciona uma peca perdida a um jogo de tabuleiro
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param nomePeca O nome da peca
	 * @throws Exception Caso haja alguma excecao
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		Validacoes.validaAdicionarPecaPerdida(nomeItem, nomePeca);
		controllerUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * Cadastra o BluRay de um filme
	 * 
	 * @param nome O nome do dono do filme
	 * @param telefone O telefone do dono do filme
	 * @param nomeItem O nome do filme
	 * @param preco O preco do filme
	 * @param duracao A duracao do filme
	 * @param genero O genero do filme
	 * @param classificacao A classificacao etaria do filme
	 * @param anoLancamento O ano de lancamento do filme
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		controllerUsuario.cadastrarItem(nome, telefone,
				crudItem.criaBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento));
	}

	/**
	 * Cadastra um BluRay de show
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param duracao A duracao do item
	 * @param nomeroFaixas O numero de faixas do show
	 * @param artista O nome do artista
	 * @param classificacao A classificacao etaria do show
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		controllerUsuario.cadastrarItem(nome, telefone,
				crudItem.criaBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao));
	}

	/**
	 * Cadastra um BluRay de serie
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param descricao A descricao da serie
	 * @param duracao A duracao da temporada
	 * @param classificacao A classificacao etaria da serie
	 * @param genero O genero da serie
	 * @param temporada A temporada da serie
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws UsuarioInvalidoException {
		Validacoes.validaCadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		controllerUsuario.cadastrarItem(nome, telefone,
				crudItem.criaBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada));
	}

	/**
	 * Adiciona um BluRay de serie
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeBlurayTemporada O nome da temporada
	 * @param duracao A duracao da temporada
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Validacoes.validaAdicionarBluRay(nomeBlurayTemporada, duracao);
		controllerUsuario.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}

	/**
	 * Remove um item do sistema 
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 */
	public void removerItem(String nome, String telefone, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		controllerUsuario.removerItem(nome, telefone, nomeItem);
	}

	/**
	 * Atualiza o item de algum usuario
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @param atributo O atributo que sera mudado
	 * @param valor O novo valor do atributo
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		controllerUsuario.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	/**
	 * Exibe uma informacao do item
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @param atributo A informacao desejada
	 * @return A informacao pedida do item
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {

		return controllerUsuario.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	/**
	 * Exibe os detalhes de um item
	 * 
	 * @param nomeDono O nome do dono do item
	 * @param telefoneDono O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @return As informacoes do item desejado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 */
	public String pesquisarDetalhesItem(String nomeDono, String telefoneDono, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		String info = "";

		info = controllerUsuario.pesquisarDetalhesItem(nomeDono, telefoneDono, nomeItem);

		return info;
	}

	/**
	 * Lista todos os itens em ordem alfabetica
	 * 
	 * @return A lista ordenada dos itens
	 */
	public String listarItensOrdenadosPorNome() {
		return controllerUsuario.listarItensOrdenadosPorNome();
	}

	/**
	 * Lista todos os itens por ordem de valor
	 * 
	 * @return A lista ordenada dos itens
	 */
	public String listarItensOrdenadosPorValor() {
		return controllerUsuario.listarItensOrdenadosPorValor();
	}
	
	/**
	 * Registra o emprestimo de um item
	 * 
	 * @param nomeDono O nome do dono do item
	 * @param telefoneDono O telefone do dono do item
	 * @param nomeRequerente O nome do requerente
	 * @param telefoneRequerente O telefone do requerente
	 * @param nomeItem O nome do item
	 * @param dataEmprestimo A data em que o emprestimo foi realizado
	 * @param periodo O periodo que o item sera emprestado
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ItemNaoEncontradoException, UsuarioInvalidoException {
	    Emprestimo emprestimo =  new Emprestimo(controllerUsuario, nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
	    		nomeItem, dataEmprestimo, periodo);
		controllerUsuario.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente,
				telefoneRequerente, emprestimo);
	}

	/**
	 * Devolve um item emprestado para o dono
	 * 
	 * @param nomeDono O nome do dono do item
	 * @param telefoneDono O telefone do dono do item
	 * @param nomeRequerente O nome do requerente
	 * @param telefoneRequerente O telefone do requerente
	 * @param nomeItem O nome do item
	 * @param dataEmprestimo A data em que o emprestimo foi realizado
	 * @param dataDevolucao A data em que o item foi devolvido
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		
		controllerUsuario.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		
	}

	/**
	 * Lista os emprestimos do usuario que esta emprestando algo
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos itens que foram pegos emprestados pelo usuario
	 * @throws UsuarioInvalidoException 
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) throws UsuarioInvalidoException {
		return controllerUsuario.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}

	/**
	 * Lista os emprestimos do usuario que esta pegando algo emprestado
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos itens que foram pegos emprestados pelo usuario
	 * @throws UsuarioInvalidoException 
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) throws UsuarioInvalidoException {
		return controllerUsuario.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	/**
	 * Lista os usuarios que pegaram determinado item emprestado
	 * 
	 * @param nomeItem O nome do item
	 * @return A lista dos usuarios que pegaram o item emprestado
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return controllerUsuario.listarEmprestimosItem(nomeItem);
	}
	
	public String listarItensNaoEmprestados() {
		return controllerUsuario.listarItensNaoEmprestados();
	}

	public String listarItensEmprestados() {
		return controllerUsuario.listarItensEmprestados();
	}
	
	public String listarTop10Itens() {
		return controllerUsuario.listarTop10Itens();
	}
	
	public String listarCaloteiros() {
		return controllerUsuario.listarCaloteiros();
	}

	public String listarTop10MelhoresUsuarios() {
		return controllerUsuario.listarTop10MelhoresUsuarios();
	}
	
	public String listarTop10PioresUsuarios() {
		return controllerUsuario.listarTop10PioresUsuarios();
	}

}
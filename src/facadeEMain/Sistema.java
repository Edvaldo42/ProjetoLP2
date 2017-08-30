package facadeEMain;


import emprestimo.Emprestimo;
import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.EmprestimoNaoEncontradoException;
import exceptionsComplementares.ItemCadastradoException;
import exceptionsComplementares.ItemEmprestadoException;
import exceptionsComplementares.ItemNaoEncontradoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsComplementares.UsuarioCadastradoException;
import exceptionsItem.PecaJaRegistrada;
import exceptionsItem.SerieNaoValidaException;
import exceptionsUsuario.UsuarioInvalidoException;
import item.CRUDItem;
import usuario.ControllerUsuario;

/**
 * 
 *
 */
public class Sistema {

	private ControllerUsuario controllerUsuario;
	
	/**
	 * Construtor do Sistema
	 */
	public Sistema() {
		this.controllerUsuario = new ControllerUsuario();
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

	/**
	 *  Remove um usuario do Sistema
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		controllerUsuario.removerUsuario(nome, telefone);
	}

	/** 
	 * Atualiza um usuario no Sistema
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
	 * @throws ItemCadastradoException Caso o item ja tenha sido cadastrado
	 * @throws StringInvalidaException 
	 * @throws UsuarioCadastradoException Caso o usuario nao esteja cadastrado
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws ItemCadastradoException, StringInvalidaException {
		
		Validacoes.validaCadastrarEletronico(nomeItem, preco, plataforma.toUpperCase());
		controllerUsuario.cadastrarItem(nome, telefone,
				CRUDItem.criaEletronico(nomeItem, preco, plataforma.toUpperCase()));
	}

	/**
	 * Cadastra um jogo de tabuleiro
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @throws ItemCadastradoException Caso o jogo de tabuleiro ja esteja cadastrado
	 * @throws StringInvalidaException 
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco)
			throws ItemCadastradoException, StringInvalidaException {
		
		Validacoes.validaCadastrarJogoTabuleiro(nomeItem, preco);
		controllerUsuario.cadastrarItem(nome, telefone, CRUDItem.criaJogoTabuleiro(nomeItem, preco));
	}

	/**
	 * Adiciona uma peca perdida a um jogo de tabuleiro
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param nomePeca O nome da peca
	 * @throws PecaJaRegistrada Caso a peca perdida ja tenha sido adicionada
	 * @throws ItemNaoEncontradoException Caso o item nao tenha sido encontrado
	 * @throws StringInvalidaException 
	 * @throws NomeDaPecaNuloOuVazioException Caso o nome da peca seja nulo ou vazio
	 * @throws NomeDoItemNuloOuVazioException Caso o nome da peca seja nulo ou vazio
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws ItemNaoEncontradoException, PecaJaRegistrada, StringInvalidaException {
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
	 * @throws ItemCadastradoException Caso o filme ja esteja cadastrado
	 * @throws StringInvalidaException 
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) throws ItemCadastradoException, StringInvalidaException {
		Validacoes.validaCadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		controllerUsuario.cadastrarItem(nome, telefone,
				CRUDItem.criaBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento));
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
	 * @throws ItemCadastradoException Caso o BluRay do show ja tenha sido cadastrado
	 * @throws StringInvalidaException 
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) throws ItemCadastradoException, StringInvalidaException {
		
		Validacoes.validaCadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		controllerUsuario.cadastrarItem(nome, telefone,
				CRUDItem.criaBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao));
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
	 * @throws ItemCadastradoException Caso o BluRay da serie ja tenha sido cadastrado
	 * @throws StringInvalidaException 
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws ItemCadastradoException, StringInvalidaException {
		
		Validacoes.validaCadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		controllerUsuario.cadastrarItem(nome, telefone,
				CRUDItem.criaBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada));
	}

	/**
	 * Adiciona um BluRay de serie
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeBlurayTemporada O nome da temporada
	 * @param duracao A duracao da temporada
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * @throws NomeDoItemNuloOuVazioException Caso o nome do item seja nulo ou vazio
	 * @throws SerieNaoValidaException Caso o item nao seja uma serie
	 * @throws StringInvalidaException 
	 * @throws IllegalArgumentException 
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) throws ItemNaoEncontradoException, SerieNaoValidaException, IllegalArgumentException, StringInvalidaException {
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
	 * 
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * @throws StringInvalidaException 
	 * @throws IllegalArgumentException 
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws ItemNaoEncontradoException, IllegalArgumentException, StringInvalidaException {
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
	 * @throws AtributoInvalidoException 
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, AtributoInvalidoException {

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

		return controllerUsuario.pesquisarDetalhesItem(nomeDono, telefoneDono, nomeItem);
	}

	/**
	 * Lista todos os itens em ordem alfabetica
	 * 
	 * @return A lista ordenada dos itens pela ordem alfabetica
	 */
	public String listarItensOrdenadosPorNome() {
		return controllerUsuario.listarItensOrdenadosPorNome();
	}

	/**
	 * Lista todos os itens por ordem de valor
	 * 
	 * @return A lista ordenada dos itens pelo valor dos itens
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
	 * @throws ItemEmprestadoException Caso o item ja esteja emprestado
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ItemNaoEncontradoException, UsuarioInvalidoException, ItemEmprestadoException {
	  
		Emprestimo emprestimo =  new Emprestimo(controllerUsuario, nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		controllerUsuario.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, emprestimo);
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
	 * @throws EmprestimoNaoEncontradoException Caso o emprestimo nao esteja cadastrado
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws UsuarioInvalidoException, ItemNaoEncontradoException, EmprestimoNaoEncontradoException {
		
		controllerUsuario.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		
	}

	/**
	 * Lista os emprestimos do usuario que esta emprestando algo
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos itens que foram pegos emprestados pelo usuario
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
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
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
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
	
	/**
	 * Retorna uma lista os itens nao emprestados do sistema
	 * 
	 * @return Lista os itens nao emprestados do sistema
	 */
	public String listarItensNaoEmprestados() {
		return controllerUsuario.listarItensNaoEmprestados();
	}

	/**
	 * Retorna uma lista os itens emprestados do sistema
	 * 
	 * @return Lista os itens emprestados do sistema
	 */
	public String listarItensEmprestados() {
		return controllerUsuario.listarItensEmprestados();
	}
	
	/**
	 * Retorna uma lista com os 10 itens mais emprestados do sistema
	 * 
	 * @return Lista com os 10 itens mais emprestados do sistema
	 */
	public String listarTop10Itens() {
		return controllerUsuario.listarTop10Itens();
	}
	
	/**
	 * Retorna uma lista com os usuarios que possuem status de caloteiros
	 * 
	 * @return Lista com os usuarios que possuem status de caloteiros
	 */
	public String listarCaloteiros() {
		return controllerUsuario.listarCaloteiros();
	}
	
	/**
	 * Retorna uma lista com os 10 usuarios com a maior pontuacao
	 * 
	 * @return Lista com os 10 usuarios com a maior pontuacao
	 */
	public String listarTop10MelhoresUsuarios() {
		return controllerUsuario.listarTop10MelhoresUsuarios();
	}
	
	/**
	 * Retorna uma lista com os 10 usuarios com a menor pontuacao
	 * 
	 * @return Lista com os 10 usuarios com a menor pontuacao
	 */
	public String listarTop10PioresUsuarios() {
		return controllerUsuario.listarTop10PioresUsuarios();
	}

}
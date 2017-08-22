package facadeEMain;

import exception.AnoDeLancamentoMenorQue0Exception;
import exception.AtributoInvalidoException;
import exception.ClassificacaoInvalidaException;
import exception.ClassificacaoNulaOuVaziaException;
import exception.DescricaoInvalidaException;
import exception.DuracaoInvalidaException;
import exception.EmprestimoNaoEncontradoException;
import exception.GeneroNuloOuVazioException;
import exception.ItemCadastradaException;
import exception.ItemEmprestadoException;
import exception.NomeDoItemNuloOuVazioException;
import exception.ItemNaoEncontradoException;
import exception.NomeDoArtistaNuloOuVazioException;
import exception.NumeroDeFaixasMenorQue1Exception;
import exception.PlataformaNullOuVaziaException;
import exception.PrecoInvalidoException;
import exception.SerieNaoValidaException;
import exception.StringInvalidaException;
import exception.TemporadaMenorQue1Exception;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;

/**
 * Delega acoes para o sistema
 *
 */
public class Facade {
	
	private Sistema sistema = new Sistema();
	
	/**
	 * Inicia o Sistema
	 */
	public void iniciarSistema() {
		
	}
	
	/** Envia para o Sistema as informacoes de um usuario que devera ser cadastrado no sistema 
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param email O email do usuario
	 * @throws UsuarioCadastradoException Caso o usuario ja esteja cadastrado
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 * {@link Sistema#cadastrarUsuario(String, String, String)}
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) throws UsuarioCadastradoException, StringInvalidaException {
		sistema.cadastrarUsuario(nome, telefone, email);
	}
	
	/**
	 * Remove um usuario do Sistema
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * {@link Sistema#removerUsuario(String, String)}
	 */
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		sistema.removerUsuario(nome, telefone);
	}
	
	/**
	 * Atualiza um usuario no Sistema
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param atributo O atributo que sera mudado
	 * @param valor O novo valor do atributo
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 * {@link Sistema#atualizarUsuario(String, String, String, String)}
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) throws StringInvalidaException {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
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
	 * {@link Sistema#getInfoUsuario(String, String, String)}
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		return sistema.getInfoUsuario(nome, telefone, atributo);
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
	 * {@link Sistema#cadastrarEletronico(String, String, String, double, String)}
	 * @throws IllegalArgumentException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws PrecoInvalidoException 
	 * @throws PlataformaNullOuVaziaException 
	 * @throws ItemCadastradaException 
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) throws UsuarioCadastradoException, UsuarioInvalidoException, NomeDoItemNuloOuVazioException, IllegalArgumentException, PrecoInvalidoException, PlataformaNullOuVaziaException, ItemCadastradaException {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}
	
	/**
	 * Cadastra um jogo de tabuleiro
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * {@link Sistema#cadastrarJogoTabuleiro(String, String, String, double)}
	 * @throws IllegalArgumentException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws PrecoInvalidoException 
	 * @throws ItemCadastradaException 
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws UsuarioInvalidoException, NomeDoItemNuloOuVazioException, IllegalArgumentException, PrecoInvalidoException, ItemCadastradaException {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}
	
	/**
	 * Adiciona uma peca perdida a um jogo de tabuleiro
	 * 
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo
	 * @param nomePeca O nome da peca
	 * @throws Exception Caso haja alguma excecao
	 * {@link Sistema#adicionarPecaPerdida(String, String, String, String)}
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
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
	 * {@link Sistema#cadastrarBluRayFilme(String, String, String, double, int, String, String, int)}
	 * @throws IllegalArgumentException 
	 * @throws DuracaoInvalidaException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws PrecoInvalidoException 
	 * @throws ClassificacaoNulaOuVaziaException 
	 * @throws ClassificacaoInvalidaException 
	 * @throws GeneroNuloOuVazioException 
	 * @throws AnoDeLancamentoMenorQue0Exception 
	 * @throws ItemCadastradaException 
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) throws UsuarioInvalidoException, NomeDoItemNuloOuVazioException, DuracaoInvalidaException, IllegalArgumentException, PrecoInvalidoException, ClassificacaoNulaOuVaziaException, AnoDeLancamentoMenorQue0Exception, GeneroNuloOuVazioException, ClassificacaoInvalidaException, ItemCadastradaException {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
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
	 * {@link Sistema#cadastrarBluRayShow(String, String, String, double, int, int, String, String)}
	 * @throws IllegalArgumentException 
	 * @throws DuracaoInvalidaException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws PrecoInvalidoException 
	 * @throws ClassificacaoNulaOuVaziaException 
	 * @throws ClassificacaoInvalidaException 
	 * @throws NumeroDeFaixasMenorQue1Exception 
	 * @throws NomeDoArtistaNuloOuVazioException 
	 * @throws ItemCadastradaException 
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int nomeroFaixas, String artista, String classificacao) throws UsuarioInvalidoException, NomeDoItemNuloOuVazioException, DuracaoInvalidaException, IllegalArgumentException, PrecoInvalidoException, ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException, NomeDoArtistaNuloOuVazioException, NumeroDeFaixasMenorQue1Exception, ItemCadastradaException {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, nomeroFaixas, artista, classificacao);
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
	 * {@link Sistema#cadastrarBluRaySerie(String, String, String, double, String, int, String, String, int)}
	 * @throws IllegalArgumentException 
	 * @throws DuracaoInvalidaException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws PrecoInvalidoException 
	 * @throws DescricaoInvalidaException 
	 * @throws TemporadaMenorQue1Exception 
	 * @throws GeneroNuloOuVazioException 
	 * @throws ClassificacaoNulaOuVaziaException 
	 * @throws ClassificacaoInvalidaException 
	 * @throws ItemCadastradaException 
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) throws UsuarioInvalidoException, NomeDoItemNuloOuVazioException, DuracaoInvalidaException, IllegalArgumentException, PrecoInvalidoException, DescricaoInvalidaException, GeneroNuloOuVazioException, TemporadaMenorQue1Exception, ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException, ItemCadastradaException {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
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
	 * {@link Sistema#adicionarBluRay(String, String, String, int)}
	 * @throws IllegalArgumentException 
	 * @throws DuracaoInvalidaException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws SerieNaoValidaException 
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) throws UsuarioInvalidoException, ItemNaoEncontradoException, NomeDoItemNuloOuVazioException, DuracaoInvalidaException, IllegalArgumentException, SerieNaoValidaException{
		sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}
	
	/**
	 * Remove um item do sistema 
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * {@link Sistema#removerItem(String, String, String)}
	 */
	public void removerItem(String nome, String telefone, String nomeItem) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		sistema.removerItem(nome, telefone, nomeItem);
	}
	
	/**
	 * Atualiza o item de algum usuario
	 * 
	 * @param nome O nome do dono do item
	 * @param telefone O telefone do dono do item
	 * @param nomeItem O nome do item
	 * @param atributo O atributo que será mudado
	 * @param valor O novo valor do atributo
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * {@link Sistema#atualizarItem(String, String, String, String, String)}
	 * @throws IllegalArgumentException 
	 * @throws NomeDoItemNuloOuVazioException 
	 * @throws AtributoInvalidoException 
	 * @throws DescricaoInvalidaException 
	 * @throws TemporadaMenorQue1Exception 
	 * @throws NomeDoArtistaNuloOuVazioException 
	 * @throws AnoDeLancamentoMenorQue0Exception 
	 * @throws GeneroNuloOuVazioException 
	 * @throws ClassificacaoNulaOuVaziaException 
	 * @throws DuracaoInvalidaException 
	 * @throws PlataformaNullOuVaziaException 
	 * @throws PrecoInvalidoException 
	 * @throws NumeroDeFaixasMenorQue1Exception 
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) throws UsuarioInvalidoException, ItemNaoEncontradoException, NomeDoItemNuloOuVazioException, IllegalArgumentException, NumeroDeFaixasMenorQue1Exception, PrecoInvalidoException, PlataformaNullOuVaziaException, DuracaoInvalidaException, ClassificacaoNulaOuVaziaException, GeneroNuloOuVazioException, AnoDeLancamentoMenorQue0Exception, NomeDoArtistaNuloOuVazioException, TemporadaMenorQue1Exception, DescricaoInvalidaException, AtributoInvalidoException {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
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
	 * {@link Sistema#getInfoItem(String, String, String, String)}
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem,String atributo) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
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
	 * {@link Sistema#pesquisarDetalhesItem(String, String, String)}
	 */
	public String pesquisarDetalhesItem(String nomeDono, String telefoneDono, String nomeItem) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		return sistema.pesquisarDetalhesItem(nomeDono, telefoneDono, nomeItem);
	}
	
	/**
	 * Lista todos os itens em ordem alfabetica
	 * 
	 * @return A lista ordenada dos itens
	 * {@link Sistema#listarItensOrdenadosPorNome()}
	 */
	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}
	
	/**
	 * Lista todos os itens por ordem de valor
	 * 
	 * @return A lista ordenada dos itens
	 * {@link Sistema#listarItensOrdenadosPorValor()}
	 */
	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
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
	 * {@link Sistema#registrarEmprestimo(String, String, String, String, String, String, int)}
	 * @throws ItemEmprestadoException 
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ItemNaoEncontradoException, UsuarioInvalidoException, ItemEmprestadoException {
		sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
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
	 * {@link Sistema#devolverItem(String, String, String, String, String, String, String)}
	 * @throws EmprestimoNaoEncontradoException 
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) throws UsuarioInvalidoException, ItemNaoEncontradoException, EmprestimoNaoEncontradoException {
		sistema.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	
	/**
	 * Lista todos os emprestimos do usuario que esta emprestando um item
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos emprestimos do usuario que esta emprestando 
	 * {@link Sistema#listarEmprestimosUsuarioEmprestando(String, String)}
	 * @throws UsuarioInvalidoException 
	 */
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) throws UsuarioInvalidoException{
		return sistema.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}
	
	/**
	 * Lista todos os emprestimos do usuario que esta pegando algo emprestado
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos emprestimos do usuario que esta pegando um item emprestado 
	 * {@link Sistema#listarEmprestimosUsuarioPegandoEmprestado(String, String)}
	 * @throws UsuarioInvalidoException 
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) throws UsuarioInvalidoException{
		return sistema.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	/**
	 * Lista os emprestimos de determinado item
	 * 
	 * @param nomeItem O nome do item
	 * @return A lista dos usuarios que ja pegaram o item emprestado
	 * {@link Sistema#listarEmprestimosItem(String)}
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return sistema.listarEmprestimosItem(nomeItem);
	}
	
	public String listarItensNaoEmprestados() {
		return sistema.listarItensNaoEmprestados();
	}

	public String listarItensEmprestados() {
		return sistema.listarItensEmprestados();
	}

	public String listarTop10Itens() {
		return sistema.listarTop10Itens();
	}
	
	public String listarCaloteiros() {
		return sistema.listarCaloteiros();
	}
	
	public String listarTop10MelhoresUsuarios() {
		return sistema.listarTop10MelhoresUsuarios();
	}
	
	public String listarTop10PioresUsuarios() {
		return sistema.listarTop10PioresUsuarios();
	}
	
	/**
	 * Fecha o sistema
	 */
	public void fecharSistema() {
		
	}
}
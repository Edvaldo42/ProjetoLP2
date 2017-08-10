package FacadeEMain;

import exception.ItemNaoEncontradoException;
import exception.StringInvalidaException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;


public class Facade {
	
	private Sistema sistema = new Sistema();;
	
	public void iniciarSistema() {
		
	}
	
	/** Envia para o Sistema as informacoes sobre um usuario que devera ser cadastrado no sistema 
	 * 
	 * @param nome
	 * @param telefone
	 * @param email
	 * @throws UsuarioCadastradoException
	 * @throws StringInvalidaException
	 * {@link Sistema}
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) throws UsuarioCadastradoException, StringInvalidaException {
		sistema.cadastrarUsuario(nome, telefone, email);
	}
	
	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @throws UsuarioInvalidoException
	 */
	
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		sistema.removerUsuario(nome, telefone);
	}
	
	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param atributo
	 * @param valor
	 * @throws StringInvalidaException
	 */
	
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) throws StringInvalidaException {
		sistema.atualizarUsuario(nome, telefone, atributo, valor);
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
		return sistema.getInfoUsuario(nome, telefone, atributo);
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
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) throws UsuarioInvalidoException {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}
	
	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @throws UsuarioInvalidoException
	 */

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws UsuarioInvalidoException {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
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
		sistema.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
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
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		sistema.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}
	
	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param duracao
	 * @param nomeroFaixas
	 * @param artista
	 * @param classificacao
	 * @throws UsuarioInvalidoException
	 */
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int nomeroFaixas, String artista, String classificacao) throws UsuarioInvalidoException {
		sistema.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, nomeroFaixas, artista, classificacao);
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
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) throws UsuarioInvalidoException {
		sistema.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
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
	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao) throws UsuarioInvalidoException, ItemNaoEncontradoException{
		sistema.adicionarBluRay(nome, telefone, nomeBlurayTemporada, duracao);
	}
	
	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeItem
	 * @throws UsuarioInvalidoException
	 * @throws ItemNaoEncontradoException
	 */
	
	public void removerItem(String nome, String telefone, String nomeItem) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		sistema.removerItem(nome, telefone, nomeItem);
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
	
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
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
	
	public String getInfoItem(String nome, String telefone, String nomeItem,String atributo) throws UsuarioInvalidoException, ItemNaoEncontradoException {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
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
	public String pesquisarDetalhesItem(String nomeDono, String telefoneDono, String nomeItem) throws UsuarioInvalidoException, ItemNaoEncontradoException {
			return sistema.pesquisarDetalhesItem(nomeDono, telefoneDono, nomeItem);
		 	}
	
	/**
	 * 
	 * @return
	 */
	public String listarItensOrdenadosPorNome() {
		return sistema.listarItensOrdenadosPorNome();
	}
	
	/**
	 * 
	 * @return
	 */

	public String listarItensOrdenadosPorValor() {
		return sistema.listarItensOrdenadosPorValor();
	}
	

	
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ItemNaoEncontradoException, UsuarioInvalidoException {
		sistema.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
	}
	
//	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) {
//		return sistema.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
//	}
	
	public void fecharSistema() {
		
	}
	
	

}

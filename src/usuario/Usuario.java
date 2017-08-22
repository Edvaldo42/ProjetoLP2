package usuario;

import java.util.HashSet;
import java.util.Set;

import emprestimo.Emprestimo;
import exception.ItemCadastradoException;
import exception.ItemEmprestadoException;
import exception.ItemNaoEncontradoException;
import exception.PecaJaPerdidaException;
import exception.SerieNaoValidaException;
import exception.TemporadaMenorQue1Exception;
import item.CRUDItem;
import item.Item;
import item.JogoDeTabuleiro;
import item.Serie;

/**
 * 
 *
 */
public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private Set<Item> itens;
	private Set<Emprestimo> emprestimosDono;
	private Set<Emprestimo> emprestimosRequerente;
	private double reputacao;
	private Cartao cartao;  
	
	/**
	 * Construtor do Usuario
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param email O email do usuario
	 */
	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new HashSet<>();
		this.emprestimosDono = new HashSet<>();
		this.emprestimosRequerente = new HashSet<>();
		this.reputacao = 0;
		this.cartao = Cartao.FREE_RYDER;
	}
	
	/**
	 * Cadastra um Item
	 * 
	 * @param item Pode ser um jogo de tabuleiro, jogo eletronico, ou um BluRay
	 * @throws ItemCadastradoException 
	 */
	public void cadastrarItem(Item item) throws ItemCadastradoException {
		if (!itens.add(item)) {
			throw new ItemCadastradoException();
		}
		aumentaReputacao(item.getPreco(), 0.05);
	}
	
	/**
	 * Adiciona uma peca perdida á um jogo de tabuleiro
	 * 
	 * @param nomeItem Nome do jogo de tabuleiro
	 * @param nomePeca Nome da peca perdida
	 * @throws ItemNaoEncontradoException
	 * @throws PecaJaPerdidaException 
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) throws ItemNaoEncontradoException, PecaJaPerdidaException {
		Item itemBuscado = buscaItem(nomeItem);
		if (itemBuscado instanceof JogoDeTabuleiro) {
			((JogoDeTabuleiro) itemBuscado).adicionaPecaPerdida(nomePeca);
		}
	}
	
	/**
	 * Adiciona um EP ao box
	 * @param nomeBlurayTemporada Nome do BluRay Série
	 * @param duracao Duracao do EP
	 * @throws ItemNaoEncontradoException
	 * @throws SerieNaoValidaException 
	 */

	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) throws ItemNaoEncontradoException, SerieNaoValidaException {
		Item itemBuscado = buscaItem(nomeBlurayTemporada);
		
		if (itemBuscado instanceof Serie) {
			itemBuscado.adicionarBluRay(duracao);
		} else {
			throw new SerieNaoValidaException();
		}
	}
	
	/**
	 * Remove o item da lista de itens do usuario
	 * 
	 * @param nomeItem O nome do item a ser removido
	 * @throws ItemNaoEncontradoException
	 */

	public void removerItem(String nomeItem) throws ItemNaoEncontradoException {
		Item itemARemover = buscaItem(nomeItem);
		CRUDItem.removerItem(itemARemover, itens);
	}
	
	/**
	 * Atualiza as informacoes de um item
	 * 
	 * @param nomeItem O nome do Item
	 * @param atributo A informacao que se deseja atualizar
	 * @param valor A atualizacao da informacao desejada
	 * @throws ItemNaoEncontradoException
	 * @throws NumberFormatException 
	 * @throws TemporadaMenorQue1Exception 
	 */

	public void atualizarItem(String nomeItem, String atributo, String valor) throws ItemNaoEncontradoException, TemporadaMenorQue1Exception, NumberFormatException {
		Item item = buscaItem(nomeItem);
		CRUDItem.atualizarItem(item, atributo, valor);
	}
	
	/**
	 * Retorna todas as informacoes disponiveis de um item
	 * 
	 * @param nomeItem O nome do item do qual se deseja obter informacoes
	 * @return
	 * @throws ItemNaoEncontradoException
	 */

	public String detalhesItem(String nomeItem) throws ItemNaoEncontradoException {
			return buscaItem(nomeItem).toString();
	}
	
	/**
	 * Retorna uma informacao (passada como atributo) de um item
	 * 
	 * @param nomeItem O nome do Item
	 * @param atributo A informacao que esta sendo buscada
	 * @return
	 * @throws ItemNaoEncontradoException
	 */
	
	public String getInfoItem(String nomeItem, String atributo) throws ItemNaoEncontradoException {
		Item item = buscaItem(nomeItem);
		return CRUDItem.getInfoItem(item, atributo);
	}
	
	/**
	 * Retorna um item da lista de itens de um usuario
	 * 
	 * @param nomeItem O nome do item a ser buscado
	 * @return
	 * @throws ItemNaoEncontradoException
	 */

	public Item buscaItem(String nomeItem) throws ItemNaoEncontradoException {
		
		for (Item item : itens) {
			if (item.getNomeDoItem().equals(nomeItem)) {
				return item;
			}
		}
		throw new ItemNaoEncontradoException();
	}
		
	/**
	 * Empresta o item do dono para um requerente
	 * 
	 * @param item O nome do item a ser emprestado
	 * @return
	 * @throws ItemEmprestadoException 
	 */
	public void emprestaItem(String nomeItem) throws ItemNaoEncontradoException, ItemEmprestadoException {
		Item itemBuscado = buscaItem(nomeItem);
		if (itemBuscado.isEmprestado()) {
			throw new ItemEmprestadoException();
		}
		else {
			itemBuscado.setEmprestado(true);
			itemBuscado.addVezEmprestada();
			aumentaReputacao(itemBuscado.getPreco(), 0.1);
		}
	}
	
	/**
	 * Devolve o item do requerente para o dono
	 * 
	 * @param dono O dono do item
	 * @param nomeItem O nome do Item
	 * @param dataDevolucao A data de devolucao do emprestimo
	 * @throws ItemNaoEncontradoException
	 */
	public void devolveItem(Usuario dono, String nomeItem, String dataDevolucao) throws ItemNaoEncontradoException {
		Item itemBuscado = 	dono.buscaItem(nomeItem);	
		if (!itemBuscado.isEmprestado()) {
			return;
		}
		itemBuscado.setEmprestado(false);
		
	}
	
	/**
	 * Adiciona o emprestimo ao dono
	 * 
	 * @param emprestimo
	 */
	public void registrarEmprestimoDono(Emprestimo emprestimo) {
		emprestimosDono.add(emprestimo);
	}
	
	/**
	 * Adiciona o emprestimo ao requerente
	 * 
	 * @param emprestimo
	 */
	public void registrarEmprestimoRequerente(Emprestimo emprestimo) {
		emprestimosRequerente.add(emprestimo);
	}

	/**
	 * Aumenta a reputacao de quem merece recompensa
	 * 
	 * @param preco O preco do item
	 * @param taxa A taxa de aumento da reputacao
	 */
	public void aumentaReputacao(double preco, double taxa) {
		this.reputacao += preco * taxa;
		setCartao();
	}
	/**
	 * Diminui a reputacao de quem merece penalizaçao
	 * 
	 * @param preco O preco do item
	 * @param taxa A taxa de desconto da reputacao
	 */
	public void diminuiReputacao(double preco, double taxa) {
		this.reputacao += preco * taxa;
		setCartao();
	}
	
	/**
	 * Verifica se um emprestimo existe
	 * 
	 * @param nomeItem O nome do item
	 * @param data A data em que o item esta sendo pego emprestado
	 * @param requerente O nome do requerente
	 * @return O emprestimo, caso exista, null caso contrario
	 */
	public Emprestimo buscaEmprestimo(String nomeItem, String data, Usuario requerente){
		Emprestimo emprestimoBuscado = null;
		for (Emprestimo emprestimo : emprestimosDono) {
			String itemEmprestado = emprestimo.getItemEmprestado();
			String dataEmprestimo = emprestimo.getDataEmprestimo();
			Usuario requerenteEmprestimo = emprestimo.getRequerente();
			if (itemEmprestado.equals(nomeItem) && dataEmprestimo.equals(data) && requerenteEmprestimo.equals(requerente)){
				emprestimoBuscado = emprestimo; 
			}
		}
		return emprestimoBuscado;
	}
	
	/**
	 * Retorna o email do usuario
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o emial do usuario
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o nome do Usuario
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do usuario
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o telefone do usuario
	 * 
	 * @return
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Altera o telefone do usuario
	 * 
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Retorna a lista de itens do usuario
	 * 
	 * @return
	 */
	public Set<Item> getItens() {
		return this.itens;
		
	}
	
	/**
	 * Retorna os itens emprestados pelo usuario
	 * 
	 * @return
	 */
	public Set<Emprestimo> getItensEmprestadosDono() {
		return this.emprestimosDono;
	}

	/**
	 * Retorna a lista de emprestimos que o usuario fez
	 * 
	 * @return 
	 */
	public Set<Emprestimo> getEmprestimosDono() {
		
		return getItensEmprestadosDono();
	}
	
	/**
	 * Retorna a lista de emprestimos que o usuario participou como requerente
	 * 
	 * @return O conjunto de emprestimos que o requerente pegou por um tempo.
	 */
	public Set<Emprestimo> getEmprestimosRequerente() {
		return emprestimosRequerente;
	}
	
	/**
	 * Retorna a reputacao do usuario
	 * 
	 * @return
	 */
	public double getReputacao() {
		return this.reputacao;
	}
	
	/**
	 * Retorna o status do usuario
	 * 
	 * @return
	 */
	public String getCartao() {
		return this.cartao.getCartao();
	}
	
	/**
	 * Altera o status do usuario
	 */
	public void setCartao() {
		if (getReputacao() >= 0) {
			for (Item item : getItens()) {
				if (!item.isEmprestado()) {
					if (getReputacao() <= 100) {
						this.cartao = Cartao.NOOB; 
					}
					else if (getReputacao() > 100) {
						this.cartao = Cartao.BOM_AMIGO;
					}
					return;
				}
			}
			this.cartao = Cartao.FREE_RYDER;
		}
		else  {
			this.cartao = Cartao.CALOTEIRO;
		}
		
	}
	
	/**
	 * Retorna uma representacao textual de um toString
	 */
	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

	/**
	 * HashCode do Usuario
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Método equals do TT
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
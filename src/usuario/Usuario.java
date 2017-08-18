package usuario;

import java.util.HashSet;
import java.util.Set;

import emprestimo.Emprestimo;
import exception.ItemNaoEncontradoException;
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
	 * Cadastra um Jogo de Tabuleiro
	 * 
	 * @param item O jogo de tabuleiro
	 */

	public void cadastraJogoTabuleiro(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}
	
	/**
	 * 
	 * @param nomeItem
	 * @param nomePeca
	 * @throws ItemNaoEncontradoException
	 */

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) throws ItemNaoEncontradoException {
		Item itemBuscado = buscaItem(nomeItem);
		if (itemBuscado instanceof JogoDeTabuleiro) {
			((JogoDeTabuleiro) itemBuscado).adicionaPecaPerdida(nomePeca);
		}
	}
	
	/**
	 * 
	 * @param item
	 */

	public void cadastrarBluRayFilme(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}
	
	/**
	 * 
	 * @param item
	 */

	public void cadastrarBluRayShow(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}
	
	/**
	 * 
	 * @param item
	 */

	public void cadastrarBluRaySerie(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}
	
	/**
	 * 
	 * @param nomeBlurayTemporada
	 * @param duracao
	 * @throws ItemNaoEncontradoException
	 */

	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) throws ItemNaoEncontradoException {
		Item itemBuscado = buscaItem(nomeBlurayTemporada);
		
		if (itemBuscado instanceof Serie) {
			itemBuscado.adicionarBluRay(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao e uma serie");
		}
	}
	
	/**
	 * 
	 * @param nomeItem
	 * @throws ItemNaoEncontradoException
	 */

	public void removerItem(String nomeItem) throws ItemNaoEncontradoException {
		Item itemARemover = buscaItem(nomeItem);

		if (verificaItem(itemARemover)) {
			itens.remove(itemARemover);
		}
	}
	
	/**
	 * 
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 * @throws ItemNaoEncontradoException
	 */

	public void atualizarItem(String nomeItem, String atributo, String valor) throws ItemNaoEncontradoException {
		Item item = buscaItem(nomeItem);
		
		if (verificaItem(item)) {
			if (atributo.trim().equalsIgnoreCase("nome")) {
				item.setNomeItem(valor);
			}
			else if (atributo.trim().equalsIgnoreCase("preco")) {		
				item.setPreco(Double.parseDouble(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("classificacao")) {
				item.setClassificacao(valor);
			}
			else if (atributo.trim().equalsIgnoreCase("duracao")){
				item.setDuracao(Integer.parseInt(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("genero")) {
				item.setGenero(valor);
			}
			else if (atributo.trim().equalsIgnoreCase("anoLancamento")) {
				item.setAnoLancamento(Integer.parseInt(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("artista")) {
				item.setNomeArtista(valor);
			}
			else if (atributo.trim().equalsIgnoreCase("numeroFaixas")) {
				item.setNumeroFaixas(Integer.parseInt(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("temporada")) {
				item.setTemporada(Integer.parseInt(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("plataforma")) {
				item.setPlataforma(valor);
			}
		}
		else {
			throw new IllegalArgumentException("Item nao cadastrado");
		}
	}
	
	/**
	 * 
	 * @param nomeItem
	 * @return
	 * @throws ItemNaoEncontradoException
	 */

	public String detalhesItem(String nomeItem) throws ItemNaoEncontradoException {
			return buscaItem(nomeItem).toString();
	}
	
	/**
	 * 
	 * @param nomeItem
	 * @param atributo
	 * @return
	 * @throws ItemNaoEncontradoException
	 */
	
	public String getInfoItem(String nomeItem, String atributo) throws ItemNaoEncontradoException {
		String info = "";
		Item item = buscaItem(nomeItem);
		if (atributo.trim().equalsIgnoreCase("preco")){
			info += item.getPreco();
			return info;
		} 
		else if (atributo.trim().equalsIgnoreCase("peca perdida")) {
			info = item.getPecasPerdidas();
		}
		else if (atributo.trim().equalsIgnoreCase("nome")){
			info = item.getNomeDoItem();
		}
		
		return info;
	}
	
	/**
	 * 
	 * @param nomeItem
	 * @return
	 * @throws ItemNaoEncontradoException
	 */

	private Item buscaItem(String nomeItem) throws ItemNaoEncontradoException {

		for (Item item : itens) {
			if (item.getNomeDoItem().equals(nomeItem)) {
				return item;
			}
		}
		throw new ItemNaoEncontradoException();
	}
		
	/**
	 * 
	 * @param item
	 * @return
	 */
	

	private boolean verificaItem(Item item) {
		if (itens.contains(item)) {
			return true;
		}
		return false;
	}

	public void emprestaItem(String nomeItem) throws ItemNaoEncontradoException {
		Item itemBuscado = buscaItem(nomeItem);
		if (itemBuscado.isEmprestado()) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		else {
			itemBuscado.setEmprestado(true);
			itemBuscado.addVezEmprestada();
		}
	}
	
	public void devolveItem(Usuario dono, String nomeItem, String dataDevolucao) throws ItemNaoEncontradoException {
		Item itemBuscado = 	dono.buscaItem(nomeItem);	
		if (!itemBuscado.isEmprestado()) {
			return;
		}
		itemBuscado.setEmprestado(false);
		
	}
	
	/**
	 * 
	 * @param item
	 */

	public void cadastrarItem(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Item> getItens() {
		return this.itens;
		
	}
	
	public Set<Emprestimo> getItensEmprestadosDono() {
		return this.emprestimosDono;
		
	
	}
	
	/**
	 * Retorna a lista de emprestimos que o usuario fez
	 * @return 
	 */
	public Set<Emprestimo> getEmprestimosDono() {
		
		return getItensEmprestadosDono();
	}
	
	/**
	 * Retorna a lista de emprestimos que o usuario tomou como emprestado
	 * @return O conjunto de emprestimos que o requerente pegou por um tempo.
	 */
	public Set<Emprestimo> getEmprestimosRequerente() {
		return emprestimosRequerente;
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


}
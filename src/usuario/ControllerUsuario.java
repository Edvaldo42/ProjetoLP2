package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import comparator.ordemAlfabetica;
import comparator.valor;
import emprestimo.Emprestimo;
import exception.ItemNaoEncontradoException;
import exception.PecaPerdidaException;
import exception.StringInvalidaException;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import facadeEMain.Validacoes;
import item.Item;

public class ControllerUsuario {

	private static final String nome = null;
	private Set<Usuario> usuarios;
	private Comparator<Item> tipoDeOrdenacao;
	private Comparator<Emprestimo> ordenaUsuario;
	private List<Emprestimo> emprestimos; 

	public ControllerUsuario() {
		usuarios = new HashSet<>();
		emprestimos = new ArrayList<>();
	}

	public void cadastraUsuario(String nome, String telefone, String email)
			throws UsuarioCadastradoException, StringInvalidaException {
		Validacoes.validaCadastrarUsuario(nome, telefone, email);
		CRUDUsuario.cadastraUsuario(nome, telefone, email, this.usuarios);
	}

	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		CRUDUsuario.removerUsuario(nome, telefone, usuarios);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws StringInvalidaException {
		Validacoes.validaAtualizarUsuario(atributo, valor);
		CRUDUsuario.atualizarUsuario(nome, telefone, atributo, valor, this.usuarios);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		return CRUDUsuario.getInfoUsuario(nome, telefone, atributo, this.usuarios);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new PecaPerdidaException();
		}

		usuario.adicionarPecaPerdida(nomeItem, nomePeca);
	}

	public void cadastrarItem(String nome, String telefone, Item item) throws UsuarioInvalidoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);
		
		usuario.cadastrarItem(item);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);

		usuario.adicionarBluRay(nomeBlurayTemporada, duracao);
	}

	public void removerItem(String nome, String telefone, String nomeItem)	throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);

		usuario.removerItem(nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);
		Validacoes.validaAtualizarItem(atributo, valor);

		usuario.atualizarItem(nomeItem, atributo, valor);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);

		return usuario.getInfoItem(nomeItem, atributo);
	}

	public String pesquisarDetalhesItem(String nomeDono, String telefoneDono, String nomeItem)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nomeDono, telefoneDono);

		CRUDUsuario.validaUsuario(usuario);

		return usuario.detalhesItem(nomeItem);
	}

	/**
	 * 
	 * @return
	 */

	private List<Item> getItens() {
		List<Item> retornoItens = new ArrayList<>();
		
		for (Usuario usuario : getUsuarios()) {
			for (Item item : usuario.getItens()) {
				retornoItens.add(item);
			}
		}

		return retornoItens;
	}

	/**
	 * Retorn
	 * 
	 * @param user
	 * 
	 * @param user
	 * @return
	 */

	private List<Emprestimo> getItensEmprestadosDono(Usuario user) {
		List<Emprestimo> retornoEmprestimos = new ArrayList<>();
		for (Emprestimo emprestimo : user.getEmprestimosDono()) {
			retornoEmprestimos.add(emprestimo);
		}

		return retornoEmprestimos;
	}

	/**
	 * Retorna os itens que foram pegos emprestados por 1 usuario
	 * 
	 * @return
	 */
	private List<Emprestimo> getItensEmprestadosRequerente(Usuario user) {
		List<Emprestimo> retornoEmprestimos = new ArrayList<>();
		for (Emprestimo emprestimo : user.getEmprestimosRequerente()) {
			retornoEmprestimos.add(emprestimo);
		}
		return retornoEmprestimos;
	}

	/**
	 * 
	 * @return
	 */

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

	/**
	 * 
	 * @return
	 */

	public String listarItensOrdenadosPorValor() {
		tipoDeOrdenacao = new valor();
		List<Item> itens = getItens();
		Collections.sort(itens, tipoDeOrdenacao);
		String retorno = "";
		for (Item item : itens) {
			retorno += item.toString() + "|";
		}

		return retorno;
	}

	public Usuario buscaUsuario(String nome, String telefone) {
		return CRUDUsuario.buscaUsuario(nome, telefone, this.usuarios);
	}

	private void validaUsuario(Usuario user) throws UsuarioInvalidoException {
		CRUDUsuario.validaUsuario(user);
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, Emprestimo emprestimo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {

		Usuario dono = buscaUsuario(nomeDono, telefoneDono);
		Usuario requerente = buscaUsuario(nomeRequerente, telefoneRequerente);

		validaUsuario(dono);
		validaUsuario(requerente);

		dono.emprestaItem(emprestimo.getItemEmprestado());
		dono.registrarEmprestimoDono(emprestimo);
		requerente.registrarEmprestimoRequerente(emprestimo);
		this.emprestimos.add(emprestimo);
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException {

		Usuario dono = buscaUsuario(nomeDono, telefoneDono);
		Usuario requerente = buscaUsuario(nomeRequerente, telefoneRequerente);
		Emprestimo emprestimo = buscaEmprestimo(dono, requerente, nomeItem, dataEmprestimo);
		
		validaUsuario(dono);
		validaUsuario(requerente);

		if (emprestimo == null) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
		
		requerente.devolveItem(dono, nomeItem, dataDevolucao);
		if (emprestimo.getDataDevolucao().trim().equals("Emprestimo em andamento")) {
			emprestimo.setDataDevolucao(dataDevolucao);
			
		}
		
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		Usuario user = buscaUsuario(nome, telefone);
		tipoDeOrdenacao = new ordemAlfabetica();
		String retorno = "Nenhum item emprestado";
		if (!getItensEmprestadosDono(user).isEmpty()) {
			retorno = "Emprestimos: ";
			for (Emprestimo emprestimo : getItensEmprestadosDono(user)) {
				retorno += emprestimo.toString() + "|";
			}
			
		}return retorno;
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		Usuario user = buscaUsuario(nome, telefone);
		tipoDeOrdenacao = new ordemAlfabetica();
		String retorno = "Nenhum item pego emprestado";
		if (!getItensEmprestadosRequerente(user).isEmpty()) {
			retorno = "Emprestimos pegos: ";
			for (Emprestimo emprestimo : getItensEmprestadosRequerente(user)) {
				retorno += emprestimo.toString() + "|";
			}

		}
		return retorno;
	}

	public String listarEmprestimosItem(String nomeItem) {
		tipoDeOrdenacao = new ordemAlfabetica();
		List<Item> itens = getItem(nomeItem);
		Collections.sort(itens, tipoDeOrdenacao);
		String retorno = "";
		for (Item item : getItens()) {
			retorno += item.toString() + "|";
		}

		return retorno;
	}

	private List<Item> getItem(String nomeItem) {
		List<Item> retornoItens = new ArrayList<>();
		for (Usuario usuario : getUsuarios()) {
			if (usuario.getItens().contains(nomeItem));{
				retornoItens.addAll(getItens());
			}
			
		}
		return retornoItens;
	}
	
	private Emprestimo buscaEmprestimo(Usuario dono, Usuario requerente, String nomeItem, String data){
		Emprestimo emprestimoBuscado = null;
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDono().equals(dono) && emprestimo.getRequerente().equals(requerente) &&
			emprestimo.getItemEmprestado().equals(nomeItem) && emprestimo.getDataEmprestimo().equals(data)) {
				emprestimoBuscado = emprestimo;
			}
		}
			
		return emprestimoBuscado;
	}
}
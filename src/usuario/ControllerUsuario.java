package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import comparator.OrdemAlfabeticaEmprestimo;
import comparator.OrdemAlfabeticaItem;
import comparator.OrdemAlfabeticaUsuario;
import comparator.OrdemPorReputacao;
import comparator.OrdenaPorValor;
import comparator.OrdenaPorVezesEmprestado;
import emprestimo.Emprestimo;
import exception.AnoDeLancamentoMenorQue0Exception;
import exception.AtributoInvalidoException;
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
import exception.PecaPerdidaException;
import exception.PlataformaNullOuVaziaException;
import exception.PrecoInvalidoException;
import exception.SerieNaoValidaException;
import exception.StringInvalidaException;
import exception.TemporadaMenorQue1Exception;
import exception.UsuarioCadastradoException;
import exception.UsuarioInvalidoException;
import facadeEMain.Validacoes;
import item.Item;

public class ControllerUsuario {

	private static final String nome = null;
	private Set<Usuario> usuarios;
	private Comparator<Item> ordenaItem;
	private Comparator<Emprestimo> ordenaEmprestimo;
	private Comparator<Usuario> ordenaUsuario;
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
	
	/**
	 * Precisa validar
	 * @param nome
	 * @param telefone
	 * @throws UsuarioInvalidoException
	 */
	
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

	public void cadastrarItem(String nome, String telefone, Item item) throws UsuarioInvalidoException, ItemCadastradaException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);
		
		usuario.cadastrarItem(item);
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, SerieNaoValidaException {
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
			throws UsuarioInvalidoException, ItemNaoEncontradoException, NomeDoItemNuloOuVazioException, NumeroDeFaixasMenorQue1Exception, PrecoInvalidoException, PlataformaNullOuVaziaException, DuracaoInvalidaException, ClassificacaoNulaOuVaziaException, GeneroNuloOuVazioException, AnoDeLancamentoMenorQue0Exception, NomeDoArtistaNuloOuVazioException, TemporadaMenorQue1Exception, DescricaoInvalidaException, AtributoInvalidoException {
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
		ordenaItem = new OrdemAlfabeticaItem();
		List<Item> itens = getItens();
		Collections.sort(itens, ordenaItem);
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
		ordenaItem = new OrdenaPorValor();
		List<Item> itens = getItens();
		Collections.sort(itens, ordenaItem);
		String retorno = "";
		for (Item item : itens) {
			retorno += item.toString() + "|";
		}

		return retorno;
	}


	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, Emprestimo emprestimo)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, ItemEmprestadoException {

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
			throws UsuarioInvalidoException, ItemNaoEncontradoException, EmprestimoNaoEncontradoException {

		Usuario dono = buscaUsuario(nomeDono, telefoneDono);
		Usuario requerente = buscaUsuario(nomeRequerente, telefoneRequerente);
		Emprestimo emprestimo = buscaEmprestimo(dono, requerente, nomeItem, dataEmprestimo);
		
		validaUsuario(dono);
		validaUsuario(requerente);

		if (emprestimo == null) {
			throw new EmprestimoNaoEncontradoException();
		}
		
		requerente.devolveItem(dono, nomeItem, dataDevolucao);
		if (emprestimo.getDataDevolucao().equals("Emprestimo em andamento")) {
			emprestimo.setDataDevolucao(dataDevolucao);
			if (emprestimo.getTempoComItem() <= emprestimo.getPeriodo()) {
				requerente.aumentaReputacao(dono.buscaItem(nomeItem).getPreco(), 0.05);
			}
			else {
				requerente.diminuiReputacao(dono.buscaItem(nomeItem).getPreco(), 0.01 * emprestimo.getAtraso());
			}
		}
		
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) throws UsuarioInvalidoException {
		Usuario user = buscaUsuario(nome, telefone);
		ordenaEmprestimo = new OrdemAlfabeticaEmprestimo();
		String retorno = "Nenhum item emprestado";
		List<Emprestimo> emprestimosTemp;
		
		validaUsuario(user);
		
		if (!getItensEmprestadosDono(user).isEmpty()) {
			retorno = "Emprestimos: ";
			emprestimosTemp = new ArrayList<>();
			emprestimosTemp.addAll(getItensEmprestadosDono(user));
			Collections.sort(emprestimosTemp, ordenaEmprestimo);

			for (Emprestimo emprestimo : emprestimosTemp) {
				retorno += emprestimo.toString() + "|";
			}
			
		}return retorno;
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) throws UsuarioInvalidoException {
		Usuario user = buscaUsuario(nome, telefone);
		ordenaEmprestimo = new OrdemAlfabeticaEmprestimo();
		String retorno = "Nenhum item pego emprestado";
		List<Emprestimo> emprestimosTemp;
		
		validaUsuario(user);
		
		if (!getItensEmprestadosRequerente(user).isEmpty()) {
			retorno = "Emprestimos pegos: ";
			emprestimosTemp = new ArrayList<>();
			emprestimosTemp.addAll(getItensEmprestadosRequerente(user));
			Collections.sort(emprestimosTemp, ordenaEmprestimo);

			for (Emprestimo emprestimo : emprestimosTemp) {
				retorno += emprestimo.toString() + "|";
			}

		}
		return retorno;
	}

	public String listarEmprestimosItem(String nomeItem) {
		String retorno = "";
		
		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getItemEmprestado().equalsIgnoreCase(nomeItem)) {
				retorno += emprestimo.toString() + "|";
			}
		}
		if (retorno.equals("")) {
			retorno += "Nenhum emprestimos associados ao item";
		}
		else {
			retorno = "Emprestimos associados ao item: " + retorno; 
		}
		
		return retorno;
	}
	
	public String listarItensNaoEmprestados() {
		String retorno = "";
		ordenaItem = new OrdemAlfabeticaItem();
		List<Item> itens = getItens();
		Collections.sort(itens, ordenaItem);
		
		for (Item item : itens) {
			if (!item.isEmprestado()) {
				retorno += item.toString() + "|";
			}
		}
		
		return retorno;	
	}
	
	public String listarItensEmprestados() {
		String retorno = "";
		ordenaItem = new OrdemAlfabeticaItem();
		ordenaUsuario = new OrdemAlfabeticaUsuario();
		List<Usuario> usuariosTemp = new ArrayList<>();
		List<Item> itensDoDono = new ArrayList<>();
		
		usuariosTemp.addAll(getUsuarios());
		Collections.sort(usuariosTemp, ordenaUsuario);
		
		for (Usuario usuario : usuariosTemp) {
			itensDoDono = new ArrayList<>();
			itensDoDono.addAll(usuario.getItens());
			Collections.reverse(itensDoDono);
			
			for (Item item : itensDoDono) {
				if (item.isEmprestado()) {
					retorno += "Dono do item: " + usuario.getNome() + ", Nome do item emprestado: " + item.getNomeDoItem() + "|"; 
				}
			}
		}
		
		return retorno;	
	}
	
	public String listarTop10Itens() {
		String retorno = "";
		ordenaItem = new OrdenaPorVezesEmprestado();
		
		List<Item> topDez = getItens();
		Collections.sort(topDez, ordenaItem);
		
		int i = 1;
		for (Item item : topDez) {
			if (item.getVezesEmprestado() > 0) {
				retorno += i + ") " + item.getVezesEmprestado() + " emprestimos - " + item.toString() + "|";
				i++;
			}
		}
		
		return retorno;
	}
	
	public String listarCaloteiros() {
		String retorno = "Lista de usuarios com reputacao negativa: ";
		List<Usuario> usuariosTemp = new ArrayList<>();
		usuariosTemp.addAll(getUsuarios());
		
		for (Usuario usuario : usuariosTemp) {
			if (usuario.getReputacao() < 0) {
				retorno += usuario.toString() + "|";
			}
		}
		
		return retorno;
	}
	
	public String listarTop10MelhoresUsuarios() {
		String retorno = "";
		List<Usuario> usuariosTemp = new ArrayList<>();
		usuariosTemp.addAll(getUsuarios());
		ordenaUsuario = new OrdemPorReputacao();
		Collections.sort(usuariosTemp, ordenaUsuario);
		Collections.reverse(usuariosTemp);
		String preco;

		for (int i = 0; i < 10; i++) {
			preco = String.format("%.2f", usuariosTemp.get(i).getReputacao());
			preco = preco.replace(".", ",");
			retorno += (i + 1) + ": "  + usuariosTemp.get(i).getNome() + " - Reputacao: " + preco + "|";
		}
		
		return retorno;
	}
	
	public String listarTop10PioresUsuarios() {
		String retorno = "";
		List<Usuario> usuariosTemp = new ArrayList<>();
		usuariosTemp.addAll(getUsuarios());
		ordenaUsuario = new OrdemPorReputacao();
		Collections.sort(usuariosTemp, ordenaUsuario);
		String preco;
		
		for (int i = 0; i < 10; i++) {
			preco = String.format("%.2f", usuariosTemp.get(i).getReputacao());
			preco = preco.replace(".", ",");
			retorno += (i + 1) + ": "  + usuariosTemp.get(i).getNome() + " - Reputacao: " + preco + "|";
		}
		
		return retorno;
		
	}
	
	public Usuario buscaUsuario(String nome, String telefone) {
		return CRUDUsuario.buscaUsuario(nome, telefone, this.usuarios);
	}

	private void validaUsuario(Usuario user) throws UsuarioInvalidoException {
		CRUDUsuario.validaUsuario(user);
	}
	
	/**
	 * 
	 * @return
	 */

	private List<Item> getItens() {
		List<Item> retornoItens = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
				retornoItens.addAll(usuario.getItens());
		}

		return retornoItens;
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
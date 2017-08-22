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
import exception.ItemCadastradoException;
import exception.ItemEmprestadoException;
import exception.NomeDoItemNuloOuVazioException;
import exception.ItemNaoEncontradoException;
import exception.NomeDoArtistaNuloOuVazioException;
import exception.NumeroDeFaixasMenorQue1Exception;
import exception.PecaJaPerdidaException;
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

	/**
	 * Cadastra um usuario no sistema
	 * 
	 * @param nome O nome do usuario a ser cadastrado
	 * @param telefone O telefone do usuario a ser cadastrado
	 * @param email O email do usuario a ser cadastrado
	 * @throws UsuarioCadastradoException Caso o usuario ja esteja cadastrado
	 * @throws StringInvalidaException Caso alguma String seja invalida
	 */
	public void cadastraUsuario(String nome, String telefone, String email)
			throws UsuarioCadastradoException, StringInvalidaException {
		Validacoes.validaCadastrarUsuario(nome, telefone, email);
		CRUDUsuario.cadastraUsuario(nome, telefone, email, this.usuarios);
	}
	
	/**
	 * Remove o usuario do sistema
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario 
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	
	public void removerUsuario(String nome, String telefone) throws UsuarioInvalidoException {
		CRUDUsuario.removerUsuario(nome, telefone, usuarios);
	}

	/**
	 * Atualiza uma informacao, passada no atributo, de um usuario
	 * 
	 * @param nome O nome do usuario a ter uma informacao atualizada
	 * @param telefone O telefone do usuario a ter uma informacao atualizada
	 * @param atributo O atributo que devera ser atualizado
	 * @param valor A nova informacao a ser atualizada
	 * @throws StringInvalidaException Caso uma string seja invalida
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor)
			throws StringInvalidaException {
		Validacoes.validaAtualizarUsuario(atributo, valor);
		CRUDUsuario.atualizarUsuario(nome, telefone, atributo, valor, this.usuarios);
	}

	/**
	 * Retorna uma informacao, passada no atributo, do usuario
	 * 
	 * @param nome O nome do usuario de que se saber alguma informacao
	 * @param telefone O telefone do usuario de que se saber alguma informacao
	 * @param atributo A informacao que se quer saber sobre um usuario
	 * @return A informacao desejada de um usuario
	 * @throws StringInvalidaException Caso uma string seja invalida
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) throws StringInvalidaException {
		return CRUDUsuario.getInfoUsuario(nome, telefone, atributo, this.usuarios);
	}
	
	/**
	 * Adiciona uma peca perdida de um jogo
	 *  
	 * @param nome O nome do dono do jogo
	 * @param telefone O telefone do dono do jogo
	 * @param nomeItem O nome do jogo que se quer adcionar a informacao sobre a peca perdida
	 * @param nomePeca O nome da peca perdida
	 * @throws PecaPerdidaException Caso a informacao nao possa ser adicionada
	 * @throws ItemNaoEncontradoException Caso o jogo nao esteja cadastrado
	 * @throws PecaJaPerdidaException Caso a informacao da peca perdida ja tenha sido adcionada
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws PecaPerdidaException, ItemNaoEncontradoException, PecaJaPerdidaException {
		Usuario usuario = buscaUsuario(nome, telefone);
		if (usuario == null) {
			throw new PecaPerdidaException();
		}

		usuario.adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Cadastrar um item no sistema
	 * 
	 * @param nome O nome do usuario que esta cadastrando o item
	 * @param telefone O telefone do usuario esta cadastrando o item
	 * @param item O item que sera cadastrado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemCadastradoException Caso o item ja esteja cadastrado
	 */
	public void cadastrarItem(String nome, String telefone, Item item) throws UsuarioInvalidoException, ItemCadastradoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);
		
		usuario.cadastrarItem(item);
	}

	/**
	 * 
	 * @param nome
	 * @param telefone
	 * @param nomeBlurayTemporada
	 * @param duracao
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * @throws SerieNaoValidaException Caso o item nao seja uma serie
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, SerieNaoValidaException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);

		usuario.adicionarBluRay(nomeBlurayTemporada, duracao);
	}

	/**
	 * Remove um item de um usuario
	 * 
	 * @param nome O nome do usuario que tera o item removido
	 * @param telefone O telefone do Usuario que tera o item removido
	 * @param nomeItem O nome do item que sera removido
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado no sistema
	 */
	public void removerItem(String nome, String telefone, String nomeItem)	throws UsuarioInvalidoException, ItemNaoEncontradoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);

		usuario.removerItem(nomeItem);
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
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * @throws NomeDoItemNuloOuVazioException Caso o nome do item seja nulo ou vazio
	 * @throws AtributoInvalidoException Caso o atributo seja invalido
	 * @throws DescricaoInvalidaException Caso a descricao seja invalida
	 * @throws TemporadaMenorQue1Exception Caso a temporada seja menor do que 1
	 * @throws NomeDoArtistaNuloOuVazioException Caso o nome do artista seja nulo ou vazio
	 * @throws AnoDeLancamentoMenorQue0Exception Caso o ano de lancamento seja menor que 0
	 * @throws GeneroNuloOuVazioException Caso o genero seja nulo ou vazio
	 * @throws ClassificacaoNulaOuVaziaException Caso a classificacao seja nula ou vazia
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
	 * @throws PlataformaNullOuVaziaException Caso a plataforma seja nula ou vazia
	 * @throws PrecoInvalidoException Caso o preco seja invalido
	 * @throws NumeroDeFaixasMenorQue1Exception Caso o numero de faixas seja menor do que 1
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws UsuarioInvalidoException, ItemNaoEncontradoException, NomeDoItemNuloOuVazioException, NumeroDeFaixasMenorQue1Exception, PrecoInvalidoException, PlataformaNullOuVaziaException, DuracaoInvalidaException, ClassificacaoNulaOuVaziaException, GeneroNuloOuVazioException, AnoDeLancamentoMenorQue0Exception, NomeDoArtistaNuloOuVazioException, TemporadaMenorQue1Exception, DescricaoInvalidaException, AtributoInvalidoException {
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);
		Validacoes.validaAtualizarItem(atributo, valor);

		usuario.atualizarItem(nomeItem, atributo, valor);
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
		Usuario usuario = buscaUsuario(nome, telefone);

		CRUDUsuario.validaUsuario(usuario);

		return usuario.getInfoItem(nomeItem, atributo);
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
		Usuario usuario = buscaUsuario(nomeDono, telefoneDono);

		CRUDUsuario.validaUsuario(usuario);

		return usuario.detalhesItem(nomeItem);
	}
	
	/**
	 * Retorna a lista de emprestimos que o usuario emprestou o item
	 * 
	 * @param user O usuario do qual se quer saber os emprestimos
	 * @return A lista de emprestimos que o usuario emprestou o item
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
	 * @return Os itens que foram pegos emprestados por 1 usuario
	 */
	private List<Emprestimo> getItensEmprestadosRequerente(Usuario user) {
		List<Emprestimo> retornoEmprestimos = new ArrayList<>();
		for (Emprestimo emprestimo : user.getEmprestimosRequerente()) {
			retornoEmprestimos.add(emprestimo);
		}
		return retornoEmprestimos;
	}

	/**
	 * Lista todos os itens em ordem alfabetica
	 * 
	 * @return A lista ordenada dos itens pela ordem alfabetica
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
	 * Lista todos os itens por ordem de valor
	 * 
	 * @return A lista ordenada dos itens pelo valor dos itens
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


	/**
	 * Retornas uma lista com os usuarios
	 * 
	 * @return Lista com os usuarios
	 */
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Registra o emprestimo de um item
	 * 
	 * @param nomeDono O nome do dono do item
	 * @param telefoneDono O telefone do dono do item
	 * @param nomeRequerente O nome do requerente
	 * @param telefoneRequerente O telefone do requerente
	 * @param emprestimo O emprestimo que está sendo realizado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 * @throws ItemNaoEncontradoException Caso o item nao seja encontrado
	 * @throws ItemEmprestadoException Caso o item ja esteja emprestado
	 */
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

	/**
	 * Lista os emprestimos do usuario que esta emprestando algo
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos itens que foram pegos emprestados pelo usuario
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
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

	/**
	 * Lista os emprestimos do usuario que esta pegando algo emprestado
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @return A lista dos itens que foram pegos emprestados pelo usuario
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
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

	/**
	 * Lista os usuarios que pegaram determinado item emprestado
	 * 
	 * @param nomeItem O nome do item
	 * @return A lista dos usuarios que pegaram o item emprestado
	 */
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
	
	/**
	 * Retorna uma lista os itens nao emprestados do sistema
	 * 
	 * @return Lista os itens nao emprestados do sistema
	 */
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
	
	/**
	 * Retorna uma lista os itens emprestados do sistema
	 * 
	 * @return Lista os itens emprestados do sistema
	 */
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
	
	/**
	 * Retorna uma lista com os 10 itens mais emprestados do sistema
	 * 
	 * @return Lista com os 10 itens mais emprestados do sistema
	 */
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
	
	/**
	 * Retorna uma lista com os usuarios que possuem status de caloteiros
	 * 
	 * @return Lista com os usuarios que possuem status de caloteiros
	 */
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
	
	/**
	 * Retorna uma lista com os 10 usuarios com a maior pontuacao
	 * 
	 * @return Lista com os 10 usuarios com a maior pontuacao
	 */
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
	
	/**
	 * Retorna uma lista com os 10 usuarios com a menor pontuacao
	 * 
	 * @return Lista com os 10 usuarios com a menor pontuacao
	 */
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
	
	/**
	 * Retorna um usuario especifico do sistema
	 * 
	 * @param nome O nome do usuario que se busca
	 * @param telefone O telefone do usuario que se busca
	 * @return O usuario buscado
	 */
	public Usuario buscaUsuario(String nome, String telefone) {
		return CRUDUsuario.buscaUsuario(nome, telefone, this.usuarios);
	}

	/**
	 * Valida um usuario
	 * 
	 * @param user O usuario a ser validado
	 * @throws UsuarioInvalidoException Caso o usuario seja invalido
	 */
	private void validaUsuario(Usuario user) throws UsuarioInvalidoException {
		CRUDUsuario.validaUsuario(user);
	}
	
	/**
	 * Retorna uma lista dos itens que estão no sistema
	 * 
	 * @return Lista dos itens que estão no sistema
	 */

	private List<Item> getItens() {
		List<Item> retornoItens = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
				retornoItens.addAll(usuario.getItens());
		}

		return retornoItens;
	}
	
	/**
	 * Retorna uma lista com todos os itens que possuem um nome especifico
	 * 
	 * @param nomeItem O nome do item que ser quer
	 * @return Lista com todos os itens que possuem um nome especifico
	 */
	private List<Item> getItem(String nomeItem) {
		List<Item> retornoItens = new ArrayList<>();
		for (Usuario usuario : getUsuarios()) {
			if (usuario.getItens().contains(nomeItem));{
				retornoItens.addAll(getItens());
			}
			
		}
		return retornoItens;
	}
	
	/**
	 * Retorna um emprestimo especifico
	 * 
	 * @param dono O dono do item no emprestimo
	 * @param requerente O requerente do item
	 * @param nomeItem O nome do item emprestado
	 * @param data A data do emprestimo
	 * @return Um emprestimo especifico
	 */
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
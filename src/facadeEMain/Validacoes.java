package facadeEMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.AtributoInvalidoException;
import exception.EmailInvalidoException;
import exception.NomeInvalidoException;
import exception.StringInvalidaException;
import exception.TelefoneInvalidoException;

/**
 * 
 *
 */
public class Validacoes {

	private static List<String> plataformas = new ArrayList<>(
			Arrays.asList("PC", "MAC", "PS3", "PS4", "XBOX360", "XBOX_ONE", "NINTENDO_3DS"));

	private static List<String> classificacoes = new ArrayList<>(
			Arrays.asList("LIVRE", "DEZ_ANOS", "DOZE_ANOS", "QUATORZE_ANOS", "DEZESSEIS_ANOS", "DEZOITO_ANOS"));

	private static List<String> generos = new ArrayList<>(
			Arrays.asList("ACAO", "ANIMACAO", "AVENTURA", "COMEDIA", "DOCUMENTARIO", "DRAMA", "EROTICO", "FAROESTE",
					"FICCAO", "MUSICAL", "POLICIAL", "ROMANCE", "SUSPENSE", "TERROR"));

	private final static String ERRO_CADASTRO_USUARIO = "Erro ao cadastrar usuario: ";
	private final static String ERRO_ATUALIZACAO = "Erro ao atualizar usuario: ";
	
	
	/**
	 * Valida o cadastro de um usuario
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param email O email do usuario
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 */
	public static void validaCadastrarUsuario(String nome, String telefone, String email)
			throws StringInvalidaException {
		if (!validaNome(nome)) {
			throw new NomeInvalidoException(ERRO_CADASTRO_USUARIO);
		}
		if (!validaEmail(email)) {
			throw new EmailInvalidoException(ERRO_CADASTRO_USUARIO);
		}
		if (!validaTelefone(telefone)) {
			throw new TelefoneInvalidoException(ERRO_CADASTRO_USUARIO);
		}
	}

	/**
	 * Valida a atualizacao de um usuario
	 * @param atributo O atributo a ser mudado 
	 * @param valor O novo valor do atributo
	 * @throws StringInvalidaException Caso alguma string seja nula ou vazia
	 */
	public static void validaAtualizarUsuario(String atributo, String valor) throws StringInvalidaException {
		if (atributo.trim().equalsIgnoreCase("nome")) {
			if (!validaNome(valor)) {
				throw new NomeInvalidoException(ERRO_ATUALIZACAO);
			}
		} else if (atributo.trim().equalsIgnoreCase("email")) {
			if (!validaEmail(valor)) {
				throw new EmailInvalidoException(ERRO_ATUALIZACAO);
			}
		} else if (atributo.trim().equalsIgnoreCase("telefone")) {
			if (!validaTelefone(valor)) {
				throw new TelefoneInvalidoException(ERRO_ATUALIZACAO);
			}
		}

		else {
			throw new AtributoInvalidoException();
		}

	}
	
	/**
	 * Valida o cadastro de jogos eletronicos
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param plataforma A plataforma do jogo
	 * @throws IllegalArgumentException Caso a plataforma seja nula ou vazia
	 */
	public static void validaCadastrarEletronico(String nomeItem, double preco, String plataforma) throws IllegalArgumentException {
		String msg = "Erro ao cadastrar Jogo Eletronico: ";

		validaItem(nomeItem, preco, msg);

		if (plataforma == null || plataforma.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Plataforma nao pode ser nula ou vazia");
		}
	}

	/**
	 * Valida a plataforma 
	 * @param plataforma A plataforma do jogo 
	 * @return True se a plataforma existe e False caso contrario
	 */
	public static boolean validaPlataforma(String plataforma) {
		return plataformas.contains(plataforma.toUpperCase());
	}

	/**
	 * Valida o cadastro de um jogo de tabuleiro
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 */
	public static void validaCadastrarJogoTabuleiro(String nomeItem, double preco) {
		String msg = "Erro ao cadastrar Jogo de Tabuleiro: ";
		validaItem(nomeItem, preco, msg);
	}

	/**
	 * Valida a acao de add uma peca perdida a um jogo
	 * @param nomeItem O nome do jogo
	 * @param nomePeca O nome da peca perdida
	 * @throws IllegalArgumentException Caso o nome do item ou da peca seja nulo ou vazio
	 */
	public static void validaAdicionarPecaPerdida(String nomeItem, String nomePeca) throws IllegalArgumentException {
		String msg = "Erro ao adicionar Peca Perdida: ";

		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Nome do item nao pode ser nulo ou vazio");
		}
		if (nomePeca == null || nomePeca.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Nome da peca nao pode ser nulo ou vazio");
		}
	}

	/**
	 * Valida o cadastro de um filme BluRay
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param duracao A duracao do filme
	 * @param genero O genero do filme
	 * @param classificacao A classificacao etaria do filme
	 * @param anoLancamento O ano de lancamento do filme
	 * @throws IllegalArgumentException Caso o genero seja nulo ou vazio ou caso o ano de lancamento seja invalido
	 */
	public static void validaCadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero,
			String classificacao, int anoLancamento) throws IllegalArgumentException {
		String msg = "Erro ao cadastrar BluRay de Filme: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);

		if (genero == null || genero.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Genero nao pode ser nulo ou vazio");
		}
		if (anoLancamento < 0) {
			throw new IllegalArgumentException("Ano de lancamento nao pode ser menor que 0");
		}
	}

	/**
	 * Valida o cadastro de um show BluRay
	 * @param nomeItem O nome do show
	 * @param preco O preco do item
	 * @param duracao A duracao do show
	 * @param numeroFaixas O numero de faixas do show
	 * @param artista O artista do show
	 * @param classificacao A classificacao etaria do show
	 * @throws IllegalArgumentException Caso o nome seja nulo ou vazio ou o numero de faixas seja invalido
	 */
	public static void validaCadastrarBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) throws IllegalArgumentException {
		String msg = "Erro ao cadastrar BluRay de Show: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);

		if (numeroFaixas < 1) {
			throw new IllegalArgumentException("Faixas nao podem ser menor do que 1");
		}
		if (artista == null || artista.trim().equals("")) {
			throw new IllegalArgumentException("O nome do artista nao pode ser nulo ou vazio");
		}
	}

	/**
	 * Valida o cadastro de uma serie BluRay
	 * @param nomeItem O nome da serie
	 * @param preco O preco do BluRay
	 * @param descricao A descricao da serie 
	 * @param duracao A duracao da temporada 
	 * @param classificacao A classificacao etaria da serie
	 * @param genero O genero da serie
	 * @param temporada A temporada da serie
	 * @throws IllegalArgumentException Caso algum parametro seja nulo ou vazio ou a temporada seja invalida
	 */
	public static void validaCadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) throws IllegalArgumentException {
		String msg = "Erro ao cadastrar BluRay de Serie: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Descricao nao pode ser nula ou vazia");
		}
		if (genero == null || genero.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Genero nao pode ser nulo ou vazio");
		}
		if (temporada < 1) {
			throw new IllegalArgumentException("Temporada nao pode ser menor do que 1");
		}
	}

	/**
	 * Valida o genero de um BluRay
	 * @param genero O genero do item
	 * @return true se o genero existe e false caso contrario
	 */
	public static boolean validaGenero(String genero) {
		return generos.contains(genero.toUpperCase());
	}

	/**
	 * Valida a acao de adicionar BluRay
	 * @param nomeBlurayTemporada O nome da temporada
	 * @param duracao A duracao da temporada
	 * @throws IllegalArgumentException Caso o nome ou duracao seja invalida
	 */
	public static void validaAdicionarBluRay(String nomeBlurayTemporada, int duracao) throws IllegalArgumentException {
		String msg = "Erro ao adicionar BluRay: ";

		if (nomeBlurayTemporada == null || nomeBlurayTemporada.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Nome do item nao pode ser nulo ou vazio");
		}
		if (duracao < 0) {
			throw new IllegalArgumentException(msg + "Duracao nao pode ser menor do que 0");
		}
	}

	/**
	 * Valida uma atualizacao de item
	 * @param atributo O atributo que sera atualizado
	 * @param valor O novo valor do atributo
	 * @throws IllegalArgumentException Caso algum parametro seja invalido
	 */
	public static void validaAtualizarItem(String atributo, String valor) throws IllegalArgumentException {
		String msg = "Erro na atualizacao de item: ";

		if (atributo.trim().equalsIgnoreCase("nome")) {
			if (valor == null || valor.trim().equals("")) {
				throw new IllegalArgumentException(msg + "Nome do item nao pode ser nulo ou vazio");
			}
		} else if (atributo.trim().equalsIgnoreCase("preco")) {
			if (Double.parseDouble(valor) < 0) {
				throw new IllegalArgumentException(msg + "Preco invalido");
			}
		} else if (atributo.trim().equalsIgnoreCase("plataforma")) {
			if (valor == null || valor.trim().equals("")) {
				throw new IllegalArgumentException(msg + "Plataforma nao pode ser nula ou vazia");
			}
		} else if (atributo.trim().equalsIgnoreCase("duracao")) {
			if (Integer.parseInt(valor) < 0) {
				throw new IllegalArgumentException(msg + "Duracao nao pode ser menor do que 0");
			}
		} else if (atributo.trim().equalsIgnoreCase("classificacao")) {
			if (valor == null || valor.trim().equals("")) {
				throw new IllegalArgumentException(msg + "Classificacao nao pode ser nula ou vazia");
			}
		} else if (atributo.trim().equalsIgnoreCase("genero")) {
			if (valor == null || valor.trim().equals("")) {
				throw new IllegalArgumentException(msg + "Genero nao pode ser nulo ou vazio");
			}
		} else if (atributo.trim().equalsIgnoreCase("anoLancamento")) {
			if (Integer.parseInt(valor) < 0) {
				throw new IllegalArgumentException(msg + "Ano de lancamento nao pode ser menor do que 0");
			}
		} else if (atributo.trim().equalsIgnoreCase("artista")) {
			if (valor == null || valor.trim().equals("")) {
				throw new IllegalArgumentException(msg + "Nome do artista nao pode ser nulo ou vazio");
			}
		} else if (atributo.trim().equalsIgnoreCase("numeroFaixas")) {
			if (Integer.parseInt(valor) < 0) {
				throw new IllegalArgumentException(msg + "Numero de faixas nao pode ser menor do que 0");
			}
		} else if (atributo.trim().equalsIgnoreCase("descricao")) {
			if (valor == null || valor.trim().equals("")) {
				throw new IllegalArgumentException(msg + "Descricao nao pode ser nula ou vazia");
			}
		} else if (atributo.trim().equalsIgnoreCase("temporada")) {
			if (Integer.parseInt(valor) < 0) {
				throw new IllegalArgumentException(msg + "Temporada nao pode ser menor do que 0");
			}
		} else {
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Valida um BluRay
	 * @param duracao A duracao do BluRay
	 * @param classificacao A classificacao etaria do BluRay
	 * @param msg A msg que sera exibida na excecao
	 * @throws IllegalArgumentException Caso a duracao ou classificacao seja invalida
	 */
	private static void validaBluRay(int duracao, String classificacao, String msg) throws IllegalArgumentException {

		if (duracao < 0) {
			throw new IllegalArgumentException(msg + "Duracao nao pode ser menor do que 0");
		}
		if (classificacao == null || classificacao.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Classificacao nao pode ser nula ou vazia");
		}
		if (!classificacoes.contains(classificacao)) {
			throw new IllegalArgumentException(msg + "Classificacao invalida");
		}

	}

	/**
	 * Valida um item
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param msg A msg que sera exibida na excecao
	 * @throws IllegalArgumentException Caso o nome seja nulo ou vazio ou caso o preco seja invalido
	 */
	private static void validaItem(String nomeItem, double preco, String msg) throws IllegalArgumentException {
		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new IllegalArgumentException("Nome do item nao pode ser nulo ou vazio");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	/**
	 * Valida o nome de um usuario
	 * @param nome O nome do usuario
	 * @return true se o nome eh valido
	 * @throws IllegalArgumentException Caso o nome seja nulo ou vazio
	 */
	private static boolean validaNome(String nome) throws IllegalArgumentException {
		if (nome == null) {
			throw new IllegalArgumentException("Nome nao pode ser null.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome nao pode ser vazio.");
		}
		return true;
	}

	/**
	 * Valida o telefone de um usuario
	 * @param telefone O telefone do usuario
	 * @return true se o telefone eh valido e false caso contrario
	 * @throws IllegalArgumentException Caso o telefone seja nulo ou vazio
	 */
	private static boolean validaTelefone(String telefone) throws IllegalArgumentException {
		int hifen = 0;
		if (telefone == null) {
			throw new IllegalArgumentException("Telefone nao pode ser null.");
		}
		if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Telefone nao pode ser vazio.");
		}
		if ((telefone.length()) > 10 || telefone.length() < 9) {
			return false;
		}
		if (!(telefone.charAt(5) == '-')) {
			return false;
		}
		if (telefone.charAt(0) == '-' || telefone.charAt(telefone.length() - 1) == '-') {
			return false;
		}
		if (telefone.charAt(5) == '-') {
			hifen++;
		}
		for (int i = 0; i < telefone.length() - 1; i++) {
			if (telefone.charAt(i) == ' ') {
				return false;
			}
			if (telefone.charAt(i) == '-' && i != 5) {
				return false;
			}
		}

		if (hifen != 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida o email do usuario
	 * @param email O email do usuario
	 * @return true se o email eh valido e false caso contrario
	 */
	private static boolean validaEmail(String email) {
		int arrobas = 0;
		int pontos = 0;

		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@'
				|| email.charAt(email.length() - 1) == '.') {
			return false;
		}
		for (int i = 0; i < email.length() - 1; i++) {
			if (email.charAt(i) == ' ') {
				return false;
			} else if (email.charAt(i) == '@') {
				arrobas++;
				if (email.charAt(i + 1) == '@')
					return false;
			} else if (email.charAt(i) == '.' && arrobas == 1) {
				pontos++;
				if (email.charAt(i + 1) == '.') {
					return false;
				}
			}

		}
		if (arrobas != 1 || pontos < 1) {
			return false;
		}

		return true;
	}

}

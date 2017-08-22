package facadeEMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.NomeDoItemNuloOuVazioException;
import exceptionsComplementares.NomeInvalidoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsItem.AnoDeLancamentoMenorQue0Exception;
import exceptionsItem.ClassificacaoInvalidaException;
import exceptionsItem.ClassificacaoNulaOuVaziaException;
import exceptionsItem.DescricaoInvalidaException;
import exceptionsItem.DuracaoInvalidaException;
import exceptionsItem.GeneroNuloOuVazioException;
import exceptionsItem.NomeDaPecaNuloOuVazioException;
import exceptionsItem.NomeDoArtistaNuloOuVazioException;
import exceptionsItem.NumeroDeFaixasMenorQue0Exception;
import exceptionsItem.PlataformaNullOuVaziaException;
import exceptionsItem.PrecoInvalidoException;
import exceptionsItem.TemporadaMenorQue1Exception;
import exceptionsUsuario.EmailInvalidoException;
import exceptionsUsuario.TelefoneInvalidoException;

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
		if (!validaTelefone(telefone)) {
			throw new TelefoneInvalidoException(ERRO_CADASTRO_USUARIO);
		}
		if (!validaEmail(email)) {
			throw new EmailInvalidoException(ERRO_CADASTRO_USUARIO);
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
	 * @throws NomeDoItemNuloOuVazioException Caso o Item seja invalido
	 * @throws PrecoInvalidoException Caso p preco seja invalido
	 * @throws PlataformaNullOuVaziaException Caso a plataforma seja nula ou vazia
	 */
	public static void validaCadastrarEletronico(String nomeItem, double preco, String plataforma) 
			throws NomeDoItemNuloOuVazioException, PrecoInvalidoException, PlataformaNullOuVaziaException {
		String msg = "Erro ao cadastrar Jogo Eletronico: ";

		validaItem(nomeItem, preco, msg);
		validaPlataforma(plataforma);

	}

	/**
	 * Valida a plataforma 
	 * @param plataforma A plataforma do jogo 
	 * @return True se a plataforma existe e False caso contrario
	 * @throws PlataformaNullOuVaziaException Caso a plataforma seja nula ou vazia
	 */
	public static boolean validaPlataforma(String plataforma) throws PlataformaNullOuVaziaException {
		if (plataforma == null || plataforma.trim().equals("")) {
			throw new PlataformaNullOuVaziaException();
		}
		return plataformas.contains(plataforma.toUpperCase());
	}

	/**
	 * Valida o cadastro de um jogo de tabuleiro
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @throws NomeDoItemNuloOuVazioException Caso o item seja invalido
	 * @throws PrecoInvalidoException Caso o prco seja invalido
	 */
	public static void validaCadastrarJogoTabuleiro(String nomeItem, double preco) 
			throws NomeDoItemNuloOuVazioException, PrecoInvalidoException {
		String msg = "Erro ao cadastrar Jogo de Tabuleiro: ";
		validaItem(nomeItem, preco, msg);
	}

	/**
	 * Valida a acao de add uma peca perdida a um jogo
	 * @param nomeItem O nome do jogo
	 * @param nomePeca O nome da peca perdida
 	 * @throws NomeDoItemNuloOuVazioException Caso o nome da peca seja nulo ou vazio
	 * @throws NomeDaPecaNuloOuVazioException Caso o nome da peca seja nulo ou vazio
	 */
	public static void validaAdicionarPecaPerdida(String nomeItem, String nomePeca) 
			throws NomeDoItemNuloOuVazioException, NomeDaPecaNuloOuVazioException {
		String msg = "Erro ao adicionar Peca Perdida: ";

		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new NomeDoItemNuloOuVazioException(msg);
		}
		if (nomePeca == null || nomePeca.trim().equals("")) {
			throw new NomeDaPecaNuloOuVazioException(msg);
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
	 * @throws NomeDoItemNuloOuVazioException Caso o nomeItem seja invalido
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
	 * @throws PrecoInvalidoException Caso o preco seja invalido
	 * @throws ClassificacaoNulaOuVaziaException Caso a Classificacao seja nula ou vazia
	 * @throws ClassificacaoInvalidaException Caso a classificacao seja invalida
	 * @throws GeneroNuloOuVazioException Caso o genero seja nulo ou vazio
	 * @throws AnoDeLancamentoMenorQue0Exception caso o ano de lancamento seja menor que 0
	 */
	public static void validaCadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero,
			String classificacao, int anoLancamento) throws NomeDoItemNuloOuVazioException, DuracaoInvalidaException, 
			PrecoInvalidoException, ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException, 
			GeneroNuloOuVazioException, AnoDeLancamentoMenorQue0Exception {
		String msg = "Erro ao cadastrar BluRay de Filme: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);

		if (genero == null || genero.trim().equals("")) {
			throw new GeneroNuloOuVazioException(msg);
		}
		if (anoLancamento < 0) {
			throw new AnoDeLancamentoMenorQue0Exception();
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
	 * @throws NomeDoItemNuloOuVazioException Caso o nomeItem seja invalido
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
	 * @throws PrecoInvalidoException Caso o preco seja invalido
	 * @throws ClassificacaoNulaOuVaziaException Caso a Classificacao seja nula ou vazia
	 * @throws ClassificacaoInvalidaException Caso a classificacao seja invalida
	 * @throws NumeroDeFaixasMenorQue0Exception Caso o numero de faixas seja menor do que 1
	 * @throws NomeDoArtistaNuloOuVazioException Caso o nome do artista seja nulo ou vazio
	 */
	public static void validaCadastrarBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) throws NomeDoItemNuloOuVazioException, DuracaoInvalidaException, 
			PrecoInvalidoException, ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException, 
			NumeroDeFaixasMenorQue0Exception, NomeDoArtistaNuloOuVazioException {
		String msg = "Erro ao cadastrar BluRay de Show: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);

		if (numeroFaixas < 1) {
			throw new NumeroDeFaixasMenorQue0Exception();
		}
		if (artista == null || artista.trim().equals("")) {
			throw new NomeDoArtistaNuloOuVazioException();
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
	 * @throws NomeDoItemNuloOuVazioException Caso o nome do Item seja invalido
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
	 * @throws PrecoInvalidoException Caso o preco seja invalido
	 * @throws DescricaoInvalidaException Caso a descricao seja invalida
	 * @throws TemporadaMenorQue1Exception Caso a temporada seja menor do que 1
	 * @throws GeneroNuloOuVazioException Caso o genero seja nulo ou vazio
	 * @throws ClassificacaoNulaOuVaziaException Caso a classificacao seja nula ou vazia
	 * @throws ClassificacaoInvalidaException Caso a classificacao seja invalida
	 */
	public static void validaCadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) throws NomeDoItemNuloOuVazioException, 
			DuracaoInvalidaException, PrecoInvalidoException, GeneroNuloOuVazioException, TemporadaMenorQue1Exception,
			DescricaoInvalidaException, ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException {
		String msg = "Erro ao cadastrar BluRay de Serie: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);

		if (descricao == null || descricao.trim().equals("")) {
			throw new DescricaoInvalidaException();
		}
		if (genero == null || genero.trim().equals("")) {
			throw new GeneroNuloOuVazioException();
		}
		if (temporada < 1) {
			throw new TemporadaMenorQue1Exception();
		}
	}

	/**
	 * Valida o genero de um BluRay
	 * 
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
	 * @throws NomeDoItemNuloOuVazioException Caso o nome do item seja nulo ou vazio
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
	 */
	public static void validaAdicionarBluRay(String nomeBlurayTemporada, int duracao) 
			throws IllegalArgumentException, NomeDoItemNuloOuVazioException, DuracaoInvalidaException {
		String msg = "Erro ao adicionar BluRay: ";

		if (nomeBlurayTemporada == null || nomeBlurayTemporada.trim().equals("")) {
			throw new NomeDoItemNuloOuVazioException(msg);
		}
		if (duracao < 0) {
			throw new DuracaoInvalidaException(msg);
		}
	}

	/**
	 * Valida uma atualizacao de item
	 * @param atributo O atributo que sera atualizado
	 * @param valor O novo valor do atributo
	 * @throws NomeDoItemNuloOuVazioException Caso o nome do item seja nulo ou vazio
	 * @throws NumeroDeFaixasMenorQue0Exception Caso o numero de faixas seja menor do que 1
 	 * @throws PrecoInvalidoException Caso o preco seja invalido
	 * @throws PlataformaNullOuVaziaException Caso a plataforma seja nula ou vazia
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
 	 * @throws ClassificacaoNulaOuVaziaException Caso a classificacao seja nula ou vazia
	 * @throws GeneroNuloOuVazioException Caso o genero seja nulo ou vazio
	 * @throws AnoDeLancamentoMenorQue0Exception Caso o ano de lancamento seja menor que 0
	 * @throws NomeDoArtistaNuloOuVazioException Caso o nome do artista seja nulo ou vazio
	 * @throws AtributoInvalidoException Caso o atributo seja invalido
	 * @throws DescricaoInvalidaException Caso a descricao seja invalida
	 * @throws TemporadaMenorQue1Exception Caso a temporada seja menor do que 1
	 */
	public static void validaAtualizarItem(String atributo, String valor) throws IllegalArgumentException,
	NomeDoItemNuloOuVazioException, NumeroDeFaixasMenorQue0Exception, PrecoInvalidoException, 
	PlataformaNullOuVaziaException, DuracaoInvalidaException, ClassificacaoNulaOuVaziaException, 
	GeneroNuloOuVazioException, AnoDeLancamentoMenorQue0Exception, NomeDoArtistaNuloOuVazioException, 
	AtributoInvalidoException, DescricaoInvalidaException, TemporadaMenorQue1Exception {
		String msg = "Erro na atualizacao de item: ";

		if (atributo.trim().equalsIgnoreCase("nome")) {
			if (valor == null || valor.trim().equals("")) {
				throw new NomeDoItemNuloOuVazioException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("preco")) {
			if (Double.parseDouble(valor) < 0) {
				throw new PrecoInvalidoException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("plataforma")) {
			if (valor == null || valor.trim().equals("")) {
				throw new PlataformaNullOuVaziaException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("duracao")) {
			if (Integer.parseInt(valor) < 0) {
				throw new DuracaoInvalidaException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("classificacao")) {
			if (valor == null || valor.trim().equals("")) {
				throw new ClassificacaoNulaOuVaziaException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("genero")) {
			if (valor == null || valor.trim().equals("")) {
				throw new GeneroNuloOuVazioException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("anoLancamento")) {
			if (Integer.parseInt(valor) < 0) {
				throw new AnoDeLancamentoMenorQue0Exception(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("artista")) {
			if (valor == null || valor.trim().equals("")) {
				throw new NomeDoArtistaNuloOuVazioException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("numeroFaixas")) {
			if (Integer.parseInt(valor) < 1) {
				throw new NumeroDeFaixasMenorQue0Exception(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("descricao")) {
			if (valor == null || valor.trim().equals("")) {
				throw new DescricaoInvalidaException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("temporada")) {
			if (Integer.parseInt(valor) < 0) {
				throw new TemporadaMenorQue1Exception(msg);
			}
		} else {
			throw new AtributoInvalidoException();
		}
	}

	/**
	 * Valida um BluRay
	 * 
	 * @param duracao A duracao do BluRay
	 * @param classificacao A classificacao etaria do BluRay
	 * @param msg A msg que sera exibida na excecao
	 * @throws DuracaoInvalidaException Caso a duracao seja invalida
	 * @throws ClassificacaoNulaOuVaziaException Caso a classificacao seja vazia ou nula 
	 * @throws ClassificacaoInvalidaException Caso a classificacao seja invalida
	 */
	private static void validaBluRay(int duracao, String classificacao, String msg) 
			throws DuracaoInvalidaException, ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException {

		if (duracao < 0) {
			throw new DuracaoInvalidaException(msg);
		}
		validaClassificacao(classificacao, msg);
	}
	
	/**
	 * Valida a classificacao
	 * 
	 * @param classificacao A classificacao a ser validada
	 * @param msg mensagem de erro para o cadastro do BluRay que está sendo feito
	 * @throws ClassificacaoNulaOuVaziaException Caso a classificacao seja vazia ou nula 
	 * @throws ClassificacaoInvalidaException Caso a classificacao seja invalida
	 */
	private static void validaClassificacao(String classificacao, String msg) 
			throws ClassificacaoNulaOuVaziaException, ClassificacaoInvalidaException{
		if (classificacao == null || classificacao.trim().equals("")) {
			throw new ClassificacaoNulaOuVaziaException(msg);
		}
		if (!classificacoes.contains(classificacao)) {
			throw new ClassificacaoInvalidaException();
		}
	}

	/**
	 * Valida um item
	 * 
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param msg A msg que sera exibida na excecao
	 * @throws NomeDoItemNuloOuVazioException Caso o nome do Item seja nulo ou vazio ou caso o preco seja invalido
	 * @throws PrecoInvalidoException Caso o preco seja invalido
	 */
	private static void validaItem(String nomeItem, double preco, String msg) 
			throws NomeDoItemNuloOuVazioException, PrecoInvalidoException {
		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new NomeDoItemNuloOuVazioException();
		}
		if (preco < 0) {
			throw new PrecoInvalidoException();
		}
	}

	/**
	 * Valida o nome de um usuario
	 * 
	 * @param nome O nome do usuario
	 * @return true se o nome eh valido
	 * @throws StringInvalidaException Caso o nome seja nulo ou vazio
	 */
	private static boolean validaNome(String nome) throws StringInvalidaException {
		if (nome == null) {
			throw new StringInvalidaException("Nome nao pode ser null.");
		}
		if (nome.trim().equals("")) {
			throw new StringInvalidaException("Nome nao pode ser vazio.");
		}
		return true;
	}

	/**
	 * Valida o telefone de um usuario
	 * 
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
	 * 
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

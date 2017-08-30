package facadeEMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsItem.AnoDeLancamentoMenorQue0Exception;
import exceptionsItem.ClassificacaoInvalidaException;
import exceptionsItem.DuracaoInvalidaException;
import exceptionsItem.NumeroDeFaixasMenorQue0Exception;
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

	private final static String ERRO = "Erro:";
	
	
	/**
	 * Valida o cadastro de um usuario
	 * 
	 * @param nome O nome do usuario
	 * @param telefone O telefone do usuario
	 * @param email O email do usuario
	 * @throws StringInvalidaException Caso alguma string seja invalida
	 */
	public static void validaCadastrarUsuario(String nome, String telefone, String email)
			throws StringInvalidaException {
		validaString(nome, "Nome");
		validaString(telefone, "Telefone");
		validaString(email, "Email");
		validaTelefone(telefone);		
		validaEmail(email);
	}

	/**
	 * Valida a atualizacao de um usuario
	 * 
	 * @param atributo O atributo a ser mudado 
	 * @param valor O novo valor do atributo
	 * @throws StringInvalidaException Caso alguma string seja nula ou vazia
	 */
	public static void validaAtualizarUsuario(String atributo, String valor) throws StringInvalidaException {
		switch (atributo.toLowerCase()) {
		case "nome":
			validaString(valor, "Nome");
			break;
			
		case "email":
			validaString(valor, "Email");
			validaEmail(valor);
			break;
			
		case "telefone":
			validaString(valor, "Telefone");
			validaTelefone(valor);
			break;
		
		default:
			throw new AtributoInvalidoException();
		}
	}
	
	/**
	 * Valida o cadastro de jogos eletronicos
	 * 
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param plataforma A plataforma do jogo
	 * @throws StringInvalidaException 
	 */
	public static void validaCadastrarEletronico(String nomeItem, double preco, String plataforma) throws StringInvalidaException {
		String msg = "Erro ao cadastrar Jogo Eletronico: ";
		validaItem(nomeItem, preco, msg);
		validaPlataforma(plataforma);
	}

	/**
	 * Valida a plataforma 
	 * 
	 * @param plataforma A plataforma do jogo 
	 * @return True se a plataforma existe e False caso contrario
	 * @throws StringInvalidaException 
	 */
	public static boolean validaPlataforma(String plataforma) throws StringInvalidaException {
		validaString(plataforma, "Plataforma");
		return plataformas.contains(plataforma.toUpperCase());
	}

	/**
	 * Valida o cadastro de um jogo de tabuleiro
	 * 
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @throws StringInvalidaException 
	 */
	public static void validaCadastrarJogoTabuleiro(String nomeItem, double preco) throws StringInvalidaException {
		String msg = "Erro ao cadastrar Jogo de Tabuleiro: ";
		validaItem(nomeItem, preco, msg);
	}

	/**
	 * Valida a acao de add uma peca perdida a um jogo
	 * 
	 * @param nomeItem O nome do jogo
	 * @param nomePeca O nome da peca perdida
	 * @throws StringInvalidaException 
	 */
	public static void validaAdicionarPecaPerdida(String nomeItem, String nomePeca) throws StringInvalidaException {
		validaString(nomeItem, "Nome do item");
		validaString(nomePeca, "Nome da peca");
	}

	/**
	 * Valida o cadastro de um filme BluRay
	 * 
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param duracao A duracao do filme
	 * @param genero O genero do filme
	 * @param classificacao A classificacao etaria do filme
	 * @param anoLancamento O ano de lancamento do filme
	 * @throws StringInvalidaException 
	 */
	public static void validaCadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero,
			String classificacao, int anoLancamento) throws StringInvalidaException {
		String msg = "Erro ao cadastrar BluRay de Filme: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);
		validaString(genero, "Genero");
		verificaAnoLancamento(anoLancamento, msg);
	}
	
	/**
	 * Verifica o ano de lancamento de um bluray
	 * 
	 * @param anoLancamento O ano de lancamento
	 * @param msg A msg que sera mostrada com a excecao
	 * @throws AnoDeLancamentoMenorQue0Exception Se o ano de lancamento for um numero negativo
	 */
	private static void verificaAnoLancamento(int anoLancamento, String msg)
			throws AnoDeLancamentoMenorQue0Exception {
		if (anoLancamento < 0) {
			throw new AnoDeLancamentoMenorQue0Exception(msg);
		}
	}

	/**
	 * Valida o cadastro de um show BluRay
	 * 
	 * @param nomeItem O nome do show
	 * @param preco O preco do item
	 * @param duracao A duracao do show
	 * @param numeroFaixas O numero de faixas do show
	 * @param artista O artista do show
	 * @param classificacao A classificacao etaria do show
	 * @throws StringInvalidaException 
	 * @throws IllegalArgumentException Caso o nome seja nulo ou vazio ou o numero de faixas seja invalido
	 */
	public static void validaCadastrarBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) throws StringInvalidaException {
		
		String msg = "Erro ao cadastrar BluRay de Show: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);
		validaString(artista, "Nome do artista");

		if (numeroFaixas < 1) {
			throw new NumeroDeFaixasMenorQue0Exception();
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
	 * @throws StringInvalidaException 
	 * @throws IllegalArgumentException Caso algum parametro seja nulo ou vazio ou a temporada seja invalida
	 */
	public static void validaCadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) throws StringInvalidaException {
		
		String msg = "Erro ao cadastrar BluRay de Serie: ";

		validaItem(nomeItem, preco, msg);
		validaBluRay(duracao, classificacao, msg);
		validaString(descricao, "Descricao");
		validaString(genero, "Genero");

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
	 * @throws StringInvalidaException 
	 */
	public static void validaAdicionarBluRay(String nomeBlurayTemporada, int duracao) 
			throws IllegalArgumentException, StringInvalidaException {
		
		String msg = "Erro ao adicionar BluRay: ";

		validaString(nomeBlurayTemporada, "Nome do item");
		if (duracao < 0) {
			throw new DuracaoInvalidaException(msg);
		}
	}

	/**
	 * Valida uma atualizacao de item
	 * @param atributo O atributo que sera atualizado
	 * @param valor O novo valor do atributo
	 * @throws StringInvalidaException 
	 */
	public static void validaAtualizarItem(String atributo, String valor) throws IllegalArgumentException,
	StringInvalidaException {
		
		String msg = "Erro na atualizacao de item: ";

		switch(atributo.toLowerCase()) {
		case "nome":
			validaString(valor, "Nome do item");
			break;
			
		case "preco":
			if (Double.parseDouble(valor) < 0) {
				throw new PrecoInvalidoException(msg);
			}
			break;
			
		case "plataforma":
			validaString(valor, "Plataforma");
			break;
			
		case "duracao":
			if (Integer.parseInt(valor) < 0) {
				throw new DuracaoInvalidaException(msg);
			}
			break;
			
		case "classificacao":
			validaString(valor, "Classificacao");
			break;
			
		case "genero":
			validaString(valor, "Genero");
			break;
			
		case "ano de lancamento":
			verificaAnoLancamento(Integer.parseInt(valor), msg);
			break;
			
		case "nome do artista":
			validaString(valor, "Nome do artista");
			break;
			
		case "numero de faixas":
			if (Integer.parseInt(valor) < 1) {
				throw new NumeroDeFaixasMenorQue0Exception(msg);
			}
			break;
			
		case "descricao":
			validaString(valor, "Descricao");
			break;
			
		case "temporada":
			if (Integer.parseInt(valor) < 0) {
				throw new TemporadaMenorQue1Exception(msg);
			}
			break;
			
		default:
			throw new AtributoInvalidoException();
		}
	}
	
	/**
	 * Valida um BluRay
	 * 
	 * @param duracao A duracao do BluRay
	 * @param classificacao A classificacao etaria do BluRay
	 * @param msg A msg que sera exibida na excecao
	 * @throws StringInvalidaException 
	 */
	private static void validaBluRay(int duracao, String classificacao, String msg) 
			throws StringInvalidaException, DuracaoInvalidaException {

		validaClassificacao(classificacao, msg);
		if (duracao < 0) {
			throw new DuracaoInvalidaException(msg);
		}
		
	}
	
	/**
	 * Valida a classificacao
	 * 
	 * @param classificacao A classificacao a ser validada
	 * @param msg mensagem de erro para o cadastro do BluRay que está sendo feito
	 * @throws StringInvalidaException 
	 */
	private static void validaClassificacao(String classificacao, String msg) throws StringInvalidaException, ClassificacaoInvalidaException {
		
		validaString(classificacao, "Classificacao");
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
	 * @throws StringInvalidaException 
	 */
	private static void validaItem(String nomeItem, double preco, String msg) 
			throws StringInvalidaException {
		
		validaString(nomeItem, "Nome do item");
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
	private static void validaString(String parametro, String atributo) throws StringInvalidaException {
		if (parametro == null) {
			throw new StringInvalidaException(atributo + " nao pode ser null.");
		}
		if (parametro.trim().equals("")) {
			throw new StringInvalidaException(atributo + " nao pode ser vazio.");
		}
	}

	/**
	 * Valida o telefone de um usuario
	 * 
	 * @param telefone O telefone do usuario
	 * @return true se o telefone eh valido e false caso contrario
	 * @throws TelefoneInvalidoException 
	 */
	private static void validaTelefone(String telefone) throws TelefoneInvalidoException {
		int hifen = 0;
		if ((telefone.length()) > 10 || telefone.length() < 8) {
			throw new TelefoneInvalidoException(ERRO);
		}
		if (telefone.charAt(0) == '-' || telefone.charAt(telefone.length() - 1) == '-') {
			throw new TelefoneInvalidoException(ERRO);		}
		for (int i = 0; i < telefone.length() - 1; i++) {
			if (telefone.charAt(i) == '-') {
				hifen++;
			}
		}

		if (hifen > 1) {
			throw new TelefoneInvalidoException(ERRO);		
		}
	}
	
	/**
	 * Valida o email do usuario
	 * 
	 * @param email O email do usuario
	 * @return true se o email eh valido e false caso contrario
	 * @throws EmailInvalidoException 
	 */
	private static void validaEmail(String email) throws EmailInvalidoException {
		int arrobas = 0;
		int pontos = 0;

		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@' 
				|| email.charAt(email.length() - 1) == '.') {
			throw new EmailInvalidoException(ERRO);
		}
		
		for (int i = 0; i < email.length() - 1; i++) {
			if (email.charAt(i) == ' ') {
				throw new EmailInvalidoException(ERRO);
			} else if (email.charAt(i) == '@') {
				arrobas++;
			} else if (email.charAt(i) == '.' && arrobas == 1) {
				pontos++;
				if (email.charAt(i + 1) == '.') {
					throw new EmailInvalidoException(ERRO);
				}
			}
		}
		
		if (arrobas != 1 || pontos < 1) {
			throw new EmailInvalidoException(ERRO);
		}
	}

}
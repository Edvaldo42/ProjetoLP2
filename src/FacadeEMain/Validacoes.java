package FacadeEMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exception.EmailInvalidoException;
import exception.NomeInvalidoException;
import exception.StringInvalidaException;
import exception.TelefoneInvalidoException;

public class Validacoes {

	private static List<String> plataformas = new ArrayList<>(
			Arrays.asList("PC", "MAC", "PS3", "PS4", "XBOX360", "XBOX_ONE", "NINTENDO_3DS"));

	private static List<String> classificacoes = new ArrayList<>(
			Arrays.asList("LIVRE", "DEZ_ANOS", "DOZE_ANOS", "QUATORZE_ANOS", "DEZESSEIS_ANOS", "DEZOITO_ANOS"));

	private static List<String> generos = new ArrayList<>(
			Arrays.asList("ACAO", "ANIMACAO", "AVENTURA", "COMEDIA", "DOCUMENTARIO", "DRAMA", "EROTICO", "FAROESTE",
					"FICCAO", "MUSICAL", "POLICIAL", "ROMANCE", "SUSPENSE", "TERROR"));

	public static void validaCadastrarUsuario(String nome, String telefone, String email)
			throws StringInvalidaException {
		String msg = "Erro ao cadastrar usuario: ";

		if (!validaNome(nome)) {
			throw new NomeInvalidoException(msg);
		}
		if (!validaEmail(email)) {
			throw new EmailInvalidoException(msg);
		}
		if (!validaTelefone(telefone)) {
			throw new TelefoneInvalidoException(msg);
		}
	}

	public static void validaAtualizarUsuario(String atributo, String valor) throws StringInvalidaException {
		String msg = "Erro ao atualizar usuario: ";

		if (atributo.trim().equalsIgnoreCase("nome")) {
			if (!validaNome(valor)) {
				throw new NomeInvalidoException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("email")) {
			if (!validaEmail(valor)) {
				throw new EmailInvalidoException(msg);
			}
		} else if (atributo.trim().equalsIgnoreCase("telefone")) {
			if (!validaTelefone(valor)) {
				throw new TelefoneInvalidoException(msg);
			}
		}

		else {
			throw new IllegalArgumentException("Atributo invalido");
		}

	}

	public static void validaCadastrarEletronico(String nomeItem, double preco, String plataforma) {
		String msg = "Erro ao cadastrar Jogo Eletronico: ";

		validaItem(nomeItem, preco, msg);

		if (plataforma == null || plataforma.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Plataforma nao pode ser nula ou vazia");
		}
	}

	public static boolean validaPlataforma(String plataforma) {
		boolean existe = false;

		if (plataformas.contains(plataforma.toUpperCase())) {
			existe = true;
		}

		return existe;
	}

	public static void validaCadastrarJogoTabuleiro(String nomeItem, double preco) {
		String msg = "Erro ao cadastrar Jogo de Tabuleiro: ";
		validaItem(nomeItem, preco, msg);
	}

	public static void validaAdicionarPecaPerdida(String nomeItem, String nomePeca) {
		String msg = "Erro ao adicionar Peca Perdida: ";

		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Nome do item nao pode ser nulo ou vazio");
		}
		if (nomePeca == null || nomePeca.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Nome da peca nao pode ser nulo ou vazio");
		}
	}

	public static void validaCadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero,
			String classificacao, int anoLancamento) {
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

	public static void validaCadastrarBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) {
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

	public static void validaCadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) {
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

	public static boolean validaGenero(String genero) {
		boolean existe = false;

		if (generos.contains(genero.toUpperCase())) {
			existe = true;
		}

		return existe;
	}

	public static void validaAdicionarBluRay(String nomeBlurayTemporada, int duracao) {
		String msg = "Erro ao adicionar BluRay: ";

		if (nomeBlurayTemporada == null || nomeBlurayTemporada.trim().equals("")) {
			throw new IllegalArgumentException(msg + "Nome do item nao pode ser nulo ou vazio");
		}
		if (duracao < 0) {
			throw new IllegalArgumentException(msg + "Duracao nao pode ser menor do que 0");
		}
	}

	public static void validaAtualizarItem(String atributo, String valor) {
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

	private static void validaBluRay(int duracao, String classificacao, String msg) {

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

	private static void validaItem(String nomeItem, double preco, String msg) {
		if (nomeItem == null || nomeItem.trim().equals("")) {
			throw new IllegalArgumentException("Nome do item nao pode ser nulo ou vazio");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	private static boolean validaNome(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Nome nao pode ser null.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Nome nao pode ser vazio.");
		}
		return true;
	}

	private static boolean validaTelefone(String telefone) {
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

	private static boolean validaEmail(String email) {
		int arrobas = 0;
		int pontos = 0;

		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@'
				|| email.charAt(email.length() - 1) == '.')
			return false;
		for (int i = 0; i < email.length() - 1; i++) {
			if (email.charAt(i) == ' ') {
				return false;
			} else if (email.charAt(i) == '@') {
				arrobas++;
				if (email.charAt(i + 1) == '@')
					return false;
			} else if (email.charAt(i) == '.' && arrobas == 1) {
				pontos++;
				if (email.charAt(i + 1) == '.')
					return false;
			}

		}
		if (arrobas != 1 || pontos < 1)
			return false;

		return true;
	}

}

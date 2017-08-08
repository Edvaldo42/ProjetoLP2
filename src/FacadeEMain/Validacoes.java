package FacadeEMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validacoes {

	private List<String> plataformas = new ArrayList<>(Arrays.asList("PC", "MAC",
			"PS3", "PS4", "XBOX360", "XBOX_ONE", "NINTENDO_3DS", "OUTRO"));
	
	private List<String> generos = new ArrayList<>(Arrays.asList("ACAO", "ANIMACAO", "AVENTURA", "COMEDIA", "DOCUMENTARIO",
			"DRAMA", "EROTICO", "FAROESTE", "FICCAO", "MUSICAL", "POLICIAL", "ROMANCE", "SUSPENSE",	"TERROR")); 
	
	public static void validaCadastrarUsuario(String nome, String telefone, String email) {

		String msg = "Erro ao cadastrar usuario: ";
		if (!validaNome(nome)) {
			throw new IllegalArgumentException(msg + "Nome invalido");
		}
		if (!validaEmail(email)) {
			throw new IllegalArgumentException(msg + "Email invalido");
		}
		if (!validaTelefone(telefone)) {
			throw new IllegalArgumentException(msg + "Telefone invalido");
		}
	}

	public static void validaAtualizarUsuario(String atributo, String valor) {

		String msg = "Erro ao atualizar usuario: ";

		if (atributo.trim().equalsIgnoreCase("nome")) {
			if (!validaNome(valor)) {
				throw new IllegalArgumentException(msg + "Nome invalido");
			}
		}
		if (atributo.trim().equalsIgnoreCase("telefone")) {
			if (!validaTelefone(valor)) {
				throw new IllegalArgumentException(msg + "Telefone invalido");
			}
		}

		if (atributo.trim().equalsIgnoreCase("email")) {
			if (!validaEmail(valor)) {
				throw new IllegalArgumentException(msg + "Email invalido");
			}
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
		
		if (plataforma.contains(plataforma.toUpperCase())) {
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

	public static void validaCadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		String msg = "Erro ao cadastrar BluRay de Filme: ";
		
		validaItem(nomeItem, preco, msg);
		
		if (duracao < 0) {
			throw new IllegalArgumentException("Duracao nao pode ser menor do que 0");
		}
	}
	
	private static void validaBluRay(int duracao) {
		
		if (duracao < 0) {
			throw new IllegalArgumentException("Duracao nao pode ser menor do que 0");
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
			throw new IllegalArgumentException("Usuario nao pode ser null.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Usuario nao pode ser vazio.");
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

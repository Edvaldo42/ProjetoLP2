package usuario;

import java.util.HashSet;
import java.util.Set;

import item.Filme;
import item.Item;
import item.JogoDeTabuleiro;
import item.JogoEletronico;
import item.Serie;
import item.Show;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private Set<Item> itens;

	public Usuario(String nome, String telefone, String email) {
		if (!validaNome(nome)) {
			throw new IllegalArgumentException("Nome invalido");
		}

		if (!validaEmail(email)) {
			throw new IllegalArgumentException("Email invalido");
		}
		if (!validaTelefone(telefone)) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		itens = new HashSet<>();
	}

	public void cadastraEletronico(String nomeItem, double preco, String plataforma) {
		Item itemACadastrar = new JogoEletronico(nomeItem, preco, plataforma);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void cadastraJogoTabuleiro(String nomeItem, double preco) {
		Item itemACadastrar = new JogoDeTabuleiro(nomeItem, preco);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		Item itemBuscado = buscaItem(nomeItem);
		if (itemBuscado.getNomeDoItem().equalsIgnoreCase(nomeItem)
				&& itemBuscado.getClass().getName().equals("JogoDeTabuleiro")) {
			itemBuscado.adicionarPecaPerdida(nomePeca);
		}
	}

	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		Item itemACadastrar = new Filme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, int nomeroFaixas, String artista,
			String classificacao) {
		Item itemACadastrar = new Show(nomeItem, preco, duracao, classificacao, nomeroFaixas, artista);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		Item itemACadastrar = new Serie(nomeItem, preco, duracao, classificacao, genero, temporada);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) {
		Item itemBuscado = buscaItem(nomeBlurayTemporada);

	}

	public void removerItem(String nomeItem) {
		sistema.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nomeItem, String atributo, double preco) {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, preco);
	}

	public String detalhesItem(String nomeItem) {
		if (itens.contains(nomeItem) == false) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		return buscaItem(nomeItem).toString();
	}
	
	private Item buscaItem(String nomeItem) {

		for (Item item : itens) {
			if (item.getNomeDoItem().equals(nomeItem)) {

				return item;
			}
		}
		throw new IllegalArgumentException("Item nao cadastrado");
	}

	private boolean verificaItem(Item itemACadastrar) {
		if (itens.contains(itemACadastrar)) {
			throw new IllegalArgumentException("Item ja cadastrado");
		}
		return false;
	}

	private boolean validaNome(String nome) {
		if (nome == null) {
			throw new IllegalArgumentException("Usuario nao pode ser null.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Usuario nao pode ser vazio.");
		}
		return true;
	}

	private boolean validaTelefone(String telefone) {
		int hifen = 0;
		if (telefone == null) {
			throw new IllegalArgumentException("Telefone nao pode ser null.");
		}
		if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("telefone nao pode ser vazio.");
		}
		if ((telefone.length()) > 10 || telefone.length() < 9) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		if (!(telefone.charAt(5) == '-')) {
			throw new IllegalArgumentException("Telefone invalido");
		}
		if (telefone.charAt(0) == '-' || telefone.charAt(telefone.length() - 1) == '-') {
			throw new IllegalArgumentException("Telefone invalido");
		}
		if (telefone.charAt(5) == '-') {
			hifen++;
		}
		for (int i = 0; i < telefone.length() - 1; i++) {
			if (telefone.charAt(i) == ' ') {
				throw new IllegalArgumentException("Telefone invalido");
			}
			if (telefone.charAt(i) == '-' && i != 5) {
				throw new IllegalArgumentException("Telefone invalido");
			}
		}

		if (hifen != 1) {
			return false;
		}
		return true;
	}

	private boolean validaEmail(String email) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validaEmail(email);
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (validaNome(nome)) {
			this.nome = nome;
		}

	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (validaTelefone(telefone)) {
			this.telefone = telefone;
		}

	}


	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

}
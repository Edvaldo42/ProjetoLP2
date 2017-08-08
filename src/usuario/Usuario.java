package usuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
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
	private Locale locale = new Locale("en", "US");
	private NumberFormat nf = NumberFormat.getInstance(locale);

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
		if (itemBuscado instanceof JogoDeTabuleiro) {
			((JogoDeTabuleiro) itemBuscado).adicionaPecaPerdida(nomePeca);
		}
	}

	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		Item itemACadastrar = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		Item itemACadastrar = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		Item itemACadastrar = new Serie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);

		if (!verificaItem(itemACadastrar)) {
			itens.add(itemACadastrar);
		}
	}

	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) {
		Item itemBuscado = buscaItem(nomeBlurayTemporada);
		
		if (itemBuscado instanceof Serie) {
			itemBuscado.adicionarBluRay(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao e uma serie");
		}
	}

	public void removerItem(String nomeItem) {
		Item itemARemover = buscaItem(nomeItem);

		if (verificaItem(itemARemover)) {
			itens.remove(itemARemover);
		}
	}

	public void atualizarItem(String nomeItem, String atributo, String valor) {
		Item item = buscaItem(nomeItem);
		
		if (verificaItem(item)) {
			if (atributo.trim().equalsIgnoreCase("nome")) {
				item.setNomeItem(valor);
			}
			else if (atributo.trim().equalsIgnoreCase("preco")) {		
				item.setPreco(Double.parseDouble(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("email")) {
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
			else { 
				throw new IllegalArgumentException("Atributo invalido");
			}
		}
		else {
			throw new IllegalArgumentException("Item nao cadastrado");
		}
	}

	public String detalhesItem(String nomeItem) {
		if (itens.contains(nomeItem) == false) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		return buscaItem(nomeItem).toString();
	}
	public String getInfoItem(String nomeItem, String atributo) {
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

	private Item buscaItem(String nomeItem) {

		for (Item item : itens) {
			if (item.getNomeDoItem().equals(nomeItem)) {

				return item;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}
	

	private boolean verificaItem(Item item) {
		if (itens.contains(item)) {
			return true;
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

	public List<Item> getItens() {
		List<Item> listaItens = new ArrayList<>(itens);
		return listaItens;
	}
	
	
	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

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

}
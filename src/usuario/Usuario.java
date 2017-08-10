package usuario;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import exception.ItemNaoEncontradoException;
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
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		itens = new HashSet<>();
	}

	public void cadastraEletronico(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}

	public void cadastraJogoTabuleiro(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) throws ItemNaoEncontradoException {
		Item itemBuscado = buscaItem(nomeItem);
		if (itemBuscado.getClass().getName().equals("JogoDeTabuleiro")) {
			itemBuscado.adicionarPecaPerdida(nomePeca);
		}
	}

	public void cadastrarBluRayFilme(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}

	public void cadastrarBluRayShow(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}

	public void cadastrarBluRaySerie(Item item) {
		if (!verificaItem(item)) {
			itens.add(item);
		}
	}

	public void adicionarBluRay(String nomeBlurayTemporada, int duracao) throws ItemNaoEncontradoException {
		Item itemBuscado = buscaItem(nomeBlurayTemporada);
		
		if (itemBuscado instanceof Serie) {
			itemBuscado.adicionarBluRay(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao e uma serie");
		}
	}

	public void removerItem(String nomeItem) throws ItemNaoEncontradoException {
		Item itemARemover = buscaItem(nomeItem);

		if (verificaItem(itemARemover)) {
			itens.remove(itemARemover);
		}
	}

	public void atualizarItem(String nomeItem, String atributo, String valor) throws ItemNaoEncontradoException {
		Item item = buscaItem(nomeItem);
		
		if (verificaItem(item)) {
			if (atributo.trim().equalsIgnoreCase("nome")) {
				item.setNomeItem(valor);
			}
			else if (atributo.trim().equalsIgnoreCase("preco")) {		
				item.setPreco(Double.parseDouble(valor));
			}
			else if (atributo.trim().equalsIgnoreCase("classificacao")) {
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
		}
		else {
			throw new IllegalArgumentException("Item nao cadastrado");
		}
	}

	public String detalhesItem(String nomeItem) throws ItemNaoEncontradoException {
		if (itens.contains(nomeItem) == false) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		return buscaItem(nomeItem).toString();
	}
	
	public String getInfoItem(String nomeItem, String atributo) throws ItemNaoEncontradoException {
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

	private Item buscaItem(String nomeItem) throws ItemNaoEncontradoException {

		for (Item item : itens) {
			if (item.getNomeDoItem().equals(nomeItem)) {
				return item;
			}
		}
		throw new ItemNaoEncontradoException();
	}
	

	private boolean verificaItem(Item item) {
		if (itens.contains(item)) {
			return true;
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public List<Item> getItens() {
		List<Item> listaItens = new ArrayList<>(itens);
			return listaItens;
	}

}
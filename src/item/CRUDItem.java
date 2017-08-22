package item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exception.ItemNaoEncontradoException;
import exception.PlataformaNullOuVaziaException;
import exception.TemporadaMenorQue1Exception;
import facadeEMain.Validacoes;

/**
 * 
 *
 */
public class CRUDItem {

	List<Item> itensDoSistema;

	/**
	 * Construtor do CRUDItem
	 * Inicia a lista de itens no CRUD de itens
	 */
	public CRUDItem() {
		itensDoSistema = new ArrayList<>();
	}

	/**
	 * Cria o item jogo eletronico
	 * 
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @param plataforma A plataforma em que o jogo esta
	 * @return O item criado
	 * @throws PlataformaNullOuVaziaException 
	 */
	public Item criaEletronico(String nomeItem, double preco, String plataforma) throws PlataformaNullOuVaziaException {
		if (Validacoes.validaPlataforma(plataforma)) {
			Item jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
			return jogoEletronico;
		}
		
		Item jogoEletronico = new JogoEletronico(nomeItem, preco, "OUTRO");
		return jogoEletronico;
	}

	/**
	 * Cria o item jogo de tabuleiro
	 * 
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @return O item criado										
	 */
	public static Item criaJogoTabuleiro(String nomeItem, double preco) {
		Item jogoTabuleiro = new JogoDeTabuleiro(nomeItem, preco);
		return jogoTabuleiro;
	}
	
	/**
	 * Cria um item BluRay de filme
	 * 
	 * @param nomeItem O nome do filme
	 * @param preco O preco do filme
	 * @param duracao A duracao do filme
	 * @param genero O genero do filme
	 * @param classificacao A classificacao etaria para o filme
	 * @param anoLancamento O ano de lancamento do filme
	 * @return O item criado
	 */
	public static Item criaBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		if (Validacoes.validaGenero(genero)) {
			Item filme = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
			return filme;
		}
		
		Item filme = new Filme(nomeItem, preco, duracao, "OUTRO", classificacao, anoLancamento);
		return filme;
	}

	/**
	 * Cria um item BluRay de show
	 * 
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param duracao A duracao da temporada
	 * @param numeroFaixas O numero de faixas do show
	 * @param artista O nome do artista
	 * @param classificacao A classificacao etaria para o show
	 * @return O item criado
	 */
	public static Item criaBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		Item show = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		return show;
	}

	/**
	 * Cria um item BluRay de serie
	 * 
	 * @param nomeItem O nome do item
	 * @param preco O preco do item
	 * @param descricao A descricao da temporada
	 * @param duracao A duracao da temporada 
	 * @param classificacao A classificacao etaria para a serie
	 * @param genero O genero da serie
	 * @param temporada A temporada da serie
	 * @return O item criado
	 */
	public static Item criaBluRaySerie(String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) {

		if (Validacoes.validaGenero(genero)) {
			Item serie = new Serie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
			return serie;
		}
	
		Item serie = new Serie(nomeItem, preco, descricao, duracao, classificacao, "OUTRO", temporada);
		return serie;
	}
	
	
	public static String getInfoItem(Item item, String atributo) {
		String info = "";
		if (atributo.trim().equalsIgnoreCase("preco")) {
			info += item.getPreco();
		} 
		else if (atributo.trim().equalsIgnoreCase("peca perdida")) {
			info = item.getPecasPerdidas();
		}
		else if (atributo.trim().equalsIgnoreCase("nome")) {
			info = item.getNomeDoItem();
		}
		else if (atributo.trim().equalsIgnoreCase("plataforma")) {
			info = item.getPlataforma();
		}
		else if (atributo.trim().equalsIgnoreCase("duracao")) {
			info += item.getDuracao();
		}
		else if (atributo.trim().equalsIgnoreCase("genero")) {
			info += item.getGenero();
		}
		else if (atributo.trim().equalsIgnoreCase("classificacao")) {
			info += item.getClassificacao();
		}
		else if (atributo.trim().equalsIgnoreCase("ano de lancamento")) {
			info += item.getAnoLancamento();
		}
		return info;
	}
	
	public static void atualizarItem(Item item, String atributo, String valor) throws TemporadaMenorQue1Exception, NumberFormatException {
		if (atributo.trim().equalsIgnoreCase("nome")) {
			item.setNomeItem(valor);
		} else if (atributo.trim().equalsIgnoreCase("preco")) {
			item.setPreco(Double.parseDouble(valor));
		} else if (atributo.trim().equalsIgnoreCase("classificacao")) {
			item.setClassificacao(valor);
		} else if (atributo.trim().equalsIgnoreCase("duracao")) {
			item.setDuracao(Integer.parseInt(valor));
		} else if (atributo.trim().equalsIgnoreCase("genero")) {
			item.setGenero(valor);
		} else if (atributo.trim().equalsIgnoreCase("anoLancamento")) {
			item.setAnoLancamento(Integer.parseInt(valor));
		} else if (atributo.trim().equalsIgnoreCase("artista")) {
			item.setNomeArtista(valor);
		} else if (atributo.trim().equalsIgnoreCase("numeroFaixas")) {
			item.setNumeroFaixas(Integer.parseInt(valor));
		} else if (atributo.trim().equalsIgnoreCase("temporada")) {
			item.setTemporada(Integer.parseInt(valor));
		} else if (atributo.trim().equalsIgnoreCase("plataforma")) {
			item.setPlataforma(valor);
		}
	}

	public static void removerItem(Item item, Set<Item> itens) {
		itens.remove(item);
	}
	
}

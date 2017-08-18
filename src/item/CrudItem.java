package item;

import java.util.ArrayList;
import java.util.List;

import facadeEMain.Validacoes;

/**
 * 
 *
 */
public class CrudItem {

	List<Item> itensDoSistema;

	/**
	 * Construtor do CRUDItem
	 * Inicia a lista de itens no CRUD de itens
	 */
	public CrudItem() {
		itensDoSistema = new ArrayList<>();
	}

	/**
	 * Cria o item jogo eletronico
	 * 
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 * @param plataforma A plataforma em que o jogo esta
	 * @return O item criado
	 */
	public Item criaEletronico(String nomeItem, double preco, String plataforma) {
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
}

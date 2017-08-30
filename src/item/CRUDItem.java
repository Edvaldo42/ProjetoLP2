package item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exceptionsComplementares.AtributoInvalidoException;
import exceptionsComplementares.StringInvalidaException;
import exceptionsItem.TemporadaMenorQue1Exception;
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
	 * @throws StringInvalidaException 
	 */
	public static Item criaEletronico(String nomeItem, double preco, String plataforma) throws StringInvalidaException {
		
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
	public static Item criaBluRayFilme(String nomeItem, double preco, int duracao, String genero, 
			String classificacao, int anoLancamento) {
		
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
	public static Item criaBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) {
		
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
	
	/**
	 * Retorna uma informacao, passado atraves do atributo, sobre um item
	 * 
	 * @param item O item a ser consultado
	 * @param atributo A informacao a qual se quer saber 
	 * @return Uma informacao , passado atraves do atributo sobre um item
	 */
	public static String getInfoItem(Item item, String atributo) throws AtributoInvalidoException {
		
		switch (atributo.toLowerCase()) {
		case "preco":
			return String.valueOf(item.getPreco());
			
		case "peca perdida":
			return item.getPecasPerdidas();
		
		case "nome":
			return item.getNomeDoItem();
		
		case "plataforma":
			return item.getPlataforma();
		
		case "duracao":
			return String.valueOf(item.getDuracao());
		
		case "genero":
			return item.getGenero();
		
		case "classificacao":
			return item.getClassificacao();
		
		case "ano de lancamento":
			return String.valueOf(item.getAnoLancamento());
			
		case "descricao":
			return item.getDescricao();
			
		case "nome do artista":
			return item.getNomeArtista();
			
		case "temporada":
			return String.valueOf(item.getTemporada());
			
		default:
			throw new AtributoInvalidoException();
		}
	}
	
	/**
	 * Atualiza uma informacao, passada no atributo, de um item
	 * 
	 * @param item O item a ter uma informacao atualizada
	 * @param atributo A informacao a ser atualizada
	 * @param valor O novo valor da informacao atualizada
	 * @throws TemporadaMenorQue1Exception Caso a temporada seja menor que 1
	 * @throws NumberFormatException Caso o formato do ano passado seja invalido
	 * @throws AtributoInvalidoException 
	 */
	public static void atualizarItem(Item item, String atributo, String valor) throws TemporadaMenorQue1Exception, NumberFormatException, AtributoInvalidoException {
		
		switch (atributo.toLowerCase()) {
		case "nome":
			item.setNomeItem(valor);
			break;
		
		case "preco":
			item.setPreco(Double.parseDouble(valor));
			break;
			
		case "classificacao":
			item.setClassificacao(valor);
			break;
		
		case "duracao":
			item.setDuracao(Integer.parseInt(valor));
			break;
			
		case "genero":
			item.setGenero(valor);
			break;
		
		case "ano de lancamento":
			item.setAnoLancamento(Integer.parseInt(valor));
			break;
			
		case "artista":
			item.setNomeArtista(valor);
			break;
		
		case "numero de faixas":
			item.setNumeroFaixas(Integer.parseInt(valor));
			break;
			
		case "temporada":
			item.setTemporada(Integer.parseInt(valor));
			break;
			
		case "plataforma":
			item.setPlataforma(valor);
			break;
		
		default:
			throw new AtributoInvalidoException();
			
		}
	}

	/**
	 * Remove um item de uma lista de itens
	 * 
	 * @param item O item a ser removido
	 * @param itens A lista de itens da qual o item sera removido
	 */
	public static void removerItem(Item item, Set<Item> itens) {
		itens.remove(item);
	}
	
}

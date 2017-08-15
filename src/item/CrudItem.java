package item;

import java.util.ArrayList;
import java.util.List;

import FacadeEMain.Validacoes;

public class CrudItem {

	List<Item> itensDoSistema;

	public CrudItem() {
		itensDoSistema = new ArrayList<>();
	}

	public Item criaEletronico(String nomeItem, double preco, String plataforma) {
		Item jogoEletronico;

		if (Validacoes.validaPlataforma(plataforma)) {
			jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		} else {
			jogoEletronico = new JogoEletronico(nomeItem, preco, "OUTRO");
		}

		return jogoEletronico;
	}

	public static Item criaJogoTabuleiro(String nomeItem, double preco) {
		Item jogoTabuleiro = new JogoDeTabuleiro(nomeItem, preco);
		return jogoTabuleiro;
	}

	public static Item criaBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {
		Item filme;

		if (Validacoes.validaGenero(genero)) {
			filme = new Filme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		} else {
			filme = new Filme(nomeItem, preco, duracao, "OUTRO", classificacao, anoLancamento);
		}

		return filme;
	}

	public static Item criaBluRayShow(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		Item item = new Show(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		return item;
	}

	public static Item criaBluRaySerie(String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		Item serie;
		
		if (Validacoes.validaGenero(genero)) {
			serie = new Serie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		}
		else {
			serie = new Serie(nomeItem, preco, descricao, duracao, classificacao, "OUTRO", temporada);
		}
		
		return serie;
	}
}

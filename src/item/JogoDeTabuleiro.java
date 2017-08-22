package item;

import java.util.ArrayList;
import java.util.List;

import exception.PecaJaPerdidaException;
import exception.PecaPerdidaException;

/**
 * 
 *
 */
public class JogoDeTabuleiro extends Item{
	
	private List<String> pecasPerdidas;
	private final String LN = System.lineSeparator();
	
	/**
	 * Construtor do Jogo de Tabuleiro
	 * 
	 * @param nomeItem O nome do jogo
	 * @param preco O preco do jogo
	 */
	public JogoDeTabuleiro(String nomeItem, double preco) {
		super(nomeItem, preco);
		pecasPerdidas = new ArrayList<>();
	}
	
	/**
	 * Retorna as pecas perdidas do jogo
	 * 
	 * @return As pecas perdidas do jogo 
	 */
	public String getPecasPerdidas() {
		if (pecasPerdidas.size() == 1) {
			return pecasPerdidas.get(0);
		}
		
		String msg = "";
		
		for (String pecaPerdida : pecasPerdidas) {
			msg += pecaPerdida + LN;
		}
		
		return msg;
	}
	
	/**
	 * Adciona uma peca perdida ao jogo
	 * 
	 * @param nomePeca O nome da peca perdida
	 * @throws PecaJaPerdidaException Caso a peca perdida ja tenha sido adicionada
	 */
	public void adicionaPecaPerdida (String nomePeca) throws PecaJaPerdidaException {
		if (pecasPerdidas.contains(nomePeca)) {
			throw new PecaJaPerdidaException();
		}
		pecasPerdidas.add(nomePeca);
	}

	/**
	 * Retorna uma representacao textual do jogo de tabuleiro 
	 */
	@Override
	public String toString() {
		if (pecasPerdidas.isEmpty()) {
			return "JOGO DE TABULEIRO: " + super.toString() + ", COMPLETO";
		}
		
		return "JOGO DE TABULEIRO: " + super.toString() + ", COM PECAS PERDIDAS";
	}

	/**
	 * HashCode de jogo de tabuleiro
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	/**
	 * Equals de JogoDeTabuleiro
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoDeTabuleiro other = (JogoDeTabuleiro) obj;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}
	
}

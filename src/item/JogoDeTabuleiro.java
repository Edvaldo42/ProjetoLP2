package item;

import java.util.ArrayList;
import java.util.List;

public class JogoDeTabuleiro extends Item{
	
	private List<String> pecasPerdidas;
	private final String LN = System.lineSeparator();
	
	public JogoDeTabuleiro(String nomeItem, double preco) {
		super(nomeItem, preco);
		pecasPerdidas = new ArrayList<>();
	}
	
	public String listaPecas() {
		String msg = "";
		
		for (String pecaPerdida : pecasPerdidas) {
			msg += pecaPerdida + LN;
		}
		
		return msg;
	}
	
	public List<String> getPecasPerdidas() {
		return pecasPerdidas;
	}

	public String getLN() {
		return LN;
	}

	public void adicionaPecaPerdida (String nomePeca) {
		if (pecasPerdidas.contains(nomePeca)) {
			throw new IllegalArgumentException("Peca perdida ja registrada");
		}
		pecasPerdidas.add(nomePeca);
	}

	@Override
	public String toString() {
		return super.toString() + "Pecas perdidas:" + LN + listaPecas();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

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

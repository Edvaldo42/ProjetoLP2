package item;

import java.util.ArrayList;
import java.util.List;

public class JogoDeTabuleiro extends Item{
	
	private List<String> pecasPerdidas;
	private final String LN = System.lineSeparator();
	
	public JogoDeTabuleiro(String nomeDoItem, double valor) {
		super(nomeDoItem, valor);
		pecasPerdidas = new ArrayList<>();
	}
	
	public String listaPecas() {
		String msg = "";
		
		for (String pecaPerdida : pecasPerdidas) {
			msg += pecaPerdida + LN;
		}
		
		return msg;
	}
	
	public void adicionaPecaPerdida (String nomePeca) {
		pecasPerdidas.add(nomePeca);
	}

	@Override
	public String toString() {
		return super.toString() + "Pecas perdidas:" + LN + listaPecas();
	}
	
	
	
}

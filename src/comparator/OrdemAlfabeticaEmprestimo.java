package comparator;

import java.util.Comparator;

import emprestimo.Emprestimo;

public class OrdemAlfabeticaEmprestimo implements Comparator<Emprestimo> {
	
	@Override
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getItemEmprestado().compareTo(o2.getItemEmprestado());
	}

}

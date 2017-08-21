package comparator;

import java.util.Comparator;

import item.Item;

public class OrdenaPorVezesEmprestado implements Comparator<Item> {
	
	@Override
	public int compare(Item o1, Item o2) {
		if (o1.getVezesEmprestado() > o2.getVezesEmprestado()) {
			return -1;
		} else if (o1.getVezesEmprestado() < o2.getVezesEmprestado()) {
			return 1;
		} else {
			return 0;
		}
	}


}

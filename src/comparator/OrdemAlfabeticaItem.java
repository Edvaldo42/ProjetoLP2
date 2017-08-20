package comparator;

import java.util.Comparator;

import item.Item;

public class OrdemAlfabeticaItem implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getNomeDoItem().compareTo(o2.getNomeDoItem());
	}
	
}

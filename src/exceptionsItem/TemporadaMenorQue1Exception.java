package exceptionsItem;

import exceptionsComplementares.StringInvalidaException;

public class TemporadaMenorQue1Exception extends StringInvalidaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7224111229029278034L;

	public TemporadaMenorQue1Exception() {
		super ("Temporada nao pode ser menor do que 1");
	}
	
	public TemporadaMenorQue1Exception(String msg) {
		super(msg + "Temporada nao pode ser menor do que 1");
	}
}
